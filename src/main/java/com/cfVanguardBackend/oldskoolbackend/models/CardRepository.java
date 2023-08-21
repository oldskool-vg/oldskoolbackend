package com.cfVanguardBackend.oldskoolbackend.models;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends MongoRepository<Card, ObjectId> {
  @Query("{name: ?0}")
  Optional<Card> findByName(String name);
}