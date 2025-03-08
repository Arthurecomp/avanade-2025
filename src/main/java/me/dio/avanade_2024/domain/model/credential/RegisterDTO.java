package me.dio.avanade_2024.domain.model.credential;

public record RegisterDTO(String email, String password, CredentialRole role, String name) {
}
