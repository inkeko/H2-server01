package org.example.service;

import org.example.dto.CityDTO;
import org.example.model.City;
import org.example.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
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
    public List<CityDTO> getCitiesByCountry(String countryCode, boolean orderByPopulation) {
        List<City> cities = orderByPopulation
                ? cityRepository.findCitiesByCountryOrdered(countryCode)
                : cityRepository.findCitiesByCountry(countryCode);

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
    public List<CityDTO> getCitiesByContinent(String continent, boolean orderByPopulation) {
        List<City> cities = orderByPopulation
                ? cityRepository.findCitiesByContinentOrdered(continent)
                : cityRepository.findCitiesByContinent(continent);

        return cities.stream()
                .map(city -> new CityDTO(
                        city.getId(),
                        city.getName(),
                        city.getCountrycode(),
                        city.getDistrict(),
                        city.getPopulation()))
                .collect(Collectors.toList());
    }

    public List<String> getAllContinents() {
        return cityRepository.findAllContinents();
    }
}
