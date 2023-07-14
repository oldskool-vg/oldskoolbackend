package com.cfVanguardBackend.oldskoolbackend.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Repositories in java are classes that encapsulate the logic required to access data sources. They help decouple: they act as an interface between the controller and the data access logic. This class provides the mechanisms for CRUD operations on the Card model.
// the CardRepo interface extends the repo we have in mongo, and we have to parameterize it with <...> to tell it what type of object we're working with. In this case, we're working with the Card model, so we pass in Card. The second parameter is the type of the ID field, which is an ObjectId in this case.
@Repository
public interface CardRepository extends MongoRepository<Card, ObjectId> {
}

// The mongo repository class extension has methods already defined that we can use:

// findAll() - returns all documents in the collection
// findById() - returns a single document by its ID
// save() - saves a document to the collection
// delete() - deletes a document from the collection
// deleteAll() - deletes all documents from the collection
// count() - returns the number of documents in the collection
// existsById() - returns whether a document with the given ID exists in the collection
// insert() - inserts a document into the collection
// insertAll() - inserts a list of documents into the collection etc.