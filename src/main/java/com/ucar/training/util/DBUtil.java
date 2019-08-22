package com.ucar.training.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBUtil {
    /*
    private static final String url = "jdbc:mysql://localhost:3306/server?useSSL=false&serverTimezone=UTC";
    private static final String name ="root";
    private static final String pass = "123456";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,pass);
    }
    //数据库c3p0连接池
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //从连接池获得数据库连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resources = "mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resources);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
