package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name="pubs")
public class Pubs {

    String pub;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }



}
