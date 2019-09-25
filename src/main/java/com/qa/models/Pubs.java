package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name="pubs")
public class Pubs {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String pub;

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
