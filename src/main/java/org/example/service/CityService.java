package org.example.service;

import org.example.dto.CityDTO;
import org.example.model.City;
import org.example.model.Country;
import org.example.repository.CityRepository;
import org.example.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CityService {
    private final CityRepository cityRepository;
 private final CountryRepository countryRepository;
    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }


    // ✅ Összes város listázása DTO formátumban, opcionális rendezéssel és főváros szűréssel
    public List<CityDTO> getAllCities(boolean orderByPopulation, boolean onlyCapitals) {
        List<City> cities;
        if (onlyCapitals) {
            cities = orderByPopulation
                    ? cityRepository.findCapitalsOrderedByPopulation()
                    : cityRepository.findCapitals();
        } else {
            cities = orderByPopulation
                    ? cityRepository.findAllOrderedByPopulation()
                    : cityRepository.findAll();
        }

        return cities.stream()
                .map(city -> new CityDTO(
                        city.getId(),
                        city.getName(),
                        city.getCountrycode(),
                        city.getDistrict(),
                        city.getPopulation()))
                .collect(Collectors.toList());
    }

    // ✅ Városok lekérdezése adott ország szerint, opcionális rendezéssel
    public List<CityDTO> getCitiesByCountry(String countryName, boolean orderByPopulation) {
        List<City> cities = orderByPopulation
                ? cityRepository.findCitiesByCountryOrdered(countryName)
                : cityRepository.findCitiesByCountry(countryName);

        return cities.stream()
                .map(city -> new CityDTO(
                        city.getId(),
                        city.getName(),
                        city.getCountrycode(),
                        city.getDistrict(),
                        city.getPopulation()))
                .collect(Collectors.toList());
    }

    // ✅ Városok lekérdezése adott kontinens szerint, opcionális rendezéssel
    public List<CityDTO> getCitiesByContinent(String continent, boolean orderByPopulation, boolean onlyCapitals) {
        // 🌍 Ha "Összes", akkor minden várost adjunk vissza
        if (continent == null || continent.equalsIgnoreCase("Összes")) {
            return getAllCities(orderByPopulation, onlyCapitals);
        }

        List<City> cities;
        if (onlyCapitals) {
            cities = orderByPopulation
                    ? cityRepository.findCapitalsByContinentOrdered(continent)
                    : cityRepository.findCapitalsByContinent(continent);
        } else {
            cities = orderByPopulation
                    ? cityRepository.findCitiesByContinentOrdered(continent)
                    : cityRepository.findCitiesByContinent(continent);
        }

        return cities.stream()
                .map(city -> new CityDTO(
                        city.getId(),
                        city.getName(),
                        city.getCountrycode(),
                        city.getDistrict(),
                        city.getPopulation()))
                .collect(Collectors.toList());
    }



    // ✅ Kontinensek lekérdezése
    public List<String> getAllContinents() {
        return cityRepository.findAllContinents();
    }

    public List<String> getAllCountryNames() {
        return cityRepository.findAllCountryNames();
    }


    public List<String> getCountriesByContinent(String continent) {
        return cityRepository.findCountryNamesByContinent(continent.trim());
    }



    // 🔹 ÚJ: Országnevek és országkódok párosítása
    public Map<String, String> getAllCountryCodes() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream()
                .collect(Collectors.toMap(Country::getName, Country::getCode));
    }



}
