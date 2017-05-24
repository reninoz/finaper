package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wzhang on 16/05/2017.
 */
@Entity
@Table(name = "PROPERTIES")
public class Property  extends AbstractEntity {

    private String type;
    private String title;
    private String address;
    private String description;
    private int numOfRooms;

    public Property() {
    }

    public Property(String type, String title, String address, String description, int numOfRooms) {
        this.type = type;
        this.title = title;
        this.address = address;
        this.description = description;
        this.numOfRooms = numOfRooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

}
