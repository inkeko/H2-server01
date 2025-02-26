
package org.example.controller;

import org.example.dto.CountryBasicDTO;
import org.example.dto.IndependentCountryDTO;
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

    // ✅ Alapadatokat visszaadó végpont (népesség szerinti rendezés opcionálisan)
    @GetMapping
    public List<CountryBasicDTO> getCountries(
            @RequestParam(required = false, defaultValue = "false") boolean orderByPopulation) {
        return countryService.getAllCountries(orderByPopulation);
    }

    // ✅ Független országok lekérdezése DTO formátumban (népesség szerinti rendezéssel)
    @GetMapping("/independent")
    public List<IndependentCountryDTO> getIndependentCountries(
            @RequestParam(required = false, defaultValue = "false") boolean orderByPopulation) {
        return countryService.getIndependentCountries(orderByPopulation);
    }
}
