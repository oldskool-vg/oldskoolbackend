// package com.cfVanguardBackend.oldskoolbackend.dbMigration;

// import io.mongock.api.annotations.ChangeUnit;
// import io.mongock.api.annotations.Execution;
// // The problem we needed to solve: given a horrendous API that contains every cfvanguard card ever in no useful format, how do we get the data we need and only the fields we need into our mongo database? Mongock provides us with a way to write migration scripts for each set/list of cards we need and will run them in order. This is the first migration script for the first set of cards we need.
// // Scenario: we have a document in our db called legalBTSet1. We want to loop through a list of card names and call the cfcvanguard API to retrieve them using unirest, which can object map them to our card model. We then want to save each card to the legalBTSet1 document in our db as well as our document allCards - with the caveat that it checks for duplicates before inserting into allCards (as some cards are part of multiple sets). We want to use this third party source to populate our db with a list of specific cards, but this only has to happen once and then we never have to touch the cfvanguard API again.

// // We first need to implement the migration to retrieve data from the API using a ChangeUnit, which is Mongock's unit of migration. Each ChangeUnit is a unit of migration that is composed of smaller pieces processed in order by the Mongock runner. Each ChangeUnit is wrapped in a transaction: if any of the changes fail, the whole unit is rolled back. But to start, there is an Execution method that is called by the Mongock runner. This method is where we will write our migration logic. Next, there is a RollbackExecution method that reverts changes made by the execution method. It is mandatory - it can be left empty but it must be there.
// @ChangeUnit(id = "legalBTSet1", order = "001", author = "RachelMiller")
// public class LegalBTSet1 {
//   // We need to inject the repository into our migration script so we can save the cards we retrieve from the API to our db.
//   // @Autowired
//   // private CardRepository cardRepository;
//   // We need to inject the unirest library into our migration script so we can make calls to the API.
//   // @Autowired
//   // private Unirest unirest;
//   // We need to inject the object mapper into our migration script so we can map the API response to our card model.
//   // @Autowired
//   // private ObjectMapper objectMapper;
//   // We need to inject the mongo template into our migration script so we can save the cards we retrieve from the API to our db.
//   // @Autowired
//   // private MongoTemplate mongoTemplate;
//   // We need to inject the mongo operations into our migration script so we can save the cards we retrieve from the API to our db.
//   // @Autowired
//   // private MongoOperations mongoOperations;
//   // We need to inject the mongo repository into our migration script so we can save the cards we retrieve from the API to our db.
//   // @Autowired
//   // private MongoRepository mongoRepository;

//   @Execution
//   public void retrieveFromAPI() {
//     // We need to loop through a list of card names and call the cfcvanguard API to retrieve them using unirest, which can object map them to our card model. We then want to save each card to the legalBTSet1 document in our db as well as our document allCards - with the caveat that it checks for duplicates before inserting into allCards (as some cards are part of multiple sets). We want to use this third party source to populate our db with a list of specific cards, but this only has to happen once and then we never have to touch the cfvanguard API again.

//   }
// }
