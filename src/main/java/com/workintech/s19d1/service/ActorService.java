package com.workintech.s19d1.service;

import java.util.List;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(Long id);
    Actor save(ActorRequest actorRequest);
    void delete(Long id);
    Actor update(Long id, ActorRequest actorRequest);
}
