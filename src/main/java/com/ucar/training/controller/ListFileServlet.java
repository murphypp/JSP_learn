package com.ucar.training.controller;

import com.ucar.training.utils.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ListFileServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = this.getServletContext().getRealPath("/file");
        Set<String> all = new HashSet<>();
        File file = new File(path);
        FileUtil.listFile(file,all);
        request.setAttribute("files",all);
        request.getRequestDispatcher("fileOperation.jsp").forward(request,response);
    }
}
