package com.cfVanguardBackend.oldskoolbackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cfVanguardBackend.oldskoolbackend.exceptions.CardNotFoundException;
import com.cfVanguardBackend.oldskoolbackend.models.Card;
import com.cfVanguardBackend.oldskoolbackend.services.CardService;

@RestController
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
  // @GetMapping("/cards/{name}")
  // public ResponseEntity<Card> getCardByName(@PathVariable String name) {
  //   return ResponseEntity.of(Optional.ofNullable(cardService.oneCard(name)));
  // }
  @GetMapping("/cards/{name}")
  public ResponseEntity<Card> getCardByName(@PathVariable String name) {
    return ResponseEntity.of((cardService.oneCard(name)));
  }
}
