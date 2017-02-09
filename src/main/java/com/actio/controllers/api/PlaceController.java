package com.actio.controllers.api;

import com.actio.models.b2b.Place;
import com.actio.services.b2b.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping(value = {"", "/"}, consumes = "application/hal+json", produces = "application/hal+json")
    public List<Place> findAll() {
        return placeService.findAll();
    }

    @PostMapping(value = "/", consumes = "application/hal+json", produces = "application/hal+json")
    public Place add(@RequestBody Place place) {
        return placeService.save(place);
    }

    @GetMapping(value = "/{id}", consumes = "application/hal+json", produces = "application/hal+json")
    public Place findById(@PathVariable(value = "id") Long placeId) {
        return placeService.findById(placeId);
    }

    @PutMapping(value = "/", consumes = "application/hal+json", produces = "application/hal+json")
    public HttpStatus update(@RequestBody Place place) {
        placeService.update(place);
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/", consumes = "application/hal+json", produces = "application/hal+json")
    public HttpStatus delete(@PathVariable(value = "id") Long placeId) {
        placeService.delete(placeService.findById(placeId));
        return HttpStatus.OK;
    }

    @PatchMapping(value = "/", consumes = "application/hal+json", produces = "application/hal+json")
    public HttpStatus updateAll(@RequestBody Place place) {
        placeService.update(place);
        return HttpStatus.OK;
    }

}
