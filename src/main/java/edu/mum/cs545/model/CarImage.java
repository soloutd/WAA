package edu.mum.cs545.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CarImage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @NotNull
    @Column(name="url")
    private String url;

    public CarImage() {
    }

    public CarImage(String url) {
        this.url = url;
    }
    public CarImage(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
