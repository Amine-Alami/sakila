package com.hitema.dao;

import com.hitema.entities.Country;
import org.junit.jupiter.api.*;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryDAOImplTest {

    private static CountryDAOImpl countryDAO;

    @BeforeAll
    public static void setUp() {
        countryDAO = new CountryDAOImpl();
    }

    @AfterAll
    public static void tearDown() {
        countryDAO = null;
    }

    @Test
    public void testSave() {
        Country country = new Country().name("France").lastUpdate(Instant.now());
        countryDAO.save(country);
        Country savedCountry = countryDAO.find(country.getId());
        assertNotNull(savedCountry);
        assertEquals(country.getName(), savedCountry.getName());
    }

    @Test
    public void testFindAll() {
        List<Country> countries = countryDAO.findAll();
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }

    @Test
    public void testFind() {
        Long id = 1L;
        Country country = countryDAO.find(id);
        assertNotNull(country);
        assertEquals(id, country.getId());
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        Country country = countryDAO.find(id);
        String updatedName = "Updated Country";
        country.setName(updatedName);
        countryDAO.update(country);
        Country updatedCountry = countryDAO.find(id);
        assertNotNull(updatedCountry);
        assertEquals(updatedName, updatedCountry.getName());
    }

    @Test
    public void testGetByCity() {
        String city = "Paris";
        Country country = countryDAO.getByCity(city);
        assertNotNull(country);
        assertEquals("France", country.getName());
    }

    @Test
    public void testDelete() {
        Long id = 1L;
        Country country = countryDAO.find(id);
        countryDAO.delete(country);
        Country deletedCountry = countryDAO.find(id);
        assertNull(deletedCountry);
    }
}