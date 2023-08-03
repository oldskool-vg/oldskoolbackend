package com.cfVanguardBackend.oldskoolbackend.services;

import org.springframework.stereotype.Service;
import com.cfVanguardBackend.oldskoolbackend.models.Card;
import kong.unirest.Unirest;

@Service
public class VanguardAPI {

  public Card fetchCard(String id){
    String url = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/card?id=" + id;
    System.out.println(url);
    Card card = Unirest.get(url)
      .asObject(Card.class)
      .getBody();
      return card;

    // ----------------------------------------------------------------------------------
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