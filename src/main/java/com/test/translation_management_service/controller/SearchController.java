package com.test.translation_management_service.controller;

import com.test.translation_management_service.model.Translation;
import com.test.translation_management_service.repository.TranslationRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class SearchController {

    private final TranslationRepository translationRepository;

    public SearchController(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    //Search by Locale
    @Operation(summary = "Search translations by locale")
    @GetMapping("/locale")
    public List<Translation> searchByLocale(@RequestParam String locale) {
        return translationRepository.findByLocale(locale);
    }

    //Search by Key
    @Operation(summary = "Search translations by key")
    @GetMapping("/key")
    public List<Translation> searchByKey(@RequestParam String key) {
        return translationRepository.findByKey(key);
    }

    //Search by Locale & Context (Tags)
    @Operation(summary = "Search translations by locale and context (tags)")
    @GetMapping("/locale-context")
    public List<Translation> searchByLocaleAndContext(@RequestParam String locale, @RequestParam String context) {
        return translationRepository.findByLocaleAndContext(locale, context);
    }

    //Search by Key & Context (Tags)
    @Operation(summary = "Search translations by key and context (tags)")
    @GetMapping("/key-context")
    public List<Translation> searchByKeyAndContext(@RequestParam String key, @RequestParam String context) {
        return translationRepository.findByKeyAndContext(key, context);
    }

    //Search by Key, Locale & Context
    @Operation(summary = "Search translations by key, locale, and context")
    @GetMapping("/search/advanced")
    public List<Translation> searchByKeyLocaleContext(
            @RequestParam String key,
            @RequestParam String locale,
            @RequestParam String context) {
        return translationRepository.findByKeyAndLocaleAndContext(key, locale, context);
    }

    //Full-Text Search by Value (Content)
    @Operation(summary = "Search translations by content (partial match)")
    @GetMapping("/search/content")
    public List<Translation> searchByContent(@RequestParam String value) {
        return translationRepository.findByValueContainingIgnoreCase(value);
    }
}
