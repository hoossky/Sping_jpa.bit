package com.bit.web.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.web.util.Data;
import com.bit.web.util.Messenger;

@Repository
public class AdminDaoImpl implements AdminDao{

    @Override
    public void insert(Admin admin) {
        System.out.println("3번 : "+admin);
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(
                            new File(Data.ADMINS.toString()), true));
            writer.write(admin.toString());
            writer.newLine(); // 줄바꿈
            writer.flush();
            System.out.println("4번 : "+admin);
        }catch(Exception e) {
            System.out.println(Messenger.FILE_INSERT_ERROR);
        }

    }

    @Override
    public List<Admin> selectAll() {
        List<Admin> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        try {
            File file = new File(Data.ADMINS.toString());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String message = "";
            while((message = reader.readLine()) != null) {
                temp.add(message);
            }
            reader.close();

        }catch(Exception e){
            System.out.println(Messenger.FILE_SELECT_ERROR);
        }
        Admin u = null;
        for(int i=0; i<temp.size(); i++) {
            u = new Admin();
            String[] arr = temp.get(i).split(",");

            u.setEmployNumber(arr[0]);
            u.setPassword(arr[1]);
            u.setName(arr[2]);
            u.setPosition(arr[3]);
            u.setProfile(arr[4]);
            u.setEmail(arr[5]);
            u.setPhoneNumber(arr[6]);
            u.setRegisterDate(arr[7]);
            list.add(u);

        }

        return list;
    }

    @Override
    public Admin selectOne(String employNumber) {
        List<Admin> list = selectAll();
        Admin findAdmin = null;
        for(Admin u : list ) {
            if(employNumber.equals(u.getEmployNumber())) {
                findAdmin = u;
                break;
            }
        }
        return findAdmin;
    }

    @Override
    public void update(Admin admin) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Admin admin) {
        // TODO Auto-generated method stub

    }

}