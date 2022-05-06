package com.ssmstudy.dubbo.spi.dubboSpi;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MySPI {

    String value() default "";
}
