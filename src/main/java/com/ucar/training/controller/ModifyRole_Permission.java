package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.entity.Role_Permission;
import com.ucar.training.entity.User;
import com.ucar.training.services.impl.PermissionService;
import com.ucar.training.services.impl.RoleService;
import com.ucar.training.services.impl.Role_PermissionService;
import com.ucar.training.services.impl.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:training_servlet
 * @description:修改角色的权限
 * @author:linshaoxiong
 * @create:2019-08-22 16:50
 **/
public class ModifyRole_Permission extends HttpServlet {
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();
    private PermissionService permissionService = new PermissionService();
    private Role_PermissionService role_permissionService = new Role_PermissionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String[] permisionList = request.getParameterValues("permissionList");
        int role_id = roleService.selectRoleByUsername(username).getId();
        List<Permission> oldPermission = permissionService.selectAllByUsername(username);
        String oldPermissionList="";
        for(Permission p : oldPermission){
            oldPermissionList=oldPermissionList+","+p.getPermissionName();
        }
        int per_id;
        for (String pl : permisionList) {
            if(!oldPermissionList.contains(pl)){
                per_id = permissionService.getPermisionIdByName(pl).getId();
                System.out.println("perid="+per_id);
                roleService.addRolePermission(role_id,per_id,pl);
            }

        }




        ServletContext context = request.getServletContext();
        List<User> userList = userService.selectALL();
        //记录角色-权限信息
        Map<String,List<Permission>> rolePermissionMap = new HashMap<>();
        for(User tmpUser:userList){
            int roleId = roleService.selectRoleByUsername(tmpUser.getUsername()).getId();
            List<Permission> tmpPermission = roleService.selectPermissionByRoleId(roleId);
            rolePermissionMap.put(tmpUser.getUsername(),tmpPermission);
        }
        context.setAttribute("rolePermissionMap",rolePermissionMap);
        String message = "修改成功！";
        request.setAttribute("message",message);
        request.getRequestDispatcher("/role_permissionManger.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}