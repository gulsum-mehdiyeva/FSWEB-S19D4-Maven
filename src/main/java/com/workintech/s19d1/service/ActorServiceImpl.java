package com.workintech.s19d1.service;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ApiException("Actor not found with id: " + id, HttpStatus.BAD_REQUEST));
    }

    @Override
    public Actor save(ActorRequest req) {
        Actor actor = req.getActor();
        if (req.getMovies() != null) {
            for (Movie movie : req.getMovies()) {
                actor.addMovie(movie);
            }
        }
        return actorRepository.save(actor);
    }

    @Override
    public Actor update(Long id, ActorRequest req) {
        Actor actorToUpdate = findById(id);
        Actor newData = req.getActor();

        actorToUpdate.setFirstName(newData.getFirstName());
        actorToUpdate.setLastName(newData.getLastName());
        actorToUpdate.setGender(newData.getGender());
        actorToUpdate.setBirthDate(newData.getBirthDate());

        return actorRepository.save(actorToUpdate);
    }

    @Override
    public void delete(Long id) {
        actorRepository.deleteById(id);
    }
}