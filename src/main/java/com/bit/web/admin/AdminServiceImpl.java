package com.bit.web.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired AdminDao adminDao;

    @Override
    public void register(Admin admin) {
		/*
		 nameX, employNumber, password, positionX, profile, emailX, phoneNumberX, registerDate
		 name,position,email, phoneNumber 이미 입력받음
		*/
        System.out.println("2번 : "+admin);
        admin.setEmployNumber(createEmployNumber()); //4자리 수 랜덤값
        System.out.println("33"+admin);
        admin.setPassword("1");
        admin.setRegisterDate(createCurrentDate()); //현재 시간
        adminDao.insert(admin);
    }


    private String createEmployNumber() {
        String startNum = "";
        for(int i=0; i<4; i++) {
            startNum += String.valueOf((int)(Math.random()*10));
            //toString 주소값을 스트링으로
            //valueOf 연산값을 스트링으로
        }
        return startNum;
    }

    private String createCurrentDate() {

        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());

    }

    @Override
    public List<Admin> findAll() {

        return adminDao.selectAll();
    }

    @Override
    public Admin findOne(String employNumber) {

        return adminDao.selectOne(employNumber);
    }

    @Override
    public void modify(Admin admin) {

        adminDao.update(admin);
    }

    @Override
    public void remove(Admin admin) {
        adminDao.delete(admin);
    }


}