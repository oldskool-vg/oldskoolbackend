// package com.cfVanguardBackend.oldskoolbackend.dbMigration;

// import java.io.FileReader;

// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.cfVanguardBackend.oldskoolbackend.services.CardService;

// import io.mongock.api.annotations.ChangeUnit;
// import io.mongock.api.annotations.Execution;
// import io.mongock.api.annotations.RollbackExecution;

// @ChangeUnit(id = "allCards", order = "001", author = "RachelMiller")
// public class Migration {
//   @Autowired
//   private CardService cardService;

//   @Execution
//   public void changeSet() {
//     JSONParser parser = new JSONParser();
//     try {
//       Object obj = parser.parse(new FileReader("src/main/java/com/cfVanguardBackend/oldskoolbackend/jsonData/allCards.json"));
//       JSONObject object = (JSONObject) obj;
//       JSONArray cardList = (JSONArray) object.get("cards");
//       for (int i = 0; i < cardList.size(); i++) {
//         JSONObject card = (JSONObject) cardList.get(i);
//         System.out.println(card.get("id"));
//         cardService.addCard(String.valueOf(card.get("id")));
//       }
//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//   }

//    @RollbackExecution
//    public void rollback() {
//       cardService.deleteAll();
//    }
// }