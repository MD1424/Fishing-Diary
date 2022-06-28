package org.mikedahl.fishingdiary.dto;

public class CatchDto {
    public CatchDto(){

    }
    private Integer Id;
    private String weather;



    private String bow;
    private String bait;
    private String stringWeight;
    private String poleType;
    private String fishSpecies;
    private String weight;
    private String length;

    public CatchDto(String weather, String bow, String bait, String stringWeight, String poleType, String fishSpecies, String weight, String length) {
        this.weather = weather;
        this.bow = bow;
        this.bait = bait;
        this.stringWeight = stringWeight;
        this.poleType = poleType;
        this.fishSpecies = fishSpecies;
        this.weight = weight;
        this.length = length;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getWeather() {

        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getBow() {
        return bow;
    }

    public void setBow(String bow) {
        this.bow = bow;
    }

    public String getBait() {
        return bait;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }

    public String getStringWeight() {
        return stringWeight;
    }

    public void setStringWeight(String stringWeight) {
        this.stringWeight = stringWeight;
    }

    public String getPoleType() {
        return poleType;
    }

    public void setPoleType(String poleType) {
        this.poleType = poleType;
    }

    public String getFishSpecies() {
        return fishSpecies;
    }

    public void setFishSpecies(String fishSpecies) {
        this.fishSpecies = fishSpecies;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }




}
