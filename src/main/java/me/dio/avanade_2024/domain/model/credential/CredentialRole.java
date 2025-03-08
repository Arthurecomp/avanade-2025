package me.dio.avanade_2024.domain.model.credential;

public enum CredentialRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    CredentialRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
