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

    // Összes nyelv lekérdezése
    public List<CountryLanguage> getAllLanguages() {
        return countryLanguageRepository.findAll();
    }

    // Egy adott ország összes nyelvének lekérdezése
    public List<CountryLanguage> getLanguagesByCountry(String countryCode) {
        return countryLanguageRepository.findByCountry_Code(countryCode);
    }

    // Egy adott ország **csak a hivatalos nyelveinek** lekérdezése
    public List<CountryLanguage> getOfficialLanguagesByCountry(String countryCode) {
        return countryLanguageRepository.findByCountry_CodeAndIsofficial(countryCode, "T"); // "T" az igaz érték
    }


}

