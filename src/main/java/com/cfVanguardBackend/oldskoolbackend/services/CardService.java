package com.cfVanguardBackend.oldskoolbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cfVanguardBackend.oldskoolbackend.models.Card;
import com.cfVanguardBackend.oldskoolbackend.models.CardRepository;

// Inside this class will be the database access logic for the Card model, which is tied to our Mongo repository now.
@Service
public class CardService {
  // Inside this service class we need a reference to the repository
  @Autowired
  private CardRepository cardRepository; //<- this will have to be initialized
  // We can initialize a repository with a constructor or we can use the @Autowired annotation to let the framework know to instantiate this CardRepository class for us.
  public List<Card> allCards() { // return a list of cards using allCards method. See controller where we call this method 'getallcards' to match with the get mapping phrase.
    return cardRepository.findAll();
  }

  public Card oneCard(String name) {
    return cardRepository.findByName(name).orElseThrow(() -> new RuntimeException(String.format("Cannot find card by name %s", name)));
  }
}
