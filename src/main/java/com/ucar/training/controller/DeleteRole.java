package com.ucar.training.controller;

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
 * @description:删除角色
 * @author:linshaoxiong
 * @create:2019-08-22 14:01
 **/
public class DeleteRole extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id")) ;

        if(roleService.deleteRole(id)) {
            List<Role> roleListAll = roleService.selectAll();
            ServletContext context = req.getServletContext();
            context.setAttribute("roleListAll",roleListAll);
            System.out.println("删除成功，执行跳转");
            String message = "删除成功！";
            req.setAttribute("message",message);
            req.getRequestDispatcher("/roleManager.jsp").forward(req,resp);
        }else{
            String message = "删除失败！";
            req.setAttribute("message",message);
            req.getRequestDispatcher("/roleManager.jsp").forward(req,resp);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
