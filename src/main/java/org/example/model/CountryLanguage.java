package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id; // Összetett elsődleges kulcs

    @ManyToOne
    @JoinColumn(name = "Countrycode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;

    @Column(name = "Isofficial", nullable = false, length = 1)
    private String isofficial;

    @Column(name = "Percentage", nullable = false, precision = 4)
    private Double percentage;

    public CountryLanguage() {}

    public CountryLanguage(CountryLanguageId id, Country country, String isofficial, Double percentage) {
        this.id = id;
        this.country = country;
        this.isofficial = isofficial;
        this.percentage = percentage;
    }

    public CountryLanguageId getId() { return id; }
    public void setId(CountryLanguageId id) { this.id = id; }

    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }

    public String getIsOfficial() { return isofficial; }
    public void setIsOfficial(String isOfficial) { this.isofficial = isOfficial; }

    public Double getPercentage() { return percentage; }
    public void setPercentage(Double percentage) { this.percentage = percentage; }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", isOfficial='" + isofficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}

