package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.entity.User;
import com.ucar.training.service.IRoleService;
import com.ucar.training.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CheckRoleServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("current");
        if(user == null)resp.sendRedirect("login.jsp");
        IRoleService roleService = new RoleServiceImpl();
        Role role = null;
        if (user != null) {
            role = roleService.getRoleByUsername(user.getUsername());
        }
        req.getSession().setAttribute("currentRole",role);
        List<Permission> permissions = null;
        if (role != null) {
            permissions = role.getPermissions();
        }
        req.setAttribute("permissions",permissions);
        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }
}
