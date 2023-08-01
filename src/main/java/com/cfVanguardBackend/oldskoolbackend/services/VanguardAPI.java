package com.cfVanguardBackend.oldskoolbackend.services;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.cfVanguardBackend.oldskoolbackend.models.Card;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestParsingException;

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
  public Card fetchCard(String id){
    String url = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/card?id=" + id;
    System.out.println(url);
    Card card = Unirest.get(url)
      .asObject(Card.class)
      .getBody();
      return card;
    // try {
    //   System.out.println(Unirest.get(url)
    //   .asObject(Card.class)
    //   // .getParsingError()
    //   // .get().getMessage());
    //   .getBody());
    //   // System.out.println(response);
    // }
    // catch (Exception e) {
    //   System.out.println(e);
    // }
    // return response;

    // ----------------------------------------------------------------------------------
    // HttpResponse<JsonNode> jsonResponse = (HttpResponse<JsonNode>) Unirest.get(url)
    //   .asJson();
    // System.out.println(jsonResponse);
    // String url = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/card?id=" + id;
    // System.out.println(url);
    // CompletableFuture<HttpResponse<JsonNode>> future = Unirest.get(url)
    //   .asJsonAsync((response) -> {
    //     System.out.println(response.getBody());
    //   });

    // --------------------------------------------------------------------------------
    //BASIC TEST
    // System.out.println(Unirest.get(url)
    //   .asString()
    //   .getBody());

  }
}