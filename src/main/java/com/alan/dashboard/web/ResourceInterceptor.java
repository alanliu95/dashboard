package com.alan.dashboard.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//HandlerInterceptor
public class ResourceInterceptor extends HandlerInterceptorAdapter {
    public static Logger logger = LoggerFactory.getLogger(ResourceInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();
        logger.debug("preHandle url:" + url);
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null)
            return true;
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        logger.debug("postHandle url:" + request.getRequestURI());
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println("ResourceInterceptor, afterCompletion......");
    }

    @Override
    public void afterConcurrentHandlingStarted(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //System.out.println("ResourceInterceptor, afterConcurrentHandlingStarted......");
    }
}
