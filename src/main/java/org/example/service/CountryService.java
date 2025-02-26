package org.example.service;

import org.example.dto.CountryBasicDTO;
import org.example.dto.IndependentCountryDTO;
import org.example.model.Country;
import org.example.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // ✅ Összes ország listázása DTO formátumban, opcionális rendezéssel
    public List<CountryBasicDTO> getAllCountries(boolean orderByPopulation) {
        List<Country> countries = orderByPopulation
                ? countryRepository.findAllOrderedByPopulation()  // Ha true, akkor rendezett listát ad
                : countryRepository.findAll();  // Egyébként sima listát

        return countries.stream()
                .map(c -> new CountryBasicDTO(
                        c.getCode(),
                        c.getName(),
                        c.getContinent(),
                        c.getPopulation()))
                .collect(Collectors.toList());
    }

    // ✅ Csak független országokat küld vissza DTO formátumban, népesség szerinti rendezéssel
    public List<IndependentCountryDTO> getIndependentCountries(boolean orderByPopulation) {
        List<Country> countries = orderByPopulation
                ? countryRepository.findIndependentCountriesOrderedByPopulation()
                : countryRepository.findIndependentCountries();

        return countries.stream()
                .map(c -> new IndependentCountryDTO(
                        c.getCode(),
                        c.getName(),
                        c.getContinent(),
                        c.getPopulation(),
                        c.getIndepyears()))
                .collect(Collectors.toList());
    }
}


