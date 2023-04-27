package com.hitema.dao;

import com.hitema.entities.Country;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryDAOImplTest {

    @Test
    public void save() {
        CountryDAOImpl dao = new CountryDAOImpl();
        Country country = new Country().name("Kossovo").lastUpdate(Instant.now());
        dao.save(country);
        assertNotNull(country.getId(), "ERROR While creating COUNTRY");
    }

    @Test
    public void findAll() {
    }

    @Test
    public void find() {
        CountryDAOImpl dao = new CountryDAOImpl();
        var c = dao.find(1L);
        assertEquals("Afghanistan", c.getName(), "ERROR DB seems corrupted !!!!");
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}