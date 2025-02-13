package org.example.controller;

import org.example.model.CountryLanguage;
import org.example.service.CountryLanguageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class CountryLanguageController {

    private final CountryLanguageService countryLanguageService;

    public CountryLanguageController(CountryLanguageService countryLanguageService) {
        this.countryLanguageService = countryLanguageService;
    }

    @GetMapping
    public List<CountryLanguage> getAllLanguages() {
        return countryLanguageService.getAllLanguages();
    }
    @GetMapping("/{countryCode}")
    public List<CountryLanguage> getLanguages(@PathVariable String countryCode) {
        return countryLanguageService.getLanguagesByCountry(countryCode);
    }
    @GetMapping("/{countryCode}/official")
    public List<CountryLanguage> getOfficialLanguages(@PathVariable String countryCode) {
        return countryLanguageService.getOfficialLanguagesByCountry(countryCode);
    }
}

