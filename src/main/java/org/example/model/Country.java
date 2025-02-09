package org.example.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name= "Code", nullable = false, length = 3)
    private String code; // String, mert CHAR(3) az adatbázisban

    @Column(name="Name", nullable = false, length = 52) // 52 karakter hossz
    private String name;

    @Column(name="Continent", nullable = false, length = 50)
    private String continent;

    @Column(name="Region", nullable = false, length = 26)
    private String region;

    @Column(name="SurfaceArea", nullable = false)
    private Double surfaceArea;

    @Column(name="IndepYear")
    private Short indepYear; // SMALLINT megfelelője a Java-ban

    @Column(name="Population", nullable = false)
    private Integer population;

    @Column(name="LifeExpectancy" )
    private Double lifeExpectancy;

    @Column(name="GNP")
    private Double gnp;

    @Column(name="GNPOld" )
    private Double gnpOld;

    @Column(name="LocalName", nullable = false, length = 45)
    private String localName;

    @Column(name="GovernmentForm", nullable = false, length = 45)
    private String governmentForm;

    @Column(name="HeadOfState", length = 60)
    private String headOfState;

    @Column(name="Capital")
    private Integer capital;

    @Column(name="Code2", nullable = false, length = 2)
    private String code2;

    // Konstruktorok
    public Country() {}

    public Country(String code, String name, String continent, String region, Double surfaceArea, Short indepYear,
                   Integer population, Double lifeExpectancy, Double gnp, Double gnpOld, String localName,
                   String governmentForm, String headOfState, Integer capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    // Getterek és Setterek
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public Double getSurfaceArea() { return surfaceArea; }
    public void setSurfaceArea(Double surfaceArea) { this.surfaceArea = surfaceArea; }

    public Short getIndepYear() { return indepYear; }
    public void setIndepYear(Short indepYear) { this.indepYear = indepYear; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }

    public Double getLifeExpectancy() { return lifeExpectancy; }
    public void setLifeExpectancy(Double lifeExpectancy) { this.lifeExpectancy = lifeExpectancy; }

    public Double getGnp() { return gnp; }
    public void setGnp(Double gnp) { this.gnp = gnp; }

    public Double getGnpOld() { return gnpOld; }
    public void setGnpOld(Double gnpOld) { this.gnpOld = gnpOld; }

    public String getLocalName() { return localName; }
    public void setLocalName(String localName) { this.localName = localName; }

    public String getGovernmentForm() { return governmentForm; }
    public void setGovernmentForm(String governmentForm) { this.governmentForm = governmentForm; }

    public String getHeadOfState() { return headOfState; }
    public void setHeadOfState(String headOfState) { this.headOfState = headOfState; }

    public Integer getCapital() { return capital; }
    public void setCapital(Integer capital) { this.capital = capital; }

    public String getCode2() { return code2; }
    public void setCode2(String code2) { this.code2 = code2; }

    // equals() és hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    // toString()
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", gnp=" + gnp +
                ", gnpOld=" + gnpOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital=" + capital +
                ", code2='" + code2 + '\'' +
                '}';
    }
}
