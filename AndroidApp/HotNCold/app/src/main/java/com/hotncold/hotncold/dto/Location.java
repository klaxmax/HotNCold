package com.hotncold.hotncold.dto;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class Location {
    private String strLiked;
    private String strName;
    private String strDistance;

    public Location(String booLiked, String strName, String intDistance){
        this.strLiked = booLiked;
        this.strName = strName;
        this.strDistance = intDistance;
    }

    public String getStrLiked() {
        return strLiked;
    }

    public void setStrLiked(String strLiked) {
        this.strLiked = strLiked;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrDistance() {
        return strDistance;
    }

    public void setStrDistance(String strDistance) {
        this.strDistance = strDistance;
    }
}
