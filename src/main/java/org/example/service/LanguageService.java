package org.example.service;

import org.example.dto.LanguageDTO;
import org.example.model.CountryLanguage;
import org.example.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageDTO> getAllLanguages(boolean onlyOfficial) {
        List<CountryLanguage> languages = onlyOfficial
                ? languageRepository.findOfficialLanguages()
                : languageRepository.findAllLanguages();

        return languages.stream()
                .map(lang -> new LanguageDTO(
                       lang.getId().getLanguage(),
                lang.getCountry().getCode(),
                lang.getIsOfficial(),
                lang.getPercentage()))
                .collect(Collectors.toList());
    }

    // 🔹 2️⃣ Egy adott ország összes nyelvének lekérdezése
    public List<LanguageDTO> getLanguagesByCountry(String countryCode) {
        List<CountryLanguage> languages = languageRepository.findLanguagesByCountry(countryCode);
        return convertToDTO(languages);
    }

    // 🔹 3️⃣ Egy adott ország hivatalos nyelveinek lekérdezése
    public List<LanguageDTO> getOfficialLanguagesByCountry(String countryCode) {
        List<CountryLanguage> languages = languageRepository.findOfficialLanguagesByCountry(countryCode);
        return convertToDTO(languages);
    }
    // 🛠 Segédmetódus DTO konvertáláshoz
    private List<LanguageDTO> convertToDTO(List<CountryLanguage> languages) {
        return languages.stream()
                .map(lang -> new LanguageDTO(
                        lang.getId().getLanguage(),
                        lang.getCountry().getCode(),
                        lang.getIsOfficial(),
                        lang.getPercentage()))
                .collect(Collectors.toList());
    }
}
