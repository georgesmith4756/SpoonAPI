package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pub{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String pub;

    public String getPub() {
        return pub;
    }

    public void setPub(String description) {
        this.pub = description;
    }



}
