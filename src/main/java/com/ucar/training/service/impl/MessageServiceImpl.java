package com.ucar.training.service.impl;

import com.ucar.training.entity.Message;
import com.ucar.training.mapper.MessageMapper;
import com.ucar.training.service.IMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {
    @Resource
    private MessageMapper messageMapper;
    @Override
    public void addMessage(Message m) {
        messageMapper.addMessage(m);
    }

    @Override
    public void deleteMessage(String ID) {
        messageMapper.delMessage(ID);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    @Override
    public List<Message> getUserMessages(String username) {
        return messageMapper.getUserMessages(username);
    }

    @Override
    public void delUserMessages(String username) {
        messageMapper.delUserMessages(username);
    }
}
