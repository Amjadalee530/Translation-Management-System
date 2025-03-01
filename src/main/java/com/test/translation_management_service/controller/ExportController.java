package com.test.translation_management_service.controller;

import com.test.translation_management_service.model.Translation;
import com.test.translation_management_service.repository.TranslationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/export")
@Tag(name = "Translation Export", description = "Endpoints for exporting translations in JSON format")
public class ExportController {

    private final TranslationRepository translationRepository;

    public ExportController(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @Operation(
            summary = "Export translations as JSON",
            description = "Returns all translations grouped by locale for frontend applications like Vue.js."
    )
    @GetMapping(value = "/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Map<String, Map<String, String>>> exportTranslations() {
        Map<String, Map<String, String>> groupedTranslations = translationRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Translation::getLocale,
                        Collectors.toMap(Translation::getKey, Translation::getValue, (existing, replacement) -> existing)
                ));

        return ResponseEntity.ok(groupedTranslations);
    }
}
