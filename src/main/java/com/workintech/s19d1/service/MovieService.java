package com.workintech.s19d1.service;

import java.util.List;

import com.workintech.s19d1.entity.Movie;
public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
    Movie save(Movie movie);
    void delete(Long id);
    Movie update(Long id, Movie movie);
}