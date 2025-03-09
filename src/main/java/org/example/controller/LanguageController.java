package org.example.controller;

import org.example.dto.LanguageDTO;
import org.example.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    // 🔹 1️⃣ Minden nyelv lekérdezése (opcionálisan csak a hivatalosak)
    @GetMapping
    public List<LanguageDTO> getLanguages(@RequestParam(required = false, defaultValue = "false") boolean onlyOfficial) {
        return languageService.getAllLanguages(onlyOfficial);
    }

    // 🔹 2️⃣ Összes nyelv egy adott ország szerint
    @GetMapping("/by-country/{countryCode}")
    public List<LanguageDTO> getLanguagesByCountry(@PathVariable String countryCode) {
        return languageService.getLanguagesByCountry(countryCode);
    }

    // 🔹 3️⃣ Csak a hivatalos nyelvek egy adott ország szerint
    @GetMapping("/by-country/{countryCode}/official")
    public List<LanguageDTO> getOfficialLanguagesByCountry(@PathVariable String countryCode) {
        return languageService.getOfficialLanguagesByCountry(countryCode);
    }
}
