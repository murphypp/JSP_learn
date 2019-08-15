package com.ucar.training.service;

import com.ucar.training.entity.Message;

import java.util.List;

public interface IMessageService {
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
    /**
     * 删除某个用户的所有留言
     */
    void delUserMessages(String username);
}
