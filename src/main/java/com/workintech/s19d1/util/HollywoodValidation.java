package com.workintech.s19d1.util;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class HollywoodValidation {

    public static void validateMovie(Movie movie) {
        if (movie == null) {
            throw new ApiException("Movie cannot be null", HttpStatus.BAD_REQUEST);
        }
        if (movie.getName() == null || movie.getName().isBlank()) {
            throw new ApiException("Movie name is required", HttpStatus.BAD_REQUEST);
        }
        if (movie.getRating() < 0 || movie.getRating() > 10) {
            throw new ApiException("Rating must be 0-10", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateActor(ActorRequest actorRequest) {
        // 1. DTO'nun kendisini kontrol et
        if (actorRequest == null || actorRequest.getActor() == null) {
            throw new ApiException("Actor cannot be null", HttpStatus.BAD_REQUEST);
        }

        // 2. DTO içindeki Actor nesnesine eriş
        Actor actor = actorRequest.getActor();

        // 3. Actor alanlarını kontrol et
        if (actor.getFirstName() == null || actor.getFirstName().isBlank()) {
            throw new ApiException("First name required", HttpStatus.BAD_REQUEST);
        }
        if (actor.getLastName() == null || actor.getLastName().isBlank()) {
            throw new ApiException("Last name required", HttpStatus.BAD_REQUEST);
        }
    }
}