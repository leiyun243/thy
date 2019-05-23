package com.ad.thy.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogAnnotation {

    String logName() default "";

    String logContent() default "";

}
