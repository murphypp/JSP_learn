package com.ucar.training.service;

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
     * 增加用户
     * @param  user
     * @return int
     */
    void addUser(User user);
    /**
     * 删除一个用户
     * @param username
     * @return int
     */
    void deleteUser(String username);
    /**
     * 根据username，返回一个用户
     * @param  username
     * @return User
     */
    User getUserByUsername(String username);

    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> getAllUser();
    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);
}
