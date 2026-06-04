package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.util.HollywoodValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workintech.s19d1.util.HollywoodValidation.validateActor;

@Slf4j
@RestController
@RequestMapping("/workintech/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Long id) {
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@RequestBody ActorRequest request) {

        HollywoodValidation.validateActor(request);

        return actorService.save(request);
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody ActorRequest request) {

        log.info("Actor is updating with ID: {}", id);

        validateActor(request);

        return actorService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        log.info("Actor is deleting with ID: {}", id);

        actorService.delete(id);
    }
}