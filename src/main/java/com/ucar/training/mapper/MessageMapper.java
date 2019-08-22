package com.ucar.training.mapper;

import com.ucar.training.entity.Message;

import java.util.List;

public interface MessageMapper {
    /**
     * 添加一条留言
     * @param m
     */
    void addMessage(Message m);
    /**
     * 删除一条留言
     */
    void delMessage(String ID);
    /**
     * 修改留言信息
     */
    List<Message> getAllMessage();
    /**
     * 获得用户发布的所有留言
     */
    List<Message> getUserMessages(String username);

    /**
     * 删除用户所有留言
     * @param username 用户名
     */
    void delUserMessages(String username);
}
