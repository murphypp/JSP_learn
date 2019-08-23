package com.ucar.training.controller;

import com.mysql.cj.Session;
import com.ucar.training.entity.Permission;
import com.ucar.training.entity.User;
import com.ucar.training.services.impl.PermissionService;
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
 * @description:修改权限
 * @author:linshaoxiong
 * @create:2019-08-22 09:05
 **/
public class ModifyPermission extends HttpServlet {
    private PermissionService permissionService = new PermissionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =Integer.parseInt(request.getParameter("id")) ;
        String permissionName = request.getParameter("permissionName");
        String permissionUrl = request.getParameter("permissionUrl");
        Permission tmpPermission = new Permission(id,permissionName,permissionUrl);



        if(permissionService.modifyPermission(tmpPermission)){
            List<Permission> permissionListAll = permissionService.selectAll();
            ServletContext context = request.getServletContext();
            context.setAttribute("permissionListAll",permissionListAll);
            String message = "修改成功！";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/permissionManager.jsp").forward(request,response);
        }else{
            String message = "修改失败！";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/permissionManager.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}