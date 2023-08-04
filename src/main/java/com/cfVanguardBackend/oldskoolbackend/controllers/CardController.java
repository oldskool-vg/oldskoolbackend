package com.cfVanguardBackend.oldskoolbackend.controllers;

import java.io.FileReader;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfVanguardBackend.oldskoolbackend.models.Card;
import com.cfVanguardBackend.oldskoolbackend.models.CardRequest;
import com.cfVanguardBackend.oldskoolbackend.services.CardService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {
  // we need a reference to our service class and just like we did in service, we can autowire this in
  @Autowired
  private CardService cardService;

  // get a list of all the cards within the database
  @GetMapping("/cards")
  public ResponseEntity<List<Card>> getAllCards() {
    return ResponseEntity.of(Optional.ofNullable(cardService.allCards()));
  }

  // get a single card by its name
  @GetMapping("/cards/{name}")
  public ResponseEntity<Card> getCardByName(@PathVariable String name) {
    // This commented out return was not producing a 404 if not found: was returning null with 200
    // return ResponseEntity.of(Optional.ofNullable(cardService.oneCard(name)));
    return ResponseEntity.of((cardService.oneCard(name)));
  }

  @PostMapping("/admin/manualinsert/cards")
  public void postCardByName(@RequestBody CardRequest cardRequest) {
    cardService.addCard(cardRequest.getId());
  }

  @PostMapping("/admin/testrun")
  public void testRun() {
    JSONParser parser = new JSONParser();

    // try {
    //   Object obj = parser.parse(new FileReader("src/main/java/com/cfVanguardBackend/oldskoolbackend/jsonData/LegalPromos.json"));
    //   JSONObject object = (JSONObject) obj;
    //   JSONArray cardList = (JSONArray) object.get("cards");
    //   for (int i = 0; i < cardList.size(); i++) {
    //     JSONObject card = (JSONObject) cardList.get(i);
    //     System.out.println(card.get("id"));
    //     cardService.addCard(String.valueOf(card.get("id")));
    //   }
    // } catch (Exception e) {
    //   e.printStackTrace();
    // }
    try {
      Object obj = parser.parse(new FileReader("src/main/java/com/cfVanguardBackend/oldskoolbackend/jsonData/allCards.json"));
      JSONObject object = (JSONObject) obj;
      JSONArray cardList = (JSONArray) object.get("cards");
      for (int i = 0; i < cardList.size(); i++) {
        JSONObject card = (JSONObject) cardList.get(i);
        System.out.println(card.get("id"));
        cardService.addCard(String.valueOf(card.get("id")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
