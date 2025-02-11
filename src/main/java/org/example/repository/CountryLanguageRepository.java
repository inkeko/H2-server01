package org.example.repository;

import org.example.model.CountryLanguage;
import org.example.model.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    List<CountryLanguage> findByCountry_Code(String countryCode);
}

