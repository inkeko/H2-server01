package org.example.repository;

import org.example.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameStartingWithAndPopulationGreaterThanEqual(String name, Integer population);

    // 🔹 Alapértelmezett országlista (nincs rendezés)
    @Query("SELECT c FROM Country c")
    List<Country> findAll();

    // 🔹 Csak az alapadatokat adja vissza (region nélkül!)
    @Query("SELECT c.code AS code, c.name AS name, c.continent AS continent, c.population AS population FROM Country c")
    List<Country> findBasicCountryInfo();

    // 🔹 Csak független országok alapadatai
    @Query("SELECT c FROM Country c WHERE c.indepyear IS NOT NULL")
    List<Country> findIndependentCountries();

    // 🔹 Csak független országok, népesség szerint rendezve
    @Query("SELECT c FROM Country c WHERE c.indepyear IS NOT NULL ORDER BY c.population DESC")
    List<Country> findIndependentCountriesOrderedByPopulation();

    // 🔹 Összes ország, népesség szerint rendezve
    @Query("SELECT c FROM Country c ORDER BY c.population DESC")
    List<Country> findAllOrderedByPopulation();

    // 🔹 Városok szűrése ország szerint
    @Query("SELECT c FROM Country c WHERE c.name LIKE :prefix% AND c.population > :population")
    List<Country> findByNameStartingWithAndPopulationGreaterThan(@Param("prefix") String prefix, @Param("population") Integer population);
}

