package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordFilter implements Filter {
    static private List<String> words = new ArrayList<>();
    static {
        words.add("666");
    }
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String note = req.getParameter("info");
        for(String str:words){
            if(note.contains(str))
                note.replaceAll(str,"***");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
