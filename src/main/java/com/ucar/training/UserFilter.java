package com.ucar.training;

import javax.servlet.*;
import java.io.IOException;


/**
 * @program:training_servlet
 * @description:过滤指定用户的注册
 * @author:linshaoxiong
 * @create:2019-08-02 11:30
 **/
public class UserFilter implements Filter {
    private String blackList;
    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("userfilter running...");
        blackList = filterConfig.getInitParameter("blackList");
        System.out.println(blackList);
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException{
        String user = request.getParameter("username");
        System.out.println(user);
        if(blackList.contains(user)){
            request.setAttribute("message","您是黑名单用户！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else{
            chain.doFilter(request,response);
        }

    }




}
