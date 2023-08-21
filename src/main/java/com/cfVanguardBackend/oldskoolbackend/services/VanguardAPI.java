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
  }

}