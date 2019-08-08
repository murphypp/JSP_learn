package com.ucar.training.service.impl;

import com.ucar.training.dao.impl.IMessageImpl;
import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.entity.Message;
import com.ucar.training.entity.User;
import com.ucar.training.service.IService;

import java.util.List;
import java.util.Set;

public class IServiceImpl implements IService {
    private static IUserImpl iUser = new IUserImpl();
    private static IMessageImpl iMessage = new IMessageImpl();


    @Override
    public void addUser(User u) {
        iUser.add(u);
    }

    @Override
    public void deleteUser(String username) {
        for (User u: iUser.getAllUser()
             ) {
            if (username.equals(u.getUsername())){
                iUser.delete(u);
                break;
            }
        }
    }

    @Override
    public void updateUser( User u) {
        iUser.update(u);
    }

    @Override
    public Set<User> getAllUser() {
        return iUser.getAllUser();
    }

    @Override
    public User getUser(String username) {
        for (User x: iUser.getAllUser()){
            if (x.getUsername().equals(username)){
                return x;
            }
        }
        return null;
    }

    @Override
    public int getPass(String username, String password) {
        User u = getUser(username);
        if(u !=null && u.getUsername().equals(username)){
            if(u.getPassword().equals(password)){
                if(u.getAuthority().equals("admin")){
                    return 2;
                }
                return 1;
            }
        }
        return 0;
    }

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
}
