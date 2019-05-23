package com.ad.thy.aspect;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ad.thy.annotation.SysLogAnnotation;
import com.ad.thy.vo.UserVO;
import org.apache.catalina.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

@Aspect
@Component
public class SysLogAspect {

    @Pointcut("execution(public * com.ad.thy.controller.*.*(..))")
    public void pointCut(){}

    @After("pointCut()")
    public void afterLog(JoinPoint joinPoint){


        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        UserVO userVO = (UserVO) request.getSession().getAttribute("user_info");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();

        SysLogAnnotation annotation = method.getAnnotation(SysLogAnnotation.class);
        if(annotation != null){
            String logName = annotation.logName();
            String logContent = annotation.logContent();

            if(userVO != null){
                logContent = userVO.getRealName()+logContent;
            }

            System.err.println("日志名称====>"+logName);
            System.err.println("日志内容====>"+logContent);
            System.err.println("请求的url====>"+getUrlParams(request));

        }


    }


    private String getUrlParams(HttpServletRequest request){
        String param = "";
        Enumeration<String> keys = request.getParameterNames();
        StringBuffer stringBuffer = new StringBuffer();
        while(keys.hasMoreElements()) {
            String ele = keys.nextElement();
            stringBuffer.append("&").append(ele).append("=").append(request.getParameter(ele));
        }
        param = stringBuffer.toString();
        String requestURL = request.getRequestURI();
        return requestURL + (param.replaceFirst("&", "?"));

    }
}
