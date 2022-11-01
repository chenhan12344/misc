package task.schedule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author djh
 * @date 2022-10-28 15:45
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JobParameterField {

    /**
     * 字段是否必填
     *
     * @return 默认必填
     */
    boolean required() default true;

    /**
     * 字段说明
     */
    String desc();

    /**
     * 默认值
     */
    String defaultValue();

    /**
     * 是否是日期EL表达式
     */
    boolean isDateEl() default false;

    /**
     * 日期格式器格式
     * 用于将值注入参数时进行格式化
     */
    String format() default "";

    /**
     * 日期解析器格式
     * 用于解析默认值
     */
    String pattern() default "";
}
