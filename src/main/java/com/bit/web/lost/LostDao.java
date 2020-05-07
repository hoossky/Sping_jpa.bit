package com.bit.web.lost;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface LostDao {

    public void insert(Lost lost);

    public List<Lost> selectAll();

    public Lost selectOne(String lostid);


}