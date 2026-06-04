package com.workintech.s19d1.service;

import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import com.workintech.s19d1.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
   
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ApiException("Movie not found with id: " + id, HttpStatus.BAD_REQUEST));
    }
    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Long id, Movie movieUpdate) {
        Movie movie = findById(id);
        movie.setName(movieUpdate.getName());
        movie.setRating(movieUpdate.getRating());
        movie.setDirectorName(movieUpdate.getDirectorName());
        movie.setReleaseDate(movieUpdate.getReleaseDate());
        movie.setActors(movieUpdate.getActors()); // Bu satır eksikti
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
    }



}
