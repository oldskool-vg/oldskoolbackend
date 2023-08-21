package com.cfVanguardBackend.oldskoolbackend.services;

import java.io.FileReader;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Configuration
@EnableScheduling
public class Scheduler {
  String cardName = "Wingal";
  @Scheduled(cron = "0 0 9 * * *", zone = "America/Los_Angeles")
  public void executeTask() {
    System.out.println("Task executed");
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(new FileReader("src/main/java/com/cfVanguardBackend/oldskoolbackend/jsonData/AllCards.json"));
      JSONObject object = (JSONObject) obj;
      JSONArray cardList = (JSONArray) object.get("cards");
      int i = ThreadLocalRandom.current().nextInt(0, cardList.size() + 1);
      JSONObject randomCard = (JSONObject) cardList.get(i);
      cardName = (String) randomCard.get("name");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Service
  public class DailyCardService {
    public String getCardName() {
      return cardName;
    }
  }
}
