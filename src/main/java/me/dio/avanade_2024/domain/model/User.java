package me.dio.avanade_2024.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_watched_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> watchedMovies = new ArrayList<>();

    public User() {
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Favorite> favorites;


}
