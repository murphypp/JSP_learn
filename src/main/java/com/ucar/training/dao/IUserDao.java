package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.List;

/**
 * @program:training_servlet
 * @description:用户信息dao层
 * @author:linshaoxiong
 * @create:2019-08-12 16:01
 **/
public interface IUserDao{
    /**
     * 根据用户名和密码来查找用户
     *
     * @param username
     * @param password
     * @return User
     */
    User findUserByPassword(String username,String password);

    /**
     * 根据用户名查找用户
     * @param username
     * @return User
     */
    User findUserByUsername(String username);

    /**
     * 返回所有用户
     * @return List
     */
    List<User> getAllUser();

    /**
     * 添加用户
     * @param user
     * @return true/false
     */
    boolean addUser(User user);

    /**
     * 删除用户
     * @param username
     * @return true/false
     */
    boolean deleteUser(String username);

    /**
     * 修改用户
     * @param
     * @return true/false
     */
    boolean modifyUser(User user);

    boolean addUserRole(User user);
}
