package com.hitema;

import com.hitema.dao.CityDAOImpl;
import com.hitema.dao.CountryDAOImpl;
import com.hitema.entities.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class Main {
        private static final Logger logger = LoggerFactory.getLogger(Main.class);

        public static void main(String[] args) {
            logger.info("<<<<<Start Console MySql>>>>>");

            CountryDAOImpl countryDAO = new CountryDAOImpl();
            CityDAOImpl cityDAO = new CityDAOImpl();

            // Afficher tous les pays
            countryDAO.findAll().forEach(country -> logger.info(country.toString()));
            // Afficher tous les villes
            cityDAO.findAll().forEach(city -> logger.info(city.toString()));

            // Ajouter un nouveau pays
            Country myCountry = new Country().name("MyCountry").lastUpdate(Instant.now());
            countryDAO.save(myCountry);

            // Mettre a jour le nouveau pays
            countryDAO.update(myCountry.name("MyCountryUpdated"));

            countryDAO.findAll().forEach(country -> logger.info(country.toString()));

            logger.info("<<<<<End Console MySql>>>>>");
        }
}