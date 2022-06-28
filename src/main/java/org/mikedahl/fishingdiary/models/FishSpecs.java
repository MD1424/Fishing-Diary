package org.mikedahl.fishingdiary.models;

import javax.persistence.*;

@Entity(name = "types")
public class FishSpecs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fish_species")
    private String fishSpecies;
    @Column(name = "weight")
    private String weight;
    @Column(name = "length")
    private String length;

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


    public FishSpecs(String fishSpecies, String weight, String length) {
        this.fishSpecies = fishSpecies;
        this.weight = weight;
        this.length = length;
    }

    public FishSpecs() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }






}
