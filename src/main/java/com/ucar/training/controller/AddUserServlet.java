package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.IService;
import com.ucar.training.service.impl.IServiceImpl;
import com.ucar.training.utils.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addUser.jsp").forward(request,response);
    }
}
