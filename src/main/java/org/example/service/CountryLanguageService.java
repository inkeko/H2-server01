package org.example.service;

import org.example.model.CountryLanguage;
import org.example.repository.CountryLanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<CountryLanguage> getAllLanguages() {
        return countryLanguageRepository.findAll();
    }
    public List<CountryLanguage> getLanguagesByCountryCode(String countryCode) {
        return countryLanguageRepository.findByCountry_Code(countryCode);
    }
}

