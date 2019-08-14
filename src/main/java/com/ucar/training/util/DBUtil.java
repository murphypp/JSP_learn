package com.ucar.training.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program:training_servlet
 * @description:数据库连接工具
 * @author:linshaoxiong
 * @create:2019-08-12 15:56
 **/
public class DBUtil {
    //定义连接数据库需要的变量
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    //需要的参数
    private static String url = "jdbc:mysql://localhost:3306/JSP?useSSL=false&serverTimezone=UTC";
    private static String username="root";
    private static String password="123456";
    private static String driver="com.mysql.cj.jdbc.Driver";

    /**
     * 加载驱动
     */
    static {
        try{
            /*System.out.println("url="+url);
            System.out.println("username="+username);
            System.out.println("driver="+driver);*/
            //加载驱动
            Class.forName(driver);
        }catch (Exception e){
            System.out.println("驱动加载失败");
            e.printStackTrace();
        }
    }
    /**
     * 得到Connection连接
     * @return Connection
     */
    public static Connection getConnection(){
        try{
            //建立连接
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            System.out.println("url="+url+"  username="+username);
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 资源关闭函数
     * @param resultSet
     * @param
     * @param
     */
    public static void close(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection )
    {
        if(resultSet!=null){
            try{
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet resultSet )
    {
        if(resultSet!=null){
            try{
                resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement preparedStatement )
    {
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection )
    {
        if(connection!=null){
            try{
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
