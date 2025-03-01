package org.example.controller;

import org.example.dto.CityDTO;
import org.example.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    // 🔹 Összes város lekérdezése (opcionális rendezéssel)
    @GetMapping
    public List<CityDTO> getAllCities(
            @RequestParam(required = false, defaultValue = "false") boolean orderByPopulation,
            @RequestParam(required = false, defaultValue = "false") boolean onlyCapitals) {
        return cityService.getAllCities(orderByPopulation, onlyCapitals);
    }

    // 🔹 Városok lekérdezése adott ország szerint (opcionális rendezéssel)
    @GetMapping("/by-country")
    public List<CityDTO> getCitiesByCountry(
            @RequestParam String countryCode,
            @RequestParam(required = false, defaultValue = "false") boolean orderByPopulation) {
        return cityService.getCitiesByCountry(countryCode, orderByPopulation);
    }

    // 🔹 Városok lekérdezése adott kontinens szerint (opcionális rendezéssel)
    @GetMapping("/by-continent")
    public List<CityDTO> getCitiesByContinent(
            @RequestParam String continent,
            @RequestParam(required = false, defaultValue = "false") boolean orderByPopulation) {
        return cityService.getCitiesByContinent(continent, orderByPopulation);
    }
    @GetMapping("/continents")
    public List<String> getContinents() {
        return cityService.getAllContinents();
    }
}
