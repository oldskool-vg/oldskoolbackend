package com.cfVanguardBackend.oldskoolbackend.dbMigration;

import com.cfVanguardBackend.oldskoolbackend.services.CardService;

import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Method {

  private CardService cardService;

  public void seedDB() {
    JSONObject object = new JSONObject("../jsonData/LegalPromos.json");
    JSONArray array = object.getJSONArray("cards");

    for(int i = 0; i < array.length(); i++) {
      cardService.addCard(array.getJSONObject(i).getString("id"));
    }

  }
}
