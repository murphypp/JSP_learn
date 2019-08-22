package com.ucar.training.service.impl;


import com.ucar.training.entity.User;
import com.ucar.training.mapper.UserMapper;
import com.ucar.training.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User u) {
        userMapper.addUser(u);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.delUser(username);
    }

    @Override
    public void updateUser(User u) {
        userMapper.updateUser(u);
    }

    @Override
    public Set<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUser(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public int getPass(String username, String password) {
        User user = getUser(username);
        if(user != null && user.getPassword().equals(password)){
            return 1;
        }
        return 0;
    }
}
