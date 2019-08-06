package com.ucar.training.filter;

import javax.servlet.*;
import java.io.IOException;


/**
 * @program:training_servlet
 * @description:字符串编码过滤器
 * @author:linshaoxiong
 * @create:2019-08-02 11:16
 **/
public class CharactorFilter implements Filter {
    String encoding = null;
    public  void  destroy(){
        encoding=null;
    }
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding=filterConfig.getInitParameter("CharsetEncoding");

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {
/*
        System.out.println("characterfilter running...");
*/
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        chain.doFilter(request,response);
    }


}
