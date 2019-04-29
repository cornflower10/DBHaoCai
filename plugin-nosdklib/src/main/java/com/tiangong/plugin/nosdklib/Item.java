package com.tiangong.plugin.nosdklib;

import java.io.Serializable;

public class Item implements Serializable{
    private int id;

    private int img;

    private String name ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
