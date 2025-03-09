package org.example.dto;

public class IndependentCountryDTO {
    private final String code;
    private final String name;
    private final String continent;
    private final Integer population;
    private final Short indepyear;



    public IndependentCountryDTO(String code, String name, String continent, Integer population, Short indepyear) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.indepyear = indepyear;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getContinent() { return continent; }
    public Integer getPopulation() { return population; }
    public Short getIndepyear() { return indepyear; }
}

