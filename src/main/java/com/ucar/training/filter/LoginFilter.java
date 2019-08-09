package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)req).getSession();
        String username =(String) session.getAttribute("user");
        StringBuffer path = ((HttpServletRequest) req).getRequestURL();
        if(path.indexOf("/")>-1){
            chain.doFilter(req, resp);
            return;
        }
        if(path.indexOf("/login.jsp")>-1){
            chain.doFilter(req, resp);
            return;
        }
        if(path.indexOf("/register.jsp")>-1){
            chain.doFilter(req,resp);
            return;
        }
        if(path.indexOf("/LoginCheck")>-1){
            chain.doFilter(req,resp);
            return;
        }
        if(path.indexOf("/RegisterCheck")>-1){
            chain.doFilter(req,resp);
            return;
        }
        if(path.indexOf("/RegisterServlet")>-1){
            chain.doFilter(req,resp);
            return;
        }

        if(username!=null){
            chain.doFilter(req,resp);
        }else {
            String message = "请先登录！";
            req.setAttribute("message",message);
            req.getRequestDispatcher("/login.jsp").forward(req,resp );
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
