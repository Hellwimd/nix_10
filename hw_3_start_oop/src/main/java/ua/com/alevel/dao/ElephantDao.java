package ua.com.alevel.dao;

import ua.com.alevel.entity.Elephant;
import ua.com.alevel.repository.ElephantRepository;

public class ElephantDao {

    private final ElephantRepository elephantRepository = new ElephantRepository();

    public void create(Elephant elephant) {
        elephantRepository.create(elephant);
    }

    public void update(Elephant elephant) {
        elephantRepository.update(elephant);
    }

    public void delete(Long id) {
        elephantRepository.delete(id);
    }

    public Elephant findById(Long id) {
        return elephantRepository.findById(id);
    }

    public Elephant[] findAll() {
        return elephantRepository.findAll();
    }

    public void deleteAll() {
        elephantRepository.deleteAll();
    }
}