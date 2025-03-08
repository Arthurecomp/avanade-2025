package me.dio.avanade_2024.service.impl;

import me.dio.avanade_2024.domain.model.Credentials;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.domain.repository.CredentialsRepository;
import me.dio.avanade_2024.domain.repository.UserRepository;
import me.dio.avanade_2024.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class  UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, CredentialsRepository credentialsRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.credentialsRepository = credentialsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User create(User userToCreate) {

        String encryptedPassword = passwordEncoder.encode(userToCreate.getCredentials().getPassword());

        Credentials newCredentials = new Credentials(userToCreate.getCredentials().getEmail(), encryptedPassword, userToCreate.getCredentials().getRole());  // "USER_ROLE" ou outro papel conforme sua necessidade

        credentialsRepository.save(newCredentials);

        userToCreate.setCredentials(newCredentials);

        return userRepository.save(userToCreate);
    }

}
