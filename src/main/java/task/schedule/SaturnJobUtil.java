package task.schedule;

import com.alibaba.fastjson.JSON;
import com.vip.saturn.job.SaturnJobReturn;
import com.vip.saturn.job.SaturnSystemErrorGroup;
import com.vip.saturn.job.SaturnSystemReturnCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Saturn定时任务工具类
 *
 * @author djh
 * @date 2022-10-24 21:09
 */
public class SaturnJobUtil {

    private static final Logger log = LoggerFactory.getLogger(SaturnJobUtil.class);

    /**
     * 默认任务成功提示信息
     */
    public static final String DEFAULT_JOB_SUCCESS_MESSAGE = "任务执行成功";

    public static final String PARAMETER_PARSE_EXCEPTION = "任务参数解析异常";

    /**
     * 工具类禁止实例化
     */
    private SaturnJobUtil() {
    }

    /**
     * 任务成功默认返回对象
     */
    public static SaturnJobReturn jobSuccess() {
        return jobSuccess(DEFAULT_JOB_SUCCESS_MESSAGE);
    }

    /**
     * 任务成功返回对象
     *
     * @param message 成功信息
     */
    public static SaturnJobReturn jobSuccess(String message) {
        SaturnJobReturn result = new SaturnJobReturn();
        result.setReturnCode(SaturnSystemReturnCode.SUCCESS);
        result.setErrorGroup(SaturnSystemErrorGroup.SUCCESS);
        result.setReturnMsg(message);
        return result;
    }

    /**
     * 任务超时错误
     *
     * @param errorCode    错误代码
     * @param errorMessage 错误信息
     */
    public static SaturnJobReturn jobTimeout(int errorCode, String errorMessage) {
        SaturnJobReturn result = new SaturnJobReturn();
        result.setErrorGroup(SaturnSystemErrorGroup.TIMEOUT);
        result.setReturnCode(errorCode);
        result.setReturnMsg(errorMessage);
        return result;
    }

    /**
     * 带默认返回代码的一般任务失败（不会触发告警）
     *
     * @param errorMessage 错误信息
     */
    public static SaturnJobReturn generalJobFailed(String errorMessage) {
        return generalJobFailed(SaturnSystemReturnCode.SYSTEM_FAIL, errorMessage);
    }

    /**
     * 因任务参数解析异常导致的任务失败
     */
    public static SaturnJobReturn jobFailedWhileParsingParameters() {
        return generalJobFailed(PARAMETER_PARSE_EXCEPTION);
    }

    /**
     * 一般任务失败（不会触发告警）
     *
     * @param errorCode    错误代码
     * @param errorMessage 错误信息
     */
    public static SaturnJobReturn generalJobFailed(int errorCode, String errorMessage) {
        SaturnJobReturn result = new SaturnJobReturn();
        result.setErrorGroup(SaturnSystemErrorGroup.FAIL);
        result.setReturnCode(errorCode);
        result.setReturnMsg(errorMessage);
        return result;
    }

    /**
     * 带默认返回代码的关键任务失败（将触发告警）
     *
     * @param errorMessage 错误信息
     */
    public static SaturnJobReturn criticalJobFailed(String errorMessage) {
        return criticalJobFailed(SaturnSystemReturnCode.SYSTEM_FAIL, errorMessage);
    }

    /**
     * 关键任务失败（将触发告警）
     *
     * @param errorCode    错误代码
     * @param errorMessage 错误信息
     */
    public static SaturnJobReturn criticalJobFailed(int errorCode, String errorMessage) {
        SaturnJobReturn result = new SaturnJobReturn();
        result.setErrorGroup(SaturnSystemErrorGroup.FAIL_NEED_RAISE_ALARM);
        result.setReturnCode(errorCode);
        result.setReturnMsg(errorMessage);
        return result;
    }

    /**
     * 解析任务运行参数
     * 所有参数解析工作最好都在这里完成
     * 包括对默认值的处理，必要参数不允许返回空，避免任务执行时引发NPE
     *
     * @param jobParameterString 任务参数JSON字符串
     * @param jobParametersClass 任务参数类类型
     * @param <T>                任务参数类
     * @return 任务运行参数
     * @throws Exception 解析异常
     */
    public static <T> T parseJobParameters(String jobParameterString, Class<T> jobParametersClass) throws Exception {
        T jobParameters;

        Constructor<T> defaultConstructor = jobParametersClass.getConstructor();
        defaultConstructor.setAccessible(true);

        if (StringUtils.isBlank(jobParameterString)) {
            // 空值则全部使用默认值填充
            jobParameters = defaultConstructor.newInstance();
            checkAndSetDefaultValue(jobParameters, jobParametersClass);
            return jobParameters;
        }

        //　参数解析
        try {
            jobParameters = JSON.parseObject(jobParameterString, jobParametersClass);
        } catch (Exception e) {
            jobParameters = defaultConstructor.newInstance();
        }

        // 参数默认值校验与填充
        checkAndSetDefaultValue(jobParameters, jobParametersClass);

        return jobParameters;

    }

