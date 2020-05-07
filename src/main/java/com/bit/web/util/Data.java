package com.bit.web.util;

import java.io.File;

public enum Data {
    ADMINS, USERS, LOSTS;

    @Override
    public String toString() {
        String path = "C:"+File.separator+"Users"+File.separator+"bit"+File.separator
                +"git"+File.separator+"repository2"+File.separator+"bit-1"+File.separator+"src"+File.separator
                +"main"+File.separator+"resources"+File.separator+"static"+File.separator+"resources"+File.separator+"file"+File.separator;

        switch(this) {


            case ADMINS: path = path.concat("admins.csv"); break;

            case USERS: path = path.concat("users.csv"); break;

            case LOSTS: path = path.concat("losts.csv"); break;

            default: break;
        }

        return path;
    }

}