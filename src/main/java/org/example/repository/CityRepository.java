package org.example.repository;

import org.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
// Az findAll() metódust automatikusan biztosítja a JpaRepository

    List<City> findByCountrycode(String countrycode);
}