    /**
     * 检查并为参数填充默认值
     *
     * @param jobParameters      任务参数JSON字符串
     * @param jobParametersClass 任务参数类类型
     * @param <T>                任务参数类
     * @throws Exception 解析异常
     */
    private static <T> void checkAndSetDefaultValue(T jobParameters, Class<T> jobParametersClass) throws Exception {
        String jobName;
        JobParameter classAnnotation = jobParametersClass.getAnnotation(JobParameter.class);

        if (classAnnotation != null) {
            jobName = classAnnotation.jobName();
        } else {
            jobName = "请在类" + jobParametersClass + "使用@JobParameter注解指定任务名称";
        }

        // 检查参数各必须字段是否都配置了值，没有则使用默认值填充
        Field[] fields = jobParametersClass.getDeclaredFields();
        for (Field field : fields) {
            JobParameterField fieldAnnotation = field.getAnnotation(JobParameterField.class);
            // 没有使用@JobParameterField注解的则无需处理
            if (fieldAnnotation == null) {
                continue;
            }

            // 任务是否需要此参数
            boolean required = fieldAnnotation.required();
            if (!required) {
                continue;
            }

            // 空值检查
            field.setAccessible(true);
            if (field.get(jobParameters) != null) {
                continue;
            }

            // 默认值填充
            String defaultValueString = fieldAnnotation.defaultValue();
            String desc = fieldAnnotation.desc();
            Class<?> fieldType = field.getType();
            String format = fieldAnnotation.format();
            String pattern = fieldAnnotation.pattern();
            boolean isDateEl = fieldAnnotation.isDateEl();

            log.warn("未配置 [{}] {}参数，采用默认值：{}", jobName, desc, defaultValueString);

            // 日期EL表达式处理
            if (isDateEl) {
                Date date = evaluateDateEl(defaultValueString);
                injectDate(date, format, field, jobParameters);
                continue;
            }

            // 日期类型处理
            if (StringUtils.isNoneBlank(pattern) || Date.class.equals(fieldType)) {
                Date date = new SimpleDateFormat(pattern).parse(defaultValueString);
                injectDate(date, format, field, jobParameters);
                continue;
            }

            // 字符串
            if (String.class.equals(fieldType)) {
                field.set(jobParameters, defaultValueString);
                continue;
            }

            // 整型
            if (Integer.class.equals(fieldType)) {
                field.set(jobParameters, Integer.parseInt(defaultValueString));
                continue;
            }

            // 长整型
            if (Long.class.equals(fieldType)) {
                field.set(jobParameters, Long.parseLong(defaultValueString));
                continue;
            }

            // 双精浮点型
            if (Double.class.equals(fieldType)) {
                field.set(jobParameters, Double.parseDouble(defaultValueString));
                continue;
            }

            // 其他类型
            try {
                field.set(jobParameters, JSON.parseObject(defaultValueString, fieldType));
            } catch (Exception e) {
                log.warn("解析 [{}] {}参数默认异常，异常值：{}", jobName, desc, defaultValueString);
                // 必填参数默认值解析失败必须抛异常，宁可让任务不执行也不要让参数值为null，避免NPE
                throw e;
            }

        }
    }

    /**
     * 日期EL表达式中的时间偏移类型
     */
    private static final String OFFSET_TYPE_YEAR = "y";
    private static final String OFFSET_TYPE_MONTH = "M";
    private static final String OFFSET_TYPE_DAY = "d";
    private static final String OFFSET_TYPE_HOUR = "H";
    private static final String OFFSET_TYPE_MINUTE = "m";
    private static final String OFFSET_TYPE_SECOND = "s";

    /**
     * 日期EL表达式检测正则
     */
    private static final Pattern DATE_EL_PATTERN = Pattern.compile("now\\((\\s?([+-]\\d+)([ymdHMS])\\s?)?\\)", Pattern.CASE_INSENSITIVE);

    /**
     * 日期类型注入
     *
     * @param date   日期
     * @param format 格式
     * @param field  参数字段
     * @param target 参数对象
     * @throws Exception 注入异常
     */
    private static void injectDate(Date date, String format, Field field, Object target) throws Exception {
        Class<?> fieldType = field.getType();
        if (Date.class.equals(fieldType)) {
            field.set(target, date);
            return;
        }

        if (String.class.equals(fieldType)) {
            field.set(target, new SimpleDateFormat(format).format(date));
            return;
        }

        if (Long.class.equals(fieldType)) {
            field.set(target, date.getTime());
            return;
        }

        log.error("日期注入失败：无法将java.util.Date类型转换为{}类型", fieldType);
        throw new RuntimeException("can't convert java.util.Date to " + fieldType);
    }

    /**
     * 评估执行日期EL表达式
     *
     * @param dateEl 日期EL表达式
     * @return 表达式结果
     */
    private static Date evaluateDateEl(String dateEl) {
        Matcher matcher = DATE_EL_PATTERN.matcher(dateEl);
        if (!matcher.matches()) {
            throw new RuntimeException("expression format mismatch: " + dateEl);
        }

        // 执行el表达式，计算日期
        Calendar calendar = Calendar.getInstance();
        String offsetType = matcher.group(3);
        if (offsetType == null) {
            return calendar.getTime();
        }

        int offset = Integer.parseInt(matcher.group(2));
        int calendarField;

        switch (offsetType) {
            case OFFSET_TYPE_YEAR:
                calendarField = Calendar.YEAR;
                break;
            case OFFSET_TYPE_MONTH:
                calendarField = Calendar.MONTH;
                break;
            case OFFSET_TYPE_DAY:
                calendarField = Calendar.DAY_OF_MONTH;
                break;
            case OFFSET_TYPE_HOUR:
                calendarField = Calendar.HOUR_OF_DAY;
                break;
            case OFFSET_TYPE_MINUTE:
                calendarField = Calendar.MINUTE;
                break;
            case OFFSET_TYPE_SECOND:
                calendarField = Calendar.SECOND;
                break;
            default:
                calendarField = 0;
        }
        calendar.add(calendarField, offset);
        return calendar.getTime();
    }
}
