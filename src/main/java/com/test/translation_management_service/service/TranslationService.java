package com.test.translation_management_service.service;

import com.test.translation_management_service.model.Translation;
import com.test.translation_management_service.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    public List<Translation> getAllTranslations() {
        return translationRepository.findAll();
    }

    public Optional<Translation> getTranslationById(Long id) {
        return translationRepository.findById(id);
    }

    public List<Translation> getTranslationsByLocale(String locale) {
        return translationRepository.findByLocale(locale);
    }

    public Translation createTranslation(Translation translation) {
        return translationRepository.save(translation);
    }

    public Translation updateTranslation(Long id, Translation newTranslation) {
        return translationRepository.findById(id).map(existingTranslation -> {
            existingTranslation.setKey(newTranslation.getKey());
            existingTranslation.setLocale(newTranslation.getLocale());
            existingTranslation.setValue(newTranslation.getValue());
            existingTranslation.setContext(newTranslation.getContext());
            return translationRepository.save(existingTranslation);
        }).orElseThrow(() -> new RuntimeException("Translation not found"));
    }

    public void deleteTranslation(Long id) {
        translationRepository.deleteById(id);
    }
}
