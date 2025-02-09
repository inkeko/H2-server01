package org.example.service;

import org.example.model.Country;
import org.example.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // Összes ország listázása
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Országok lekérdezése név kezdőbetűje alapján
    public List<Country> getCountriesByNamePrefix(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }

    // Országok lekérdezése lakosság alapján
    public List<Country> getCountriesByPopulation(Integer population) {
        return countryRepository.findByPopulationGreaterThan(population);
    }

    // Országok lekérdezése név kezdőbetűje + lakossági feltétellel
    public List<Country> getCountriesByNameAndPopulation(String prefix, Integer population) {
        if (population == null) {
            return getCountriesByNamePrefix(prefix);
        }
        return countryRepository.findByNameStartingWithAndPopulationGreaterThan(prefix, population);
    }
}

