package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.service.IPermissionService;
import com.ucar.training.service.IRoleService;
import com.ucar.training.service.impl.PermissionServiceImpl;
import com.ucar.training.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RoleManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IRoleService roleService = new RoleServiceImpl();
        IPermissionService permissionService = new PermissionServiceImpl();
        String delete = req.getParameter("delete");
        String update = req.getParameter("update");
        String add = req.getParameter("add");
        String toAdd = req.getParameter("toAdd");
        String toUpdate = req.getParameter("toUpdate");

        if(delete != null){
            Role role = new Role();
            int rid = Integer.parseInt(req.getParameter("rid"));
            role.setRid(rid);
            String rname = req.getParameter("rname");
            role.setRname(rname);
            roleService.delRolePermissions(rid);
            roleService.delRole(role);
            roleService.close();
            resp.sendRedirect("roleManage");
            return;
        }
        if(update != null){
            int rid = Integer.parseInt(req.getParameter("rid"));
            Role role = roleService.getRoleById(rid);

            req.setAttribute("updatingRole",role);
            req.setAttribute("permissions",permissionService.getAllPermission());
            req.getRequestDispatcher("updateRole.jsp").forward(req,resp);
            return;
        }
        if (add != null ){
            List<Permission> permissions = permissionService.getAllPermission();
            req.setAttribute("permissions",permissions);
            req.getRequestDispatcher("addRole.jsp").forward(req,resp);
            return;
        }
        if(toAdd != null){
            Role role = new Role();
            int rid = Integer.parseInt(req.getParameter("rid"));
            role.setRid(rid);
            String rname = req.getParameter("rname");
            role.setRname(rname);
            roleService.addRole(role);
            String [] permissions = req.getParameterValues("permission");
            roleService.addRolePermission(rid,permissions);
            roleService.close();
            resp.sendRedirect("roleManage");
            return;
        }
        if(toUpdate != null){
            int rid = Integer.parseInt(req.getParameter("rid"));
            String rname = req.getParameter("rname");
            String[] permissions = req.getParameterValues("permission");
            roleService.delRolePermissions(rid);
            roleService.addRolePermission(rid,permissions);
            roleService.close();
            resp.sendRedirect("roleManage");
            return;
        }
        List<Role> roles = roleService.getAllRoles();
        req.setAttribute("roles",roles);
        req.getRequestDispatcher("roleManage.jsp").forward(req,resp);
    }
}
