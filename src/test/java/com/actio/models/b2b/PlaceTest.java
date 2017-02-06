package com.actio.models.b2b;

import com.actio.repositories.b2b.PlaceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@WebAppConfiguration
public class PlaceTest {

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    @Rollback(value = false)
    public void test_onSuccessfullySavedPlace() {
        placeRepository.save(Place.of()
                .name("Home")
                .address("Akademika Yangelya, 20")
                .longtitude(50.447903)
                .latitude(30.451589)
                .create());

        placeRepository.save(Place.of()
                .name("Work")
                .address("Ivan Poddubny, 20/27")
                .longtitude(50.447903)
                .latitude(30.451589)
                .create());

        assertEquals(placeRepository.findAll().size(), 2);
    }

}