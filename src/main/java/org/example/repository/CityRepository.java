package org.example.repository;



import org.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    // 🔹 Összes város lekérdezése
    @Query("SELECT c FROM City c")
    List<City> findAll();

    // 🔹 Összes város, népesség szerint rendezve
    @Query("SELECT c FROM City c ORDER BY c.population DESC")
    List<City> findAllOrderedByPopulation();

    // 🔹 Csak fővárosok
    @Query("SELECT c FROM City c WHERE c.id IN (SELECT co.capital FROM Country co)")
    List<City> findCapitals();

    // 🔹 Csak fővárosok, népesség szerint rendezve
    @Query("SELECT c FROM City c WHERE c.id IN (SELECT co.capital FROM Country co) ORDER BY c.population DESC")
    List<City> findCapitalsOrderedByPopulation();

    // 🔹 Városok adott ország szerint
    @Query("SELECT c FROM City c WHERE c.countrycode = :countryCode")
    List<City> findCitiesByCountry(@Param("countryCode") String countryCode);

    // 🔹 Városok adott ország szerint, népesség szerint rendezve
    @Query("SELECT c FROM City c WHERE c.countrycode = :countryCode ORDER BY c.population DESC")
    List<City> findCitiesByCountryOrdered(@Param("countryCode") String countryCode);

    // 🔹 Városok adott kontinens szerint
    @Query("SELECT c FROM City c WHERE c.countrycode IN (SELECT co.code FROM Country co WHERE co.continent = :continent)")
    List<City> findCitiesByContinent(@Param("continent") String continent);


    @Query("SELECT c FROM City c WHERE c.countrycode IN (SELECT co.code FROM Country co WHERE co.continent = :continent) ORDER BY c.population DESC")
    List<City> findCitiesByContinentOrdered(@Param("continent") String continent);

    //Ez a lekérdezés az országok táblájából (Country) szedi ki a kontinenseket
    @Query("SELECT DISTINCT co.continent FROM Country co")
    List<String> findAllContinents();

}
