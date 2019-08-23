package com.ucar.training.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.*;

/**
 * @program:training_servlet
 * @description:数据库连接工具
 * @author:linshaoxiong
 * @create:2019-08-12 15:56
 **/
public class DBUtil {

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //执行其他方法前需要创建SqlSessionFactory
            // mybatis配置文件
            String resource = "mybatis-config.xml";
            // 得到配置文件流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 创建会话工厂，传入mybatis的配置文件信息
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //返回会话
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
    //资源关闭
    public static void close(SqlSession sqlSession){
        //提交会话
        sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }


/*

    //定义连接数据库需要的变量
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    //需要的参数
    private static String url = "jdbc:mysql://localhost:3306/JSP?useSSL=false&serverTimezone=UTC";
    private static String username="root";
    private static String password="123456";
    private static String driver="com.mysql.cj.jdbc.Driver";



    static {
        try{
            System.out.println("url="+url);
            System.out.println("username="+username);
            System.out.println("driver="+driver);
            //加载驱动
            Class.forName(driver);
        }catch (Exception e){
            System.out.println("驱动加载失败");
            e.printStackTrace();
        }
    }
    */
/**
     * 得到Connection连接
     * @return Connection
    *//*

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

     */
/*
     * 资源关闭函数
     * @param resultSet
     * @param
     * @param
        *//*

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


*/

}
