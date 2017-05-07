package com.actio.services.b2b;

import com.actio.models.b2b.Place;
import com.actio.repositories.sql.b2b.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class PlaceService {

    @Autowired
    private PlaceRepository repository;

    public List<Place> findAll() {
        return repository.findAll();
    }

    public Place findById(Long id) {
        return repository.findOne(id);
    }

    public Place save(Place invite) {
        return repository.save(invite);
    }

    public void saveAll(List<Place> places) {
        repository.save(places);
    }

    public void update(Place invite) {
        repository.save(invite);
    }

    public void updateAll(List<Place> places) {
        repository.save(places);
    }

    public void delete(Place invite) {
        repository.delete(invite);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}