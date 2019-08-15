package com.ucar.training.service.impl;

import com.ucar.training.dao.IMessageDao;
import com.ucar.training.entity.Message;
import com.ucar.training.service.IMessageService;
import com.ucar.training.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MessageServiceImpl implements IMessageService {
    private IMessageDao messageDao;
    private SqlSession session;
    public MessageServiceImpl(){
        session = DBUtil.getSession();
        messageDao = session.getMapper(IMessageDao.class);
    }
    public void after(){
        session.commit();
        session.clearCache();
        session.close();
    }
    @Override
    public void addMessage(Message m) {
        messageDao.addMessage(m);
    }

    @Override
    public void deleteMessage(String ID) {
        messageDao.delMessage(ID);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageDao.getAllMessage();
    }

    @Override
    public List<Message> getUserMessages(String username) {
        return messageDao.getUserMessages(username);
    }

    @Override
    public void delUserMessages(String username) {
        messageDao.delUserMessages(username);
    }
    /*
    private static MessageDaoImpl iMessage = new MessageDaoImpl();
    @Override
    public void addMessage(Message m) {
        iMessage.addMessage(m);
    }

    @Override
    public void deleteMessage(String ID) {
        iMessage.delMessage(ID);
    }

    @Override
    public List<Message> getAllMessage() { return iMessage.getAllMessage(); }

    @Override
    public List<Message> getUserMessages(String username) { return iMessage.getUserMessages(username); }

    @Override
    public void delUserMessages(String username) {
        iMessage.delUserMessages(username);
    }

     */
}
