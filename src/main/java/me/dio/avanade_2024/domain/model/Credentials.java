package me.dio.avanade_2024.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_credentials")
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
}
