// package com.cfVanguardBackend.oldskoolbackend;

// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.mongodb.core.MongoTemplate;


// import io.mongock.driver.mongodb.springdata.v3.SpringDataMongoV3Driver;
// import io.mongock.runner.springboot.MongockSpringboot;
// import io.mongock.runner.springboot.base.MongockApplicationRunner;

// @Configuration
// public class AppConfig {

//   @Bean
//   public MongockApplicationRunner mongockApplicationRunner(ApplicationContext springContext, MongoTemplate mongoTemplate) {
//     return MongockSpringboot.builder()
//       .setDriver(SpringDataMongoV3Driver.withDefaultLock(mongoTemplate))
//       .addMigrationScanPackage("src/main/java/com/cfVanguardBackend/oldskoolbackend/dbMigration/LegalBTSet1.java")
//       .setSpringContext(springContext)
//       .buildApplicationRunner();
//   }
// }
