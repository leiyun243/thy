package com.ad.thy.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LoginCheckAspect {

    @Pointcut("execution(public * com.ad.thy.controller..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doSomething(JoinPoint joinPoint){

        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String requstURI = request.getRequestURI();
        String method = request.getMethod();
        System.out.println("uri="+requstURI+";method="+method);


    }

}
