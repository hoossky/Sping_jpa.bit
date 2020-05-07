package com.bit.web.lost;

import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

import lombok.Data;

@Getter @Setter
@Component
public class Lost {

    private String lostid, item, date, kind, location;
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", lostid, item, date, kind, location);
    }

}