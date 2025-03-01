//package com.test.translation_management_service.service;
//
//package com.test.translation_management_service.security;
//
//import com.test.translation_management_service.model.User;
//import com.test.translation_management_service.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public AuthUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUsername(username);
//        return user.map(AuthUserDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//    }
//}
