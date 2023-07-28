package com.cfVanguardBackend.oldskoolbackend.services;

import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.cfVanguardBackend.oldskoolbackend.models.Card;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;

@Service
public class VanguardAPI {
  // HttpResponse<JsonNode> jsonResponse = Unirest.get("https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/cards")
  //   .routeParam("name", )
  //   .asObject(Card.class)
  //   .getBody();

  // private final ObjectMapper objectMapper = new ObjectMapper();

  // public Card getCard(String name) {
  //   // return Unirest.get("https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/cards")
  //   //   .routeParam("name", name)
  //   //   .asObject(Card.class)
  //   //   .getBody();
  //   String url = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/cards?name=" + name;
  //   // kong.unirest.HttpResponse<String> response = Unirest.get(url).asString();
  //   // String jsonResponse= response.getBody();
  //   // Card card = objectMapper.readValue(jsonResponse, Card.class);
  //   // return card;
  //   return Unirest.get(url)
  //     .asObject(Card.class)
  //     .getBody();
  // }
  public Card getCard(String id){
    String url = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/card?id=" + id;
    System.out.println(url);
    Card response = Unirest.get(url)
      .asObject(Card.class)
      .getBody();
      return response;
  }
}