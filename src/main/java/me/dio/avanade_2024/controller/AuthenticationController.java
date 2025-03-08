package me.dio.avanade_2024.controller;

import jakarta.validation.Valid;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.domain.model.credential.AuthenticationDTO;
import me.dio.avanade_2024.domain.model.Credentials;
import me.dio.avanade_2024.domain.model.credential.RegisterDTO;
import me.dio.avanade_2024.domain.repository.CredentialsRepository;
import me.dio.avanade_2024.domain.repository.UserRepository;
import me.dio.avanade_2024.security.TokenService;
import me.dio.avanade_2024.service.UserService;
import me.dio.avanade_2024.service.impl.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {

        try{
            var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(userNamePassword);
            var token = tokenService.generateToken((Credentials) auth.getPrincipal());
            return ResponseEntity.ok(token);

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.credentialsRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User user = authorizationService.register(data);

//        Credentials newCredentials = new Credentials(data.email(), encryptedPassword, data.role());

//        this.credentialsRepository.save(newCredentials);

        return ResponseEntity.ok(user);
    }
}
