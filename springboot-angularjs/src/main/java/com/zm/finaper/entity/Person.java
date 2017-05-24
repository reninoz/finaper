package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wzhang on 19/05/2017.
 */
@Entity
@Table(name="PERSONS")
public class Person  extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String middleName;
    private String otherName;

    private Date dob;
    private String mobile;
    private String email;
    private String nationality;
    private String wechatId;

    public Person() {
    }

    public Person(String firstName, String lastName, String middleName,
                  String otherName, Date dob, String mobile, String email,
                  String nationality, String wechatId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.otherName = otherName;
        this.dob = dob;
        this.mobile = mobile;
        this.email = email;
        this.nationality = nationality;
        this.wechatId = wechatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
}
