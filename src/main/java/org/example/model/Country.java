package org.example.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code", nullable = false, length = 3)
    private String code;

    @Column(name = "Name", nullable = false, length = 52)
    private String name;

    @Column(name = "Continent", nullable = false, length = 50)
    private String continent;

    @Column(name = "Region", nullable = false, length = 26)
    private String region;

    @Column(name = "Surfacearea", nullable = false)
    private Double surfacearea;

    @Column(name = "Indepyears")
    private Short indepyears;

    @Column(name = "Population", nullable = false)
    private Integer population;

    @Column(name = "Lifeexpectancy")
    private Double lifeexpectancy;

    @Column(name = "GNP")
    private Double gnp;

    @Column(name = "GNPOld")
    private Double gnpOld;

    @Column(name = "Localname", nullable = false, length = 45)
    private String localname;

    @Column(name = "Government", nullable = false, length = 45)
    private String government;

    @Column(name = "Leader", length = 60)
    private String leader;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2", nullable = false, length = 2)
    private String code2;

    // Getterek, setterek maradhatn...


    public Country() {
    }

    public Country(String code, String name, String continent, String region, Double surfacearea, Short indepyears, Integer population, Double lifeexpectancy, Double gnp, Double gnpOld, String localname, String government, String leader, Integer capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfacearea = surfacearea;
        this.indepyears = indepyears;
        this.population = population;
        this.lifeexpectancy = lifeexpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localname = localname;
        this.government = government;
        this.leader = leader;
        this.capital = capital;
        this.code2 = code2;
    }

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSurfaceArea() {
        return surfacearea;
    }

    public void setSurfaceArea(Double surfaceArea) {
        this.surfacearea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepyears;
    }

    public void setIndepYear(Short indepYear) {
        this.indepyears = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getLifeExpectancy() {
        return lifeexpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeexpectancy = lifeExpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    public Double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localname;
    }

    public void setLocalName(String localName) {
        this.localname = localName;
    }

    public String getGovernmentForm() {
        return government;
    }

    public void setGovernmentForm(String governmentForm) {
        this.government = governmentForm;
    }

    public String getHeadOfState() {
        return leader;
    }

    public void setHeadOfState(String headOfState) {
        this.leader = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code) && Objects.equals(name, country.name) && Objects.equals(continent, country.continent) && Objects.equals(region, country.region) && Objects.equals(surfacearea, country.surfacearea) && Objects.equals(indepyears, country.indepyears) && Objects.equals(population, country.population) && Objects.equals(lifeexpectancy, country.lifeexpectancy) && Objects.equals(gnp, country.gnp) && Objects.equals(gnpOld, country.gnpOld) && Objects.equals(localname, country.localname) && Objects.equals(government, country.government) && Objects.equals(leader, country.leader) && Objects.equals(capital, country.capital) && Objects.equals(code2, country.code2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, continent, region, surfacearea, indepyears, population, lifeexpectancy, gnp, gnpOld, localname, government, leader, capital, code2);
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfacearea +
                ", indepYear=" + indepyears +
                ", population=" + population +
                ", lifeExpectancy=" + lifeexpectancy +
                ", gnp=" + gnp +
                ", gnpOld=" + gnpOld +
                ", localName='" + localname + '\'' +
                ", governmentForm='" + government + '\'' +
                ", headOfState='" + leader + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
