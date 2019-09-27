package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name="entries")
public class Pub{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pub;
    private String username;
    private String date;
    private String ordertotal;
    private String postcode;

    public Pub(String pub, String username, String date, String ordertotal, String postcode){
        this.pub = pub;
        this.username = username;
        this.date = date;
        this.ordertotal = ordertotal;
        this.postcode = postcode;
    }

    public Pub(Long id, String pub, String username, String date, String ordertotal, String postcode){
        this.id = id;
        this.pub = pub;
        this.username = username;
        this.date = date;
        this.ordertotal = ordertotal;
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderTotal() {
        return ordertotal;
    }
    public void setOrderTotal(String ordertotal) {
        this.ordertotal = ordertotal;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }






}
