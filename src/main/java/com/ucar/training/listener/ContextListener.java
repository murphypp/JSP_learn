package com.ucar.training.listener;

import com.ucar.training.entity.User;
import com.ucar.training.service.IUserService;
import com.ucar.training.service.impl.UserServiceImpl;
import com.ucar.training.utils.DBUtil;

import javax.servlet.*;

public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context初始化了");
        new DBUtil();
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
