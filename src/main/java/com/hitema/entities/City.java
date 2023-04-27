package com.hitema.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name="city_id", nullable = false)
    private Long id;

    @Column(name="city")
    private String name;

    @Column(name="last_update")
    private Instant lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return id + ". \t" + name + "\t" + lastUpdate ;
    }

    public City id(Long id) {
        this.id = id;
        return this;
    }

    public City name(String name) {
        this.name = name;
        return this;
    }

    public City lastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public City country(Country country) {
        this.country = country;
        return this;
    }
}
