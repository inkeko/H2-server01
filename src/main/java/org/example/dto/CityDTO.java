package org.example.dto;

public class CityDTO {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    public CityDTO(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCountryCode() { return countryCode; }
    public String getDistrict() { return district; }
    public int getPopulation() { return population; }
}


