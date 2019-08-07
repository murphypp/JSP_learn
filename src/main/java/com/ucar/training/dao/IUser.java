package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.Set;

public interface IUser {
    /**
     * 添加用户
     */
    void add(User u);

    /**
     * 删除用户
     */
    void delete(User u);

    /**
     * 获得用户集合
     * @return
     */
    Set<User> getAllUser();

    /**
     *修改用户信息
     */
    void update(User u);
    /**
     * 获取用户数量
     */
    int size();

}
