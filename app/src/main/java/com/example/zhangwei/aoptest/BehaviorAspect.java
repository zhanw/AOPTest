package com.example.zhangwei.aoptest;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by zhangwei on 2017/5/21.
 */

@Aspect
public class BehaviorAspect {

    private static final String TAG = "BehaviorAspect";
    private String mName;

    @Pointcut("execution(@com.example.zhangwei.aoptest.BehaviorTrace * *(..))")
    public void annoBehavior(){

    }

    @Around("annoBehavior()")
    public Object dealPoint(ProceedingJoinPoint point){

        MethodSignature signature = (MethodSignature) point.getSignature();
        BehaviorTrace behaviorTrace = signature.getMethod().getAnnotation(BehaviorTrace.class);
        mName = signature.getMethod().getName();
        String value = behaviorTrace.value();
        System.out.println("before method");
        long start = System.currentTimeMillis();
        Object object = null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.d(TAG, value + "cost time " + (System.currentTimeMillis()-start) + "ms");
        Log.d(TAG, "method name " + mName);

        return object;

    }

}
