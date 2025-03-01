package com.test.translation_management_service.model;


import com.test.translation_management_service.model.Users;
import com.test.translation_management_service.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                // ✅ Use constructor without ID
                Users admin = new Users("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("✅ Admin user created: username=admin, password=admin123");
            }
        };
    }
}
