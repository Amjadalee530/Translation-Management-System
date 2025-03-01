package com.test.translation_management_service.controller;

import com.test.translation_management_service.model.Translation;
import com.test.translation_management_service.repository.TranslationRepository;
import com.test.translation_management_service.service.TranslationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Translations", description = "API endpoints for managing translations")
@RestController
@RequestMapping("/api/translations")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @Autowired
    private TranslationRepository  translationRepository;

    @Operation(summary = "Get all translations", description = "Fetch all translations from the database.")
    @GetMapping
    public ResponseEntity<List<Translation>> getAllTranslations() {
        return ResponseEntity.ok(translationService.getAllTranslations());
    }

    @Operation(summary = "Get a translation by ID", description = "Fetch a single translation by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Translation>> getTranslationById(@PathVariable Long id) {
        return ResponseEntity.ok(translationService.getTranslationById(id));
    }

    @Operation(summary = "Get translations by locale", description = "Fetch translations for a specific language locale (e.g., en, fr, es).")
    @GetMapping("/locale/{locale}")
    public ResponseEntity<List<Translation>> getTranslationsByLocale(@PathVariable String locale) {
        return ResponseEntity.ok(translationService.getTranslationsByLocale(locale));
    }

    // ✅ Prevent duplicates: If translation exists, update it; otherwise, create a new one
    @Operation(summary = "Create or update a translation")
    @PostMapping
    public ResponseEntity<Translation> saveOrUpdateTranslation(@RequestBody Translation translation) {
        Optional<Translation> existingTranslation = translationRepository.findByKeyAndLocale(translation.getKey(), translation.getLocale());

        if (existingTranslation.isPresent()) {
            Translation updatedTranslation = existingTranslation.get();
            updatedTranslation.setValue(translation.getValue());
            updatedTranslation.setContext(translation.getContext());
            return ResponseEntity.ok(translationRepository.save(updatedTranslation)); // ✅ Update existing
        } else {
            return ResponseEntity.ok(translationRepository.save(translation)); // ✅ Create new
        }
    }

    @Operation(summary = "Update an existing translation", description = "Update an existing translation using its ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Translation> updateTranslation(@PathVariable Long id, @RequestBody Translation translation) {
        return ResponseEntity.ok(translationService.updateTranslation(id, translation));
    }

    @Operation(summary = "Delete a translation", description = "Remove a translation from the database by ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTranslation(@PathVariable Long id) {
        translationService.deleteTranslation(id);
        return ResponseEntity.ok("Translation deleted successfully.");
    }
}
