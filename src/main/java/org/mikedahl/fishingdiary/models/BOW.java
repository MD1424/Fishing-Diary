package org.mikedahl.fishingdiary.models;

import javax.persistence.*;

@Entity(name = "body_of_Water")
public class BOW {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "body_of_Water")
    private String BOW;


    public BOW() {

    }

    public BOW(String BOW) {
        this.BOW = BOW;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBOW() {
        return BOW;
    }

    public void setBOW(String BOW) {
        this.BOW = BOW;
    }



}