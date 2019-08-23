package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.services.impl.PermissionService;

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
 * @description:删除权限
 * @author:linshaoxiong
 * @create:2019-08-22 09:05
 **/
public class DeletePermission extends HttpServlet {
    private PermissionService permissionService = new PermissionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id")) ;

        if(permissionService.deletePermission(id)) {
            List<Permission> permissionListAll = permissionService.selectAll();
            ServletContext context = req.getServletContext();
            context.setAttribute("permissionListAll",permissionListAll);
            System.out.println("删除成功，执行跳转");
            String message = "删除成功！";
            req.setAttribute("message",message);
            req.getRequestDispatcher("/permissionManager.jsp").forward(req,resp);
        }else{
            String message = "删除失败！";
            req.setAttribute("message",message);
            req.getRequestDispatcher("/permissionManager.jsp").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
