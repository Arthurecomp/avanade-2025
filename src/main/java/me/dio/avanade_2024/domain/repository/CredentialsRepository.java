package me.dio.avanade_2024.domain.repository;

import me.dio.avanade_2024.domain.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
    UserDetails findByEmail(String email);
}
