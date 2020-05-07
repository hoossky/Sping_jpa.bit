package com.bit.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.web.util.Data;
import com.bit.web.util.Messenger;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void insert(User user) {

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(
                            new File(Data.USERS.toString()), true));
            writer.write(user.toString());
            writer.newLine();
            writer.flush();
        }catch(Exception e){
            System.out.println(Messenger.FILE_INSERT_ERROR);
        }

    }

    @Override
    public List<User> selectAll() {
        List<User> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        try {
            File file = new File(Data.USERS.toString());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String message = "";
            while ((message = reader.readLine())!=null) {
                temp.add(message);
            }
            reader.close();

        }catch(Exception e) {
            System.out.println("사용자 에러");

        }
        User u = null;
        for(int i=0;i<temp.size();i++) {
            u= new User();
            String[] arr = temp.get(i).split(",");

            u.setUserid(arr[0]);
            u.setPassword(arr[1]);
            u.setName(arr[2]);
            u.setSsn(arr[3]);
            u.setAddress(arr[4]);
            u.setProfile(arr[5]);
            u.setEmail(arr[6]);
            u.setPhoneNumber(arr[7]);
            u.setRegisterDate(arr[8]);
            list.add(u);
        }

        return list;
    }

    @Override
    public User selectOne(String userid) {
        List<User> list = selectAll();
        User findUser = null;
        for(User u : list) { //향상된 for loop
            if(userid.equals(u.getUserid())) {
                findUser = u;
                break;
            }
        }

        return findUser;
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(User user) {
        // TODO Auto-generated method stub

    }



}