package com.ucar.training.controller;

import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.service.IService;
import com.ucar.training.service.impl.IServiceImpl;

import javax.servlet.*;

public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context初始化了");
        ServletContext context = servletContextEvent.getServletContext();
        Object obj =context.getAttribute("allUser");
        if(obj == null){
            IService service = new IServiceImpl();
            context.setAttribute("allUser",service.getAllUser());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        System.out.println("监听器：Context添加了属性：" + name);

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

    }
}
