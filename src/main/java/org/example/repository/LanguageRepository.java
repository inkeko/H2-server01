package org.example.repository;

import org.example.model.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguageRepository extends JpaRepository<CountryLanguage, Long> {

    // 🔹 1️⃣ Az összes nyelv lekérdezése
    @Query("SELECT cl FROM CountryLanguage cl")
    List<CountryLanguage> findAllLanguages();


    // 🔹 2️⃣ Országok adott nyelvre (hivatalos vagy nem hivatalos is)
    @Query("SELECT cl FROM CountryLanguage cl WHERE cl.isofficial = 'T'")
    List<CountryLanguage> findOfficialLanguages();


    @Query("SELECT cl FROM CountryLanguage cl WHERE cl.country.code = :countryCode")
    List<CountryLanguage> findLanguagesByCountry(@Param("countryCode") String countryCode);

    @Query("SELECT cl FROM CountryLanguage cl WHERE cl.country.code = :countryCode AND cl.isofficial = 'T'")
    List<CountryLanguage> findOfficialLanguagesByCountry(@Param("countryCode") String countryCode);

}