package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.services.impl.PermissionService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program:training_servlet
 * @description:增加权限
 * @author:linshaoxiong
 * @create:2019-08-22 14:14
 **/
public class AddPermission extends HttpServlet {
    private PermissionService permissionService = new PermissionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String permissionName = req.getParameter("permissionName");
        String permissionUrl = req.getParameter("permissionUrl");
        Permission permission = new Permission(id, permissionName, permissionUrl);

        if (permissionService.addPermission(permission)) {
            List<Permission> permissionListAll = permissionService.selectAll();
            ServletContext context = req.getServletContext();
            context.setAttribute("permissionListAll", permissionListAll);
            String message = "新增成功！";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/permissionManager.jsp").forward(req, resp);
        } else {
            String message = "新增失败！";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/permissionManager.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
