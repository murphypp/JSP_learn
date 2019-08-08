package com.ucar.training.controller;

import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.entity.User;
import com.ucar.training.service.IService;
import com.ucar.training.service.impl.IServiceImpl;

import javax.servlet.*;

public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context初始化了");
        ServletContext context = servletContextEvent.getServletContext();
        IService service = new IServiceImpl();
        User admin = new User("admin1","123456","21","male","sing","233");
        admin.setAuthority("admin");
        User user = new User("qqq123","123456","22","female","reading","hhhhhh");
        service.addUser(admin);
        service.addUser(user);
        context.setAttribute("allUser",service.getAllUser());

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
