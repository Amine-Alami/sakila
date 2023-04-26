package com.hitema.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name="country_id")
    private long id;

    @Column(name="country")
    private String name;

    @Column(name="last_update")
    private Instant lastUpdate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Country id(long id) {
        this.id = id;
        return this;
    }

    public Country name(String name) {
        this.name = name;
        return this;
    }

    public Country lastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}