package ua.com.alevel.service;

import ua.com.alevel.dao.ElephantDao;
import ua.com.alevel.entity.Elephant;

public class ElephantServiceImpl implements ElephantService {

    private final ElephantDao elephantDao = new ElephantDao();

    public void create(Elephant elephant) {
        elephantDao.create(elephant);
    }

    public void update(Elephant elephant) {
        elephantDao.update(elephant);
    }

    @Override
    public void delete(Long id) {
        elephantDao.delete(id);
    }

    @Override
    public Elephant findById(Long id) {
        return elephantDao.findById(id);
    }

    public Elephant[] findAll() {
        return elephantDao.findAll();
    }

    public void deleteAll() {
        elephantDao.deleteAll();
    }
}