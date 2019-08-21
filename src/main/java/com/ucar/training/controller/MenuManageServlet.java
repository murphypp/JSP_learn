package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.service.IPermissionService;
import com.ucar.training.service.impl.PermissionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MenuManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delete = req.getParameter("delete");
        String update = req.getParameter("update");
        //String add = req.getParameter("add");
        String toUpdate = req.getParameter("toUpdate");
        String toAdd = req.getParameter("toAdd");
        IPermissionService permissionService = new PermissionServiceImpl();
        if(toAdd != null){
            Permission permission = new Permission();
            int mid = Integer.parseInt(req.getParameter("mid"));
            permission.setMid(mid);
            String mname = req.getParameter("mname");
            permission.setMname(mname);
            String uri = req.getParameter("uri");
            permission.setUri(uri);

            permissionService.addPermission(permission);
            permissionService.close();
            resp.sendRedirect("menuManage");
            return;
        }
        if(delete != null){
            int mid = Integer.parseInt(req.getParameter("delete"));
            Permission permission = permissionService.getPermissionById(mid);
            permissionService.delPermission(permission);
            permissionService.close();
            resp.sendRedirect("menuManage");
        }
        if(update != null){
            int mid = Integer.parseInt(req.getParameter("update"));
            Permission permission = permissionService.getPermissionById(mid);
            req.setAttribute("updating",permission);
            req.getRequestDispatcher("updateMenu.jsp").forward(req,resp);
            return;
        }
        if(toUpdate != null){
            Permission permission = new Permission();
            int mid = Integer.parseInt(req.getParameter("mid"));
            permission.setMid(mid);
            String mname = req.getParameter("mname");
            permission.setMname(mname);
            String uri = req.getParameter("uri");
            permission.setUri(uri);

            permissionService.updatePermission(permission);
            permissionService.close();
            resp.sendRedirect("menuManage");
            return;
        }
        List<Permission> permissions = permissionService.getAllPermission();
        req.setAttribute("permissions",permissions);
        req.getRequestDispatcher("menuManage.jsp").forward(req,resp);
    }
}
