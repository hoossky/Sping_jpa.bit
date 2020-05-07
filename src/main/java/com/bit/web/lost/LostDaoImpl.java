package com.bit.web.lost;

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
public class LostDaoImpl implements LostDao {

    @Override
    public void insert(Lost lost) {

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(
                            new File(Data.LOSTS.toString()), true));
            writer.write(lost.toString());
            writer.newLine();
            writer.flush();
        }catch(Exception e){
            System.out.println(Messenger.FILE_INSERT_ERROR);
        }

    }

    @Override
    public List<Lost> selectAll() {
        List<Lost> losts = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(Data.LOSTS.toString())));
            String message = "";
            while ((message = reader.readLine())!=null) {
                temp.add(message);
            }
            reader.close();

        }catch(Exception e) {
            System.out.println("로스트 에러");
            e.printStackTrace();

        }
        Lost i = null;
        for(String s : temp) {

            i = new Lost();
            String[] arr = s.split(",");
            i.setLostid(arr[0]);
            i.setItem(arr[1]);
            i.setDate(arr[2]);
            i.setKind(arr[3]);
            i.setLocation(arr[4]);
            losts.add(i);
        }

        return losts;
    }

    @Override
    public Lost selectOne(String lostid) {
        List<Lost> list = selectAll();
        Lost findLost = null;
        for(Lost u : list) {
            if(lostid.equals(u.getLostid())) {
                findLost = u;
                break;
            }
        }

        return findLost;
    }


}