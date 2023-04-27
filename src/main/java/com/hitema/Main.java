package com.hitema;

import com.hitema.dao.CityDAOImpl;
import com.hitema.dao.CountryDAOImpl;
import com.hitema.entities.City;
import com.hitema.entities.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Main {
        private static final Logger logger = LoggerFactory.getLogger(Main.class);

        public static void main(String[] args) {
            logger.info("<<<<<Start Console MySql>>>>>");

            countryCityOperations();

            logger.info("<<<<<End Console MySql>>>>>");
        }

    private static void countryCityOperations() {
        CountryDAOImpl countryDAO = new CountryDAOImpl();
        CityDAOImpl cityDAO = new CityDAOImpl();

        // Creer un nouveau pays
        // Country myCountry = countryDAO.save(new Country().name("MyCountry").lastUpdate(Instant.now()));
        // Mettre a jour le nouveau pays
        // myCountry = countryDAO.update(myCountry.name("MyCountryUpdated"));

        // Creer une nouvelle ville
        // City myCity = cityDAO.save(new City().name("MyCity").lastUpdate(Instant.now()).country(myCountry));

        // Afficher tous les pays
        countryDAO.findAll().forEach(country -> logger.trace(country.toString()));
        // Afficher tous les villes
        cityDAO.findAll().forEach(city -> logger.trace(city.toString()));

        logger.info("********************************");
        cityDAO.getAllByCountry("Morocco").forEach(city -> logger.trace(city.toString()));
        logger.info("********************************");
        logger.trace(countryDAO.getByCity("Aurora").toString());
    }
}