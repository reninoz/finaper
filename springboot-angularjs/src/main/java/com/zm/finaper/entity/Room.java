package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wzhang on 24/05/2017.
 */
@Entity
@Table(name = "ROOMS")
public class Room extends AbstractEntity {

    private String title;

}
