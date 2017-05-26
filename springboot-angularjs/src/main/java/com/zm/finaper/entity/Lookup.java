package com.zm.finaper.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by wzhang on 26/05/2017.
 */

@Entity
@Table(name = "LOOKUPS")
public class Lookup extends AbstractEntity {

    @ManyToOne
    private LookupType lookupType;

    private String code;
    private String description;

    public Lookup() {
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

    public LookupType getLookupType() {
        return lookupType;
    }

    public void setLookupType(LookupType lookupType) {
        this.lookupType = lookupType;
    }
}
