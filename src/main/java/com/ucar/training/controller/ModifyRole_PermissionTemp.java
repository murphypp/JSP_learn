package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.services.impl.PermissionService;
import com.ucar.training.services.impl.RoleService;
import com.ucar.training.services.impl.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @program:training_servlet
 * @description:中转Jsp页面信息
 * @author:linshaoxiong
 * @create:2019-08-23 10:19
 **/
public class ModifyRole_PermissionTemp extends HttpServlet {
    private UserService userService = new UserService();
    private PermissionService permissionService = new PermissionService();
    private RoleService roleService = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        //记录临时权限表信息
        List<Permission> permissionList = permissionService.selectAllByUsername(username);
        session.setAttribute("tmpPermissionList",permissionList);
        req.getRequestDispatcher("modifyRole_Permission.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
