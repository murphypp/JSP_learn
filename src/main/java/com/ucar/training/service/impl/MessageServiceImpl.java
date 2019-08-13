package com.ucar.training.service.impl;

import com.ucar.training.dao.impl.MessageDaoImpl;
import com.ucar.training.entity.Message;
import com.ucar.training.service.IMessageService;

import java.util.List;

public class MessageServiceImpl implements IMessageService {
    private static MessageDaoImpl iMessage = new MessageDaoImpl();
    @Override
    public void addMessage(Message m) {
        iMessage.add(m);
    }

    @Override
    public void deleteMessage(String ID) {
        iMessage.delete(ID);
    }

    @Override
    public List<Message> getAllMessage() { return iMessage.getAllMessage(); }

    @Override
    public List<Message> getUserMessages(String username) { return iMessage.getUserMessages(username); }

    @Override
    public void deleteUserMessages(String username) {
        iMessage.deleteUserMessages(username);
    }
}
