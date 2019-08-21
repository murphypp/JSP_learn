package com.ucar.training.controller;

import com.ucar.training.dao.IPermissionDao;
import com.ucar.training.entity.Permission;
import com.ucar.training.service.IPermissionService;
import com.ucar.training.service.impl.PermissionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        IPermissionService permissionService= new PermissionServiceImpl();
        Permission permission = permissionService.getPermissionByName(action);
        if(permission == null){
           return;
        }
        req.getRequestDispatcher(permission.getUri()).forward(req,resp);
    }
}
