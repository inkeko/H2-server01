package org.example.dto;

public class CountryDTO {
    private String code;
    private String name;
    private String continent;
    private int population;

    public CountryDTO() {
    }

    public CountryDTO(String code, String name, String continent, int population) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
    }

    // Getters and Setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

