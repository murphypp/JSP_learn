package com.ucar.training.controller;

import com.ucar.training.entity.Role;
import com.ucar.training.entity.Role;
import com.ucar.training.services.impl.RoleService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program:training_servlet
 * @description:增加角色
 * @author:linshaoxiong
 * @create:2019-08-22 14:14
 **/
public class AddRole extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String roleName = req.getParameter("roleName");
        String rolePs = req.getParameter("rolePs");
        Role role = new Role(id,roleName,rolePs);

        if (roleService.addRole(role)) {
            List<Role> roleListAll = roleService.selectAll();
            ServletContext context = req.getServletContext();
            context.setAttribute("roleListAll", roleListAll);
            String message = "新增成功！";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/roleManager.jsp").forward(req, resp);
        } else {
            String message = "新增失败！";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/roleManager.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
