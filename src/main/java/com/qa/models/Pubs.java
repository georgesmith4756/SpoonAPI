package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name="pubs")
public class Pubs {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pub;
    
    public Pubs(){
        
    }

    public Pubs(String pub){
        this.pub = pub;
    }

    public Pubs(Long id, String pub){
        this.id = id;
        this.pub = pub;
    }

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
