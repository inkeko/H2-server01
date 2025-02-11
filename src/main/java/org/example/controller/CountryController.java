package org.example.controller;

import org.example.model.Country;
import org.example.service.CountryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // Összes ország lekérdezése
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // Országok lekérdezése név kezdőbetűje alapján
    @GetMapping("/search")
    public List<Country> searchCountries(
            @RequestParam(required = false) String prefix,
            @RequestParam(required = false) Integer population) {

        if (prefix == null || prefix.isEmpty()) {
            return countryService.getAllCountries();
        }

        return countryService.getCountriesByNameAndPopulation(prefix, population);
    }
    @GetMapping("/basic")
    public List<Object[]> getBasicCountryInfo() {
        return countryService.getBasicCountryInfo();
    }
    }


