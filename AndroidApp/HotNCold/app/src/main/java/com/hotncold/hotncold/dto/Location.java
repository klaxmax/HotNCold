package com.hotncold.hotncold.dto;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Klaxmax on 01.05.2017.
 */

public class Location {
    private String strName;
    private String strDistance;
    private double doubxCoordinate;
    private double doubyCoordinate;
    private boolean boofavoritLocation;
    private String strdescription;

    public String getStrWebPage() {
        return strWebPage;
    }

    public void setStrWebPage(String strWebPage) {
        this.strWebPage = strWebPage;
    }

    private String strWebPage;

    public Location(boolean boofavoritLocation,
                    String strName,
                    String strDistance,
                    double doubxCoordinate,
                    double doubyCoordinate,
                    String strdescription,
                    String stradress,
                    String strWebPage) {
        this.boofavoritLocation = boofavoritLocation;
        this.strName = strName;
        this.strDistance = strDistance;
        this.doubxCoordinate = doubxCoordinate;
        this.doubyCoordinate = doubyCoordinate;
        this.strdescription = strdescription;
        this.stradress = stradress;
        this.strWebPage = strWebPage;
    }


    public double getDoubyCoordinate() {
        return doubyCoordinate;
    }

    public void setDoubyCoordinate(double doubyCoordinate) {
        this.doubyCoordinate = doubyCoordinate;
    }

    public boolean isBoofavoritLocation() {
        return boofavoritLocation;
    }

    public void setBoofavoritLocation(boolean boofavoritLocation) {
        this.boofavoritLocation = boofavoritLocation;
    }

    public String getStrdescription() {
        return strdescription;
    }

    public void setStrdescription(String strdescription) {
        this.strdescription = strdescription;
    }

    public String getStradress() {
        return stradress;
    }

    public void setStradress(String stradress) {
        this.stradress = stradress;
    }

    private String stradress;

    public double getDoubxCoordinate() {
        return doubxCoordinate;
    }

    public void setDoubxCoordinate(double doubxCoordinate) {
        this.doubxCoordinate = doubxCoordinate;
    }

    public double getyCoordinate() {
        return doubyCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.doubyCoordinate = yCoordinate;
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

    public LatLng getLatLng(){
        return new LatLng(getDoubxCoordinate(), getyCoordinate());
    }
}
