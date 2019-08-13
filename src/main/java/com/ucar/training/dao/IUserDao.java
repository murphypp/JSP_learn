package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.Set;

public interface IUserDao {
    /**
     * 添加用户
     */
    void add(User u);

    /**
     * 删除用户
     */
    void delete(String username);

    /**
     *
     * @return 获得用户集合
     */
    Set<User> getAllUser();

    /**
     * 获取指定用户
     * @param username 用户名
     * @return 用户对象
     */
    User getUser(String username);
    /**
     *修改用户信息
     */
    void update(User u);
    /**
     * 获取用户数量
     */
    int size();

}
