package com.lengedyun.springbootmybaitis.aspect;

import com.lengedyun.springbootmybaitis.annotation.LogRecord;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zjy
 * @title: LogRecordAspect
 * @projectName springbootmybatis
 * @description: TODO
 * @date 2019/6/29 10:11
 */
@Component
@Aspect
public class LogRecordAspect {

    @Pointcut("@annotation(com.lengedyun.springbootmybaitis.annotation.LogRecord)")
    private void logRecordCut(){}

    //环绕通知
    @Around(value = "logRecordCut()")
    private Object logRecordAround(ProceedingJoinPoint joinPoint){
        Object returnValue = null;
        try {
            //方法调用之前
            System.out.println("--------before invoke-------");
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                System.out.println("arg["+i+"]:"+arg);
            }
            returnValue = joinPoint.proceed();//方法调用 有返回值的方法，此处除了接收返回值之外还要将返回值返回出去
            chuandi(joinPoint);
            System.out.println("return value:"+returnValue);
            //获取方法上的注解
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            //Method method = methodSignature.getMethod();
            Object target = joinPoint.getTarget();
            Method method = target.getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
            final Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println(declaredAnnotation);
            }
            //LogRecord logRecord = method.getAnnotation(LogRecord.class);
            LogRecord logRecord = method.getDeclaredAnnotation(LogRecord.class);
            //joinPoint.proceed();//方法调用 无返回值的方法可以这么写
            System.out.println(logRecord.tableName());
            //方法调用之后
            System.out.println("--------after invoke-------");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  returnValue;
    }

    private void chuandi(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LogRecord logRecord = method.getDeclaredAnnotation(LogRecord.class);
        System.out.println("&&&&&&&&:"+logRecord.tableName());
    }
}
