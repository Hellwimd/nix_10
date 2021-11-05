package ua.com.alevel.service;

import ua.com.alevel.entity.Elephant;

public interface ElephantService {
    void create(Elephant elephant);

    void update(Elephant elephant);

    void delete(Long id);

    Elephant findById(Long id);

    Elephant[] findAll();

    void deleteAll();
}