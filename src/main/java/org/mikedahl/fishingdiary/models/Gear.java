package org.mikedahl.fishingdiary.models;

import javax.persistence.*;

@Entity(name = "gear")
public class Gear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pole_type")
    private String poleType;
    @Column(name = "string_weight")
    private String stringWeight;
    @Column(name = "bait")
    private String bait;


    public Gear(String poleType, String stringWeight, String bait) {
        this.poleType = poleType;
        this.stringWeight = stringWeight;
        this.bait = bait;
    }

    public Gear() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoleType() {
        return poleType;
    }

    public void setPoleType(String poleType) {
        this.poleType = poleType;
    }

    public String getStringWeight() {
        return stringWeight;
    }

    public void setStringWeight(String stringWeight) {
        this.stringWeight = stringWeight;
    }

    public String getBait() {
        return bait;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }






}
