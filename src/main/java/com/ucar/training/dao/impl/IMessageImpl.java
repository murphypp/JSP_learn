package com.ucar.training.dao.impl;

import com.ucar.training.dao.IMessage;
import com.ucar.training.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class IMessageImpl implements IMessage {
    private static List<Message> messages = new ArrayList<>();

    @Override
    public void add(Message m) {
        messages.add(m);
    }

    @Override
    public void delete(Message m) {
        messages.remove(m);
    }

    @Override
    public List<Message> getAllMessage() {
        return messages;
    }

    @Override
    public List<Message> getUserMessages(String username) {
        List<Message> UserMessages = new ArrayList<>();
        for(Message m : messages){
            if (m.getAuthor().equals(username)){
                UserMessages.add(m);
            }
        }
        return UserMessages;
    }

}
