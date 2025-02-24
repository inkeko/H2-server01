package org.example.repository;

import org.example.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameStartingWithAndPopulationGreaterThanEqual(String name, Integer population);


    // 🔹 Csak az alapadatokat adja vissza (region nélkül!)
    @Query("SELECT c.code AS code, c.name AS name, c.continent AS continent, c.population AS population FROM Country c")
    List<Map<String, Object>> findBasicCountryInfo();

    // 🔹 Csak független országok alapadatai
    @Query("SELECT c.code AS code, c.name AS name, c.continent AS continent, c.population AS population FROM Country c WHERE c.indepyears IS NOT NULL")
    List<Map<String, Object>> findIndependentCountries();

    // 🔹 Csak független országok, népesség szerint rendezve
    @Query("SELECT c.code AS code, c.name AS name, c.continent AS continent, c.population AS population FROM Country c WHERE c.indepyears IS NOT NULL ORDER BY c.population DESC")
    List<Map<String, Object>> findIndependentCountriesOrderedByPopulation();

    // 🔹 Összes ország, népesség szerint rendezve
    @Query("SELECT c.code AS code, c.name AS name, c.continent AS continent, c.population AS population FROM Country c ORDER BY c.population DESC")
    List<Map<String, Object>> findAllOrderedByPopulation();
}
