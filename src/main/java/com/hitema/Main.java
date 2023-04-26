package com.hitema;

import com.hitema.dao.CityDAOImpl;
import com.hitema.dao.CountryDAOImpl;
import com.hitema.entities.Country;

import java.time.Instant;

public class Main {

    private static final DBConnection dbConnection = new DBConnection();

        public static void main(String[] args) {
            System.out.println("<<<<<Start Console MySql>>>>>");
            try (var session = dbConnection.openCurrentSession()) {
                if (session == null) {
                    System.err.println("Erreur ouverture de Session");
                    System.exit((-1));
                }
            }

            CountryDAOImpl countryDAO = new CountryDAOImpl();
            CityDAOImpl cityDAO = new CityDAOImpl();

            // Afficher tous les pays
            countryDAO.findAll().forEach(System.out::println);
            // Afficher tous les villes
            cityDAO.findAll().forEach(System.out::println);

            // Ajouter un nouveau pays
            Country myCountry = new Country().name("MyCountry").lastUpdate(Instant.now());
            countryDAO.save(myCountry);

            // Mettre a jour le nouveau pays
            // countryDAO.update(myCountry.name("MyCountryUpdated"));

            countryDAO.findAll().forEach(System.out::println);

            System.out.println("<<<<<End Console MySql>>>>>");
        }
}