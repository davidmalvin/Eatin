package com.example.eatin;
import java.util.*;

public class Restaurant {

    private String name;
    private String mainURL;
    private String PictureURL;
    private List<String> Pictures;
    private String RateCat;

    public Restaurant(String name, String mainURL) {
        this.name=name;
        setMainURL(mainURL);

    }

    public String getMainURL() {
        return mainURL;
    }

    public void setMainURL(String mainURL) {
        this.mainURL = mainURL;
        this.PictureURL = mainURL.replace("/biz/", "/biz_photo");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPictures() {
        return Pictures;
    }

    public void setPictures(List<String> pictures) {
        Pictures = pictures;
    }

    public String getPictureURL() {
        return PictureURL;
    }

    public void setPictureURL(String pictureURL) {
        PictureURL = pictureURL;
    }

    public String getRateCat() {
        return RateCat;
    }

    public void setRateCat(String rateCat) {
        RateCat = rateCat;
    }
}




