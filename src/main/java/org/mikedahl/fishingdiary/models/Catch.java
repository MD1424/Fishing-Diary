package org.mikedahl.fishingdiary.models;

import javax.persistence.*;

@Entity
public class Catch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    @ManyToOne
    private BOW bow;
    @JoinColumn
    @ManyToOne
    private FishSpecs fs;
    @JoinColumn
    @ManyToOne
    private Gear gear;


    @JoinColumn
    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Catch{" +
                "id=" + id +
                ", bow=" + bow +
                ", fs=" + fs +
                ", gear=" + gear +
                ", weather=" + weather +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn
    @ManyToOne
    private Weather weather;

    public BOW getBow() {
        return bow;
    }

    public void setBow(BOW bow) {
        this.bow = bow;
    }

    public FishSpecs getFs() {
        return fs;
    }

    public void setFs(FishSpecs fs) {
        this.fs = fs;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
