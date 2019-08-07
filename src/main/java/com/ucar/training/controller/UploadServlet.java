package com.ucar.training.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@MultipartConfig(maxFileSize = 1024 * 1024 * 20,
        maxRequestSize = 1024 * 1024 * 40)
public class UploadServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Part part = request.getPart("upload");
        //获得文件名
        String disposition = part.getHeader("Content-Disposition");
        System.out.println(disposition);
        //文件名后缀
        String filename = disposition.substring(disposition.lastIndexOf("=")+2,disposition.length()-1);
        //String filename = UUID.randomUUID()+suffix;
        System.out.println(filename);
        InputStream inputStream = part.getInputStream();
        String uploadPath = this.getServletContext().getRealPath("/file");
        File file = new File( uploadPath+File.separator +filename);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int length = 1024;
        while ((length = inputStream.read(bytes))!= -1){
            fileOutputStream.write(bytes,0,length);
        }
        fileOutputStream.close();
        inputStream.close();
        response.sendRedirect("listFile");
    }
}
