package com.zm.finaper.entity;

import javax.persistence.*;
import java.util.List;

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
    private int numOfBath;
    private int numOfRooms;
    private boolean isRoom = true;
    @ManyToOne
    private Property hostProperty; //the property having the rooms

//    private List<Room> rooms;

    public Property() {
    }

    public Property(String type, String title, String address, String description, int numOfRooms) {
        this.type = type;
        this.title = title;
        this.address = address;
        this.description = description;
        this.numOfRooms = numOfRooms;
    }

    public Property getHostProperty() {
        return hostProperty;
    }

    public void setHostProperty(Property hostProperty) {
        this.hostProperty = hostProperty;
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

/*    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }*/

    public boolean isRoom() {
        return isRoom;
    }

    public void setRoom(boolean room) {
        isRoom = room;
    }

    public int getNumOfBath() {
        return numOfBath;
    }

    public void setNumOfBath(int numOfBath) {
        this.numOfBath = numOfBath;
    }
}
