package com.lengedyun.springbootmybaitis.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(public * com.lengedyun.springbootmybaitis.controller.AspectController.login*(..)) && @annotation(com.lengedyun.springbootmybaitis.annotation.LoginCheck)")
    public void loginAuth() {
    }

    @Around("loginAuth()")
    public Object Interceptor(ProceedingJoinPoint point) {
        Object result = null;
        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            if (args.length == 1) {
                if (String.class == args[0].getClass()) {
                    if ("zjy".equals(args[0])) {
                        return "welcome zjy";
                    }
                }
                if (Integer.class == args[0].getClass()) {
                    if (Integer.parseInt(args[0].toString()) > 1000) {
                        return " very welcome ";
                    }
                }

            }
            if (args.length == 2) {
                String username = (String) args[0];
                String pwd = args[1].toString();
                if ("zjyun".equals(username) && "nb".equals(pwd)) {
                    return "welcome too";
                }
            }

            return "滚犊子";

        }
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
