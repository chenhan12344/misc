package task.schedule;

import com.vip.saturn.job.AbstractSaturnJavaJob;
import com.vip.saturn.job.SaturnJobExecutionContext;
import com.vip.saturn.job.SaturnJobReturn;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 01397356
 * @date 2022-11-01 10:34
 */
@Slf4j
@Component
public class DemoJob extends AbstractSaturnJavaJob {

    private static final String JOB_NAME_CN = "测试定时任务";

    @Override
    public SaturnJobReturn handleJavaJob(String s, Integer integer, String s1, SaturnJobExecutionContext saturnJobExecutionContext) throws InterruptedException {
        String jobParameterString = saturnJobExecutionContext.getJobParameter();
        MyJobParameters jobParameters;
        try {
            jobParameters = SaturnJobUtil.parseJobParameters(jobParameterString, MyJobParameters.class);
        } catch (Exception e) {
            log.error("任务参数解析失败", e);
            return SaturnJobUtil.jobFailedWhileParsingParameters();
        }


        try {
            // 业务逻辑
            Integer dealDays = jobParameters.getDealDays();
            String startDate = jobParameters.getStartDate();
            String endDate = jobParameters.getEndDate();
            String deptCode = jobParameters.getDeptCode();
            Date bizDate = jobParameters.getBizDate();

            System.out.println(dealDays + startDate + endDate + deptCode + bizDate);
            return SaturnJobUtil.jobSuccess();
        } catch (Exception e) {
            log.error("[{}] 执行异常", JOB_NAME_CN, e);
            return SaturnJobUtil.generalJobFailed(e.getMessage());
        }

    }

    public static void main(String[] args) throws Exception {

        // 模拟参数解析
        MyJobParameters jobParameters = SaturnJobUtil.parseJobParameters(
                "{\"bizDate\":\"now(-15d)\"}", MyJobParameters.class);

        Integer dealDays = jobParameters.getDealDays();
        System.out.println("dealDays: " + dealDays);

        String startDate = jobParameters.getStartDate();
        System.out.println("startDate: " + startDate);

        String endDate = jobParameters.getEndDate();
        System.out.println("endDate: " + endDate);

        String deptCode = jobParameters.getDeptCode();
        System.out.println("deptCode: " + deptCode);

        Date bizDate = jobParameters.getBizDate();
        System.out.println("bizDate: " + bizDate);

        String deadlineDate = jobParameters.getDeadlineDate();
        System.out.println("deadlineDate: " + deadlineDate);


    }

    @Data
    @JobParameter(jobName = JOB_NAME_CN)
    private static class MyJobParameters {

        @JobParameterField(desc = "处理天数", defaultValue = "3")
        private Integer dealDays;

        @JobParameterField(desc = "网点代码", defaultValue = "001")
        private String deptCode;

        @JobParameterField(desc = "开始日期", defaultValue = "now()", isDateEl = true, format = "yyyy-MM-dd")
        private String startDate;

        @JobParameterField(desc = "结束日期", defaultValue = "now(-1d)", isDateEl = true, format = "yyyy-MM-dd")
        private String endDate;

        @JobParameterField(desc = "业务日期", defaultValue = "2022-12-13", pattern = "yyyy-MM-dd")
        private Date bizDate;

        @JobParameterField(desc = "截止日期", defaultValue = "now(+30d)", isDateEl = true, format = "yyyy-MM-dd")
        private String deadlineDate;
    }
}
