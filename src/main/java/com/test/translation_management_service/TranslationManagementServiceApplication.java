package com.test.translation_management_service;

import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Key;
import java.util.Base64;

@SpringBootApplication
public class TranslationManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslationManagementServiceApplication.class, args);
		Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
		String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
		System.out.println("Your Secure JWT Secret Key: " + encodedKey);
	}

}
