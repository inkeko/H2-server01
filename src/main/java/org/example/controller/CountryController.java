
package org.example.controller;

import org.example.service.CountryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Map<String, Object>> getCountries(
            @RequestParam(name = "independent", required = false, defaultValue = "false") boolean independent,
            @RequestParam(name = "orderByPopulation", required = false, defaultValue = "false") boolean orderByPopulation) {

        return countryService.getFilteredCountries(independent, orderByPopulation);
    }

    @GetMapping("/search")
    public List<Map<String, Object>> searchCountries(
            @RequestParam(required = false) String prefix,
            @RequestParam(required = false) Integer population) {

        return countryService.getCountriesByNameAndPopulation(prefix, population);
    }

    @GetMapping("/basic")
    public List<Map<String, Object>> getBasicCountryInfo() {
        return countryService.getBasicCountryInfo();
    }
}
