package com.ucar.training.dao.impl;

import com.ucar.training.dao.IUserDao;
import com.ucar.training.entity.User;
import com.ucar.training.utils.DBUtil;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl implements IUserDao {
    //private static Set<User> allUser = new HashSet<>();
    private Connection getConnection() throws SQLException {
        return DBUtil.getConnection();
    }


    public UserDaoImpl(){

    }
    @Override
    public void add(User u) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert user values (?,?,?,?,?,?,?);");
            preparedStatement.setString(1,u.getUsername());
            preparedStatement.setString(2,u.getPassword());
            preparedStatement.setString(3,u.getAuthority());
            preparedStatement.setInt(4,u.getAge());
            preparedStatement.setString(5,u.getSex());
            preparedStatement.setString(6,u.getLikes());
            preparedStatement.setString(7,u.getSign());
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // allUser.add(u);
    }

    @Override
    public void delete(String username) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from server.user where username=?");
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       // allUser.remove(u);
    }
    @Override
    public Set<User> getAllUser() {
        Set<User> allUser = new HashSet<>();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("select * from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                String username = resultSet.getString(1);
                user.setUsername(username);
                String password = resultSet.getString(2);
                user.setPassword(password);
                String authority = resultSet.getString(3);
                user.setAuthority(authority);
                int age = resultSet.getInt(4);
                user.setAge(age);
                String  sex = resultSet.getString(5);
                user.setSex(sex);
                String  likes = resultSet.getString(6);
                user.setLikes(likes);
                String  sign = resultSet.getString(7);
                user.setSign(sign);
                allUser.add(user);
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUser;

    }

    @Override
    public User getUser(String username) {
        try {
            User user = new User();
            Connection connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from user where username=?");
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setAuthority(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                user.setSex(resultSet.getString(5));
                user.setLikes(resultSet.getString(6));
                user.setSign(resultSet.getString(7));
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                return user;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User u) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update user set age=?,sex=?,likes=?,sign=? where username=?");
            preparedStatement.setInt(1,u.getAge());
            preparedStatement.setString(2,u.getSex());
            preparedStatement.setString(3,u.getLikes());
            preparedStatement.setString(4,u.getSign());
            preparedStatement.setString(5,u.getUsername());
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }

       // if(allUser.remove(u)){
      //      allUser.add(u);
       // }
    }

    @Override
    public int size() {
        int num = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select count(username) as num from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            num = resultSet.getInt("num");
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
            return  num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
        //return allUser.size();
    }
}
