package me.dio.avanade_2024.service.impl;

import me.dio.avanade_2024.domain.model.Credentials;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.domain.model.credential.RegisterDTO;
import me.dio.avanade_2024.domain.repository.CredentialsRepository;
import me.dio.avanade_2024.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    final CredentialsRepository credentialsRepository;
    public AuthorizationService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            return credentialsRepository.findByEmail(email);
    }

    public User register(RegisterDTO registerDTO){
        Credentials credential = new Credentials();
        credential.setEmail(registerDTO.email());
        credential.setPassword(passwordEncoder.encode(registerDTO.password()));
        credential.setRole(registerDTO.role());
        User user = new User();
        user.setName(registerDTO.name());
        user.setCredentials(credential);
        return userRepository.save(user);
    }



}
