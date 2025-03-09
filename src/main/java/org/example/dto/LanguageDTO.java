package org.example.dto;

public class LanguageDTO {
    private String language;
    private String countryCode;
    private boolean isOfficial;  // 🔄 String helyett boolean
    private double percentage;

    public LanguageDTO() {
    }

    public LanguageDTO(String language, String countryCode, boolean isOfficial, double percentage) {
        this.language = language;
        this.countryCode = countryCode;
        this.isOfficial = isOfficial; // 🔥 🔄 Átalakítás boolean értékre!
        this.percentage = percentage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

}

