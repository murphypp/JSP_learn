package com.ucar.training.service;

import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.entity.Message;
import com.ucar.training.entity.User;

import java.util.List;
import java.util.Set;

public interface IService {
    /**
     * 添加用户
     */
    void addUser( User u);
    /**
     * 删除用户
     */
    void deleteUser( String username);
    /**
     * 编辑用户信息
     */
    void updateUser( User u);
    /**
     * 获取所有用户信息
     */
    Set<User> getAllUser();
    /**
     * 获得指定用户的信息
     */
    User getUser(String username);
    /**
     * 获得用户的登录权限
     */
    int getPass(String username, String password);
    //留言板
    /**
     * 添加留言
     */
    void addMessage(Message m);
    /**
     * 删除留言
     */

    void deleteMessage(String ID);
    /**
     * 获得所有留言信息
     */
    List<Message> getAllMessage();
    /**
     * 获得某个用户的所有留言
     */
    List<Message> getUserMessages(String username);
}

