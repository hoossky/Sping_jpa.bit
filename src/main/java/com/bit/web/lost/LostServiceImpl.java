package com.bit.web.lost;

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
public class LostServiceImpl implements LostService{
    @Autowired LostDao userDao;


    @Override
    public List<Lost> findAll() {
        return userDao.selectAll();
    }

    @Override
    public Lost findOne(String lostid) {


        return userDao.selectOne(lostid);
    }


}