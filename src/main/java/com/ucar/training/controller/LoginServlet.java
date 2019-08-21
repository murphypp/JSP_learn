package com.ucar.training.controller;


import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.service.IRoleService;
import com.ucar.training.service.IUserService;
import com.ucar.training.service.impl.RoleServiceImpl;
import com.ucar.training.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username") + "";
        String password = request.getParameter("password") + "";
        IUserService service = new UserServiceImpl();
        /*
          flag = 0 ->登录失败
          flag = 1 ->登录成功。
         */
        int flag = service.getPass(username,password);

        if (flag == 1){
            request.getSession().setAttribute("current",service.getUser(username));
            request.getRequestDispatcher("checkRole").forward(request,response);
            /*
            System.out.println("用户"+username+"成功登录!");
            HttpSession session = request.getSession();
            session.setAttribute("current",username);
            request.getRequestDispatcher("addMessage").forward(request,response);
             */
        }/*else if(flag == 2){
            System.out.println("管理员成功登录：" + username);
            HttpSession session = request.getSession();
            session.setAttribute("current",username);
            session.setAttribute("users",service.getAllUser());
            request.getRequestDispatcher("userManage.jsp").forward(request,response);
        }*/
        else {
            System.out.println("登录失败：用户名或密码错误" + username);
            request.setAttribute("warn","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
