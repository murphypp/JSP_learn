package com.ucar.training.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:training_servlet
 * @description:展示已经上传的文件列表
 * @author:linshaoxiong
 * @create:2019-08-05 16:51
 **/
public class ListUploadedFiles extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        List<File> fileList = new ArrayList<>();
        ServletContext application = this.getServletContext();
        String filepath = application.getRealPath("/WEB-INF/upload");
        System.out.println("filepath="+filepath);
        File dir = new File(filepath);
        for (File f:dir.listFiles()){
             fileList.add(f);
        }
        request.setAttribute("fileList",fileList);
        request.getRequestDispatcher("fileManager.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }
}
