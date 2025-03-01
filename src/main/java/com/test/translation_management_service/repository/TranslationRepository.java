package com.test.translation_management_service.repository;

import com.test.translation_management_service.model.Translation;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {

    //Search by Locale
    @Transactional(readOnly = true)
    List<Translation> findByLocale(String locale);

    @Query("SELECT t FROM Translation t")
    Stream<Translation> streamAllBy();

    @Transactional(readOnly = true)
    Page<Translation> findAll(Pageable pageable);

    // ✅ Fetch a specific translation by key and locale
    @Transactional(readOnly = true)
    Optional<Translation> findByKeyAndLocale(String key, String locale);

    //Search by Locale & Context (Tags)
    @Transactional(readOnly = true)
    List<Translation> findByLocaleAndContext(String locale, String context);

    // Search by Key
    @Transactional(readOnly = true)
    List<Translation> findByKey(String key);

    // Search by Key & Context (Tags)
    @Transactional(readOnly = true)
    List<Translation> findByKeyAndContext(String key, String context);

    //Search by Key, Locale & Context
    @Transactional(readOnly = true)
    List<Translation> findByKeyAndLocaleAndContext(String key, String locale, String context);

    //Search by Value (Content) - For full-text search
    @Transactional(readOnly = true)
    List<Translation> findByValueContainingIgnoreCase(String value);
}
