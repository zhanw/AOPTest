package com.example.zhangwei.aoptest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangwei on 2017/5/21.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface BehaviorTrace {
    String value();
}
