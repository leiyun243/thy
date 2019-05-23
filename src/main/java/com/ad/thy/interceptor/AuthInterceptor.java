package com.ad.thy.interceptor;

import com.ad.thy.annotation.AuthAnnotation;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){

            Method method = ((HandlerMethod) handler).getMethod();

            AuthAnnotation auth = method.getAnnotation(AuthAnnotation.class);

            if(auth != null){

                String menth_str = auth.value();
                String url = "/thy/user/toUserList";
                if(!url.contains(menth_str)){

                    response.sendRedirect("/thy/noAuth");
                }

            }

        }



        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

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
