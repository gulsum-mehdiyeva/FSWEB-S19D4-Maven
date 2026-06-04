package com.workintech.s19d1.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="actor")

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
  
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
   @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Column(name="birth_date")
    private LocalDate birthDate;
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();
    public void addMovie(Movie movie) {
        if (movies == null) movies = new ArrayList<>();
        if (movie.getActors() == null) movie.setActors(new ArrayList<>());

        this.movies.add(movie);
        movie.getActors().add(this);
    }
}
