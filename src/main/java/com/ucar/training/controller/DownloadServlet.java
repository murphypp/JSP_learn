package com.ucar.training.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DownloadServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String filename = request.getParameter("download");
        String path = this.getServletContext().getRealPath("/file") + File.separator + filename;
        FileInputStream fileInputStream = new FileInputStream(path);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+filename);
        ServletOutputStream servletOutputStream  = response.getOutputStream();
        byte[] bytes = new byte[1024];
        int length = 1024;
        while ((length=fileInputStream.read(bytes))!=-1){
            servletOutputStream.write(bytes,0,length);
        }
        fileInputStream.close();
        servletOutputStream.close();
    }
}
