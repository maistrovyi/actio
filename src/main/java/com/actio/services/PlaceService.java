package com.actio.services;

import com.actio.repositories.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

}
