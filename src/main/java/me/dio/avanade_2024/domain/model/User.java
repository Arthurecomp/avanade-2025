package me.dio.avanade_2024.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//@JsonInclude(JsonInclude.Include.ALWAYS)
@Entity(name = "tb_user")
@Getter
@Setter
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Credentials credentials;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Movie> watchedMovies;

    public User(String name, Credentials credentials) {
        this.name = name;
        this.credentials = credentials;
    }

    public User() {

    }


//    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
//    private List<Review> reviews;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Favorite> favorites;


}
