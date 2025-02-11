package org.example.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguageId implements Serializable {

    @Column(name = "Countrycode", length = 3)
    private String countrycode;

    @Column(name = "Language", length = 30)
    private String language;

    public CountryLanguageId() {}

    public CountryLanguageId(String countrycode, String language) {
        this.countrycode = countrycode;
        this.language = language;
    }

    public String getCountryCode() { return countrycode; }
    public void setCountryCode(String countryCode) { this.countrycode = countryCode; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(countrycode, that.countrycode) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countrycode, language);
    }
}

