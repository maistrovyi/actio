package com.actio.repositories.mongo.b2b;

import com.actio.models.b2b.MongoPlace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPlaceRepository extends MongoRepository<MongoPlace, String> {

}
