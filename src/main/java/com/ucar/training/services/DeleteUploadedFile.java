package com.ucar.training.services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @program:training_servlet
 * @description:删除已经上传的文件
 * @author:linshaoxiong
 * @create:2019-08-05 16:53
 **/
public class DeleteUploadedFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String fileName = request.getParameter("filename");
        String path = request.getServletContext().getRealPath("/WEB-INF/upload/")+fileName; //默认认为文件在当前项目的根目录
        System.out.println("删除文件："+path);
        String message="删除失败！";
        File deleteFile = new File(path);
        if(deleteFile.exists()){
            if(deleteFile.delete())
                message="删除成功！";
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher("fileManager.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doPost(request,response);
    }
}
