package com.cfVanguardBackend.oldskoolbackend.services;

import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cfVanguardBackend.oldskoolbackend.models.Card;
import com.cfVanguardBackend.oldskoolbackend.models.CardRepository;

@Service
public class CardService {

  @Autowired
  private CardRepository cardRepository;

  @Autowired
  private VanguardAPI vanguardAPI;

  public List<Card> allCards() {
    return cardRepository.findAll();
  }

  public Optional<Card> oneCard(String name) {
    // return cardRepository.findByName(name).orElseThrow(() -> new CardNotFoundException(name));
    return cardRepository.findByName(name);
  }

  public void addCard(String id) {
    CompletableFuture<Card> future = CompletableFuture.supplyAsync(() -> vanguardAPI.fetchCard(id));
    future.thenAccept(card -> cardRepository.save(card));
  }

  public Optional<Card> cardOfTheDay() {
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(new FileReader("src/main/java/com/cfVanguardBackend/oldskoolbackend/jsonData/AllCards.json"));
      JSONObject object = (JSONObject) obj;
      JSONArray cardList = (JSONArray) object.get("cards");
      int i = ThreadLocalRandom.current().nextInt(0, cardList.size() + 1);
      JSONObject randomCard = (JSONObject) cardList.get(i);
      System.out.println(randomCard.get("name"));
      return cardRepository.findByName((String) randomCard.get("name"));

    } catch (Exception e) {
      e.printStackTrace();
    }
    return cardRepository.findByName("Wingal");
  }

  public void deleteAll() {
    cardRepository.deleteAll();
  }

}
