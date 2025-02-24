package org.example.service;

import org.example.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // 🔹 Összes ország lekérése (csak alapadatok!)
    public List<Map<String, Object>> getBasicCountryInfo() {
        return countryRepository.findBasicCountryInfo();
    }

    // 🔹 Országok keresése név kezdőbetűje és népesség alapján
    public List<Map<String, Object>> getCountriesByNameAndPopulation(String prefix, Integer population) {
        return countryRepository.findByNameStartingWithAndPopulationGreaterThan(prefix, population);
    }

    // 🔹 Csak független országok lekérése
    public List<Map<String, Object>> getIndependentCountries() {
        return countryRepository.findIndependentCountries();
    }

    // 🔹 Független országok népesség szerint rendezve
    public List<Map<String, Object>> getIndependentCountriesOrderedByPopulation() {
        return countryRepository.findIndependentCountriesOrderedByPopulation();
    }

    // 🔹 Összes ország népesség szerint rendezve
    public List<Map<String, Object>> getAllCountriesOrderedByPopulation() {
        return countryRepository.findAllOrderedByPopulation();
    }

    // 🔹 **Hiányzó metódus: országok szűrése függetlenség és népesség szerint**
    public List<Map<String, Object>> getFilteredCountries(boolean independent, boolean orderByPopulation) {
        if (independent && orderByPopulation) {
            return countryRepository.findIndependentCountriesOrderedByPopulation();
        } else if (independent) {
            return countryRepository.findIndependentCountries();
        } else if (orderByPopulation) {
            return countryRepository.findAllOrderedByPopulation();
        } else {
            return countryRepository.findBasicCountryInfo();
        }
    }
}
