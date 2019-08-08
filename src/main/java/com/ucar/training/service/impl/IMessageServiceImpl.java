package com.ucar.training.service.impl;

import com.ucar.training.dao.impl.IMessageImpl;
import com.ucar.training.entity.Message;
import com.ucar.training.service.IMessageService;

import java.util.List;

public class IMessageServiceImpl implements IMessageService {
    private static IMessageImpl iMessage = new IMessageImpl();
    @Override
    public void addMessage(Message m) {
        iMessage.add(m);
    }

    @Override
    public void deleteMessage(String ID) {
        List<Message> list = iMessage.getAllMessage();
        for (Message m: list){
            if (m.getID().equals(ID)){
                iMessage.delete(m);
                return;
            }
        }
    }

    @Override
    public List<Message> getAllMessage() { return iMessage.getAllMessage(); }

    @Override
    public List<Message> getUserMessages(String username) { return iMessage.getUserMessages(username); }

    @Override
    public void deleteUserMessages(String username) {
        for (Message m: iMessage.getUserMessages(username)){
            iMessage.delete(m);
        }
    }
}
