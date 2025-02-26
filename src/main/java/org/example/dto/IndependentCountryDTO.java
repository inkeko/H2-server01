package org.example.dto;

public class IndependentCountryDTO {
    private String code;
    private String name;
    private String continent;
    private Integer population;
    private Short indepyears;



    public IndependentCountryDTO(String code, String name, String continent, Integer population, Short indepyears) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.indepyears = indepyears;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getContinent() { return continent; }
    public Integer getPopulation() { return population; }
    public Short getIndepyears() { return indepyears; }
}

