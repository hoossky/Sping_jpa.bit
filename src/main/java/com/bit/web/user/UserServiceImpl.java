package com.bit.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.bit.web.admin.AdminDao;
import com.bit.web.util.Data;
import com.bit.web.util.Messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired UserDao userDao;

    @Override
    public void join(User user) {

        userDao.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.selectAll();
    }

    @Override
    public User FindOne(String userid) {


        return userDao.selectOne(userid);
    }

    @Override
    public void modify(User user) {

        userDao.update(user);
    }

    @Override
    public void remove(User user) {

        userDao.delete(user);
    }



}