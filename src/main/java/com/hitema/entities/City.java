package com.hitema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name="city_id")
    private Long id;

    @Column(name="city")
    private String name;

    @Column(name="last_update")
    private Instant lastUpdate;

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
}
