package com.ucar.training.dao.impl;

import com.ucar.training.dao.IUser;
import com.ucar.training.entity.User;

import java.util.HashSet;
import java.util.Set;

public class IUserImpl implements IUser {
    private static Set<User> allUser;

    public IUserImpl(){
        allUser = new HashSet<>();
    }
    @Override
    public void add(User u) {
        allUser.add(u);
    }

    @Override
    public void delete(User u) {
        allUser.remove(u);
    }
    @Override
    public Set<User> getAllUser() {
        return allUser;
    }

    @Override
    public void update(User u) {
        if(allUser.remove(u)){
            allUser.add(u);
        }
    }

    @Override
    public int size() {
        return allUser.size();
    }
}
