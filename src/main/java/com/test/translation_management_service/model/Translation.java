package com.test.translation_management_service.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "translations", indexes = {
        @Index(name = "idx_locale", columnList = "locale"),
        @Index(name = "idx_key", columnList = "key")
})

@NoArgsConstructor @AllArgsConstructor
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "translation_key", nullable = false) // ✅ Renamed column to avoid conflicts
    private String key;

    @Column(nullable = false)
    private String locale; // en, fr, es

    @Column(nullable = false, length = 500, columnDefinition = "NVARCHAR(500)")
    private String value;

    private String context; // mobile, desktop, web

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getLocale() {
        return locale;
    }

    public String getValue() {
        return value;
    }

    public String getContext() {
        return context;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
