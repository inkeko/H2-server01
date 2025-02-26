package org.example.dto;

public class CountryBasicDTO {
    private String code;
    private String name;
    private String continent;
    private int population;

    public CountryBasicDTO(String code, String name, String continent, int population) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
    }

    // ✅ Getterek (nincs szükség setterekre, ha immutable DTO-t szeretnél)
    public String getCode() { return code; }
    public String getName() { return name; }
    public String getContinent() { return continent; }
    public int getPopulation() { return population; }
}
