package com.ucar.training.services;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @program:training_servlet
 * @description:上传服务
 * @author:linshaoxiong
 * @create:2019-08-05 16:47
 **/
public class UploadFile extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("UTF-8");
        //上传文件存于WEB-INF目录下，不允许外界直接访问
        String savePath = req.getServletContext().getRealPath("/WEB-INF/upload");
        //上传时临时文件保存目录
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        //创建保存目录的文件
        File tempFile = new File(tempPath);
        //不存在则创建文件夹
        if(!tempFile.exists())
        {
            System.out.println("创建目录");
            tempFile.mkdir();
        }
        //消息提示
        String message= "";
        //使用Apache文件上传组件
        try{
            //1.创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂缓冲区大小，当上传文件大小超过缓冲区，则会生成一个临时文件放于临时目录中
            //缓冲区大小为1024KB，
            factory.setSizeThreshold(1024*1024);
            //2.创建文件解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //监听文件上传进度
            upload.setProgressListener(new ProgressListener() {
                @Override
                public void update(long l, long l1, int i) {
                    System.out.println("文件大小为:"+l1+",已上传:"+l);
                }
            });
            upload.setHeaderEncoding("UTF-8");
            //3.判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(req)){
                //按照传统方式获取数据
                return;
            }
            //设置上传单个文件大小的最大值
            upload.setFileSizeMax(1024*2024);
            //设置上传文件总量的最大值
            upload.setSizeMax(1024*1024*10);
            //4.使用解析器解析数据，结果返回List<FileItem>集合
            List<FileItem> list= upload.parseRequest(req);
            for(FileItem item:list){
                //如果FileItem中封装的是普通输入项的数据
                if(item.isFormField())
                {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println(name+"="+value);
                }else {//如果FileItem中封装的是上传文件
                    String fileName = item.getName();
                    System.out.println("文件名是："+fileName);
                    if(fileName==null||fileName.trim().equals("")){
                        message="请选择上传文件！";
                        continue;
                    }
                    //处理上传文件的文件名的路径部分，只保留文件名，如果没有路径，则lastIndexOf返回-1
                    fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
                    //文件扩展名
                    String fileExtName= fileName.substring(fileName.lastIndexOf(".")+1);
                    //System.out.println("上传文件的扩展名是："+fileExtName);
                    //获取item中的上传输入流
                    BufferedInputStream bis = new BufferedInputStream(item.getInputStream());
                    //得到文件保存的名称
                    String saveFilename =  makeFileName(fileName);
                    //得到文件的保存目录
                    String realSavePath = makePath(saveFilename,savePath);
                    //创建一个文件输出流
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(realSavePath+"\\"+saveFilename));
                    //创建一个缓冲区
                    byte[] buffer = new byte[1024*8];
                    //循环将缓冲输入流读入到缓冲区
                    while (true)
                    {
                        int length = bis.read(buffer);
                        //末尾
                        if(length==-1)
                            break;
                        //使用缓冲输出流写入到指定目录
                        bos.write(buffer,0,length);
                    }
                    //关闭输入输出流，删除临时文件
                    bis.close();
                    bos.close();
                    item.delete();
                    message="文件上传成功";

                }
            }
        }catch (FileUploadBase.FileSizeLimitExceededException e) {
            message="单个文件超出最大值";
            e.printStackTrace();
            System.out.println(message);
        }catch (FileUploadBase.SizeLimitExceededException e){
            message="总大小超出限制";
            e.printStackTrace();
            System.out.println(message);
        }catch (Exception e){
            message="文件上传失败";
            e.printStackTrace();
        }
        System.out.println("上传文件成功，执行跳转");
        req.setAttribute("message",message);
        req.getRequestDispatcher("/fileManager.jsp").forward(req,resp);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        doGet(req,resp);
    }
    private  String makeFileName(String filename)
    {
        // return OrderIdBuilder.createOrderId().toString() + "_" + filename;
        return filename;
    }
    private String makePath(String filename,String savePath)
    {
        int hashcode = filename.hashCode();
        //int dir1 = hashcode&0xf;        //0-15
        //int dir2 = (hashcode&0xf0)>>4;  //0-15
        //upload\2\3
        String dir = savePath ;
        File file=new File(dir);
        if(!file.exists())
        {
            file.mkdirs();
        }
        return  dir;
    }
}
