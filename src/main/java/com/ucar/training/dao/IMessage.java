package com.ucar.training.dao;

import com.ucar.training.entity.Message;

import java.util.List;

public interface IMessage {
    /**
     * 添加一条留言
     * @param m
     */
    void add(Message m);
    /**
     * 删除一条留言
     */
    void delete(Message m);
    /**
     * 修改留言信息
     */
    List<Message> getAllMessage();
    /**
     * 获得用户发布的留言数量
     */
    List<Message> getUserMessages(String username);
}
