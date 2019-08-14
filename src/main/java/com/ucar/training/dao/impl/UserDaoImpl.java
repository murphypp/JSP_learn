package com.ucar.training.dao.impl;

import com.ucar.training.dao.IUserDao;
import com.ucar.training.entity.User;
import com.ucar.training.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:training_servlet
 * @description:数据库中用户信息的增删查改
 * @author:linshaoxiong
 * @create:2019-08-12 15:58
 **/
public class UserDaoImpl implements IUserDao {

    @Override
    public
    User find(String username, String password) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where username = ? and password = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                String realname = resultSet.getString("realname");
                Integer age = resultSet.getInt("age");
                String privileges = resultSet.getInt("privileges")==1?"1":"0";
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String hobby = resultSet.getString("hobby");
                String sign = resultSet.getString("sign");
                User user = new User(username1,password1,email,realname,age,sex,phone,privileges,hobby,sign);
                return user;
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
        return  null;
    }

    @Override
    public User find(String username) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql = "select * from user where username = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String username1 = resultSet.getString("username");
                String password1 = resultSet.getString("password");
                String realname = resultSet.getString("realname");
                Integer age = resultSet.getInt("age");
                String privileges = resultSet.getInt("privileges")==1?"1":"0";
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String hobby = resultSet.getString("hobby");
                String sign = resultSet.getString("sign");
                User user = new User(username1,password1,email,realname,age,sex,phone,privileges,hobby,sign);
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
        return  null;

    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        String sql = "select * from user";
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String realname = resultSet.getString("realname");
                Integer age = resultSet.getInt("age");
                String privileges = resultSet.getInt("privileges")==1?"1":"0";
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String hobby = resultSet.getString("hobby");
                String sign = resultSet.getString("sign");
                User user = new User(username,password,email,realname,age,sex,phone,privileges,hobby,sign);
                userList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
        return  userList;
    }

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement= null;
        ResultSet resultSet = null;
        String sql = "insert into user(username,password,realname,`privileges`,age,sex,phone,email,hobby,sign)values(?,?,?,?,?,?,?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getRealname());
            if (user.isPrivileges()) {
                preparedStatement.setInt(4, 1);
            } else {
                preparedStatement.setInt(4, 0);
            }
            preparedStatement.setInt(5,user.getAge());
            preparedStatement.setString(6,user.getSex());
            preparedStatement.setString(7,user.getPhone());
            preparedStatement.setString(8,user.getEmail());
            preparedStatement.setString(9,user.getHobby());
            preparedStatement.setString(10,user.getSign());
            preparedStatement.execute();
            flag=true;
        }catch (Exception e){
            flag=false;
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
        return  flag;
    }

    @Override
    public boolean deleteUser(String username) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "delete from user where username = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.execute();
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
    }

    @Override
    public boolean modifyUser(User user) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "update user set password=?,realname=?,privileges=?,age=?,sex=?,phone=?,email=?,hobby=?,sign=? where username='"+user.getUsername()+"'";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getPassword());
            preparedStatement.setString(2,user.getRealname());
            preparedStatement.setInt(3,user.isPrivileges()?1:0);
            preparedStatement.setInt(4,user.getAge());
            preparedStatement.setString(5,user.getSex());
            preparedStatement.setString(6,user.getPhone());
            preparedStatement.setString(7,user.getEmail());
            preparedStatement.setString(8,user.getHobby());
            preparedStatement.setString(9,user.getSign());
            System.out.println(preparedStatement.toString());
            preparedStatement.execute();
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
    }
}
