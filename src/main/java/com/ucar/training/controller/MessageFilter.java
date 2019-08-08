package com.ucar.training.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageFilter implements Filter {
    private static String[] badWords;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        badWords = filterConfig.getInitParameter("badWords").split(",") ;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String message = servletRequest.getParameter("message");
        servletRequest.setAttribute("warning","");

        if (isContain(message)){
            servletRequest.setAttribute("warning","包含禁用词汇");
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
    private boolean isContain(String message){
        for (String x: badWords
             ) {
            if(message.contains(x)){
                return true;
            }
        }
        return false;
    }
}
