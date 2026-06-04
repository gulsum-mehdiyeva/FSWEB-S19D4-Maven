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
@Table(name = "movies")

public class Movie {
   @Column(name="id")
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   @Column(name="name")
	private String name;
   @Column(name="director_name")
	private String directorName;
   @Column(name="rating")
	private int rating;
   @Column(name="release_date")
	private LocalDate releaseDate;
@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
@JoinTable(
    name = "movie_actor",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id")
)
private List<Actor> actors = new ArrayList<>();
    public void addActor(Actor actor) {
        if (actors == null) actors = new ArrayList<>();
        if (actor.getMovies() == null) actor.setMovies(new ArrayList<>());

        this.actors.add(actor);
        actor.getMovies().add(this);
    }
}

