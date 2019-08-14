package com.ucar.training.services;

import com.ucar.training.entity.User;

import java.util.List;

/**
 * @program:training_servlet
 * @description:提供服务，调用dao层
 * @author:linshaoxiong
 * @create:2019-08-14 11:20
 **/
public interface IUserService {

    /**
     * 提供注册服务
     * @param  user
     * @return boolean
     */
    boolean registerUser(User user);

    /**
     * 提供登录服务
     * @param username
     * @param password
     * @return User
     */
    User loginUser(String username,String password);

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> selectALL();

    /**
     * 删除一个用户
     * @param username
     * @return boolean
     */
    boolean deleteUser(String username);

    /**
     * 根据username，返回一个用户
     * @param  username
     * @return User
     */
    User selectOne(String username);

    /**
     * 修改用户
     * @param user
     */
    void modify(User user);
}
