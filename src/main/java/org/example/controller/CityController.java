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

    // Összes város lekérdezése (opcionális szűrőkkel)
    @GetMapping
    public List<CityDTO> getAllCities(
            @RequestParam(required = false, defaultValue = "false") boolean orderByPopulation,
            @RequestParam(required = false, defaultValue = "false") boolean onlyCapitals,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String continent) {

        // 🔹 Ha van ország kiválasztva, azt használjuk!
        if (country != null && !country.isEmpty()) {
            return cityService.getCitiesByCountry(country, orderByPopulation);
        }
        // 🔹 Ha nincs ország, de van kontinens, akkor kontinens alapján szűrünk
        if (continent != null && !continent.equalsIgnoreCase("Összes")) {
            return cityService.getCitiesByContinent(continent, orderByPopulation, onlyCapitals);
        }
        // 🔹 Ha sem ország, sem kontinens nincs kiválasztva, minden várost lekérdezünk
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
    // 🔹 Városok lekérdezése adott kontinens szerint (opcionális rendezéssel és főváros szűréssel)
    @GetMapping("/by-continent")
    public List<CityDTO> getCitiesByContinent(
            @RequestParam String continent,
            @RequestParam(required = false, defaultValue = "false") boolean orderByPopulation,
            @RequestParam(required = false, defaultValue = "false") boolean onlyCapitals) {  // ✅ HOZZÁADVA

        return cityService.getCitiesByContinent(continent, orderByPopulation, onlyCapitals); // ✅ HIÁNYZÓ PARAMÉTER
    }

    @GetMapping("/continents")
    public List<String> getContinents() {
        return cityService.getAllContinents();
    }


    @GetMapping("/countries/names")
    public List<String> getCountryNames() {
        return cityService.getAllCountryNames();
    }

    // 🔹 Országok lekérdezése adott kontinens szerint
    @GetMapping("/countries/by-continent")
    public List<String> getCountriesByContinent(@RequestParam String continent) {
        return cityService.getCountriesByContinent(continent);
    }


}
