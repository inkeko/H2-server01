package org.example.service;

import org.example.model.City;
import org.example.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    public List<City> getCitiesByCountry(String countrycode) {
        return cityRepository.findByCountryCode(countrycode);
    }

}

