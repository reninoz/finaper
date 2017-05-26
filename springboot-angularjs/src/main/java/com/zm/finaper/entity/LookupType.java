package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wzhang on 26/05/2017.
 */

@Entity
@Table(name = "LOOKUP_TYPES")
public class LookupType extends AbstractEntity {

    private String code;
    private String description;

    public LookupType() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
