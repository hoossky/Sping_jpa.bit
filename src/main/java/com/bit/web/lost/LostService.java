package com.bit.web.lost;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface LostService {


    public List<Lost> findAll();

    public Lost findOne(String lostid);



}