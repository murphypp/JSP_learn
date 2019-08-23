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
 * @description:修改角色表信息
 * @author:linshaoxiong
 * @create:2019-08-22 14:04
 **/
public class ModifyRole extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =Integer.parseInt(request.getParameter("id")) ;
        String roleName = request.getParameter("roleName");
        String rolePs = request.getParameter("rolePs");
        Role tmpRole = new Role(id,roleName,rolePs);



        if(roleService.modifyRole(tmpRole)){
            List<Role> roleListAll = roleService.selectAll();
            ServletContext context = request.getServletContext();
            context.setAttribute("roleListAll",roleListAll);
            String message = "修改成功！";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/roleManager.jsp").forward(request,response);
        }else{
            String message = "修改失败！";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/roleManager.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
