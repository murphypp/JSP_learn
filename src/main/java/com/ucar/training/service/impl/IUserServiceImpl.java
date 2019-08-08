package com.ucar.training.service.impl;


import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.entity.User;
import com.ucar.training.service.IUserService;

import java.util.Set;

public class IUserServiceImpl implements IUserService {
    private static IUserImpl iUser = new IUserImpl();


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

}
