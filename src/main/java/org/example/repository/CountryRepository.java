package org.example.repository;

import org.example.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Országok keresése név kezdőbetűje alapján
    List<Country> findByNameStartingWith(String prefix);

    // Országok keresése lakosság alapján
    List<Country> findByPopulationGreaterThan(Integer population);

    // Két feltétel kombinálása: kezdőbetű + lakosság
    List<Country> findByNameStartingWithAndPopulationGreaterThan(String prefix, Integer population);
}

