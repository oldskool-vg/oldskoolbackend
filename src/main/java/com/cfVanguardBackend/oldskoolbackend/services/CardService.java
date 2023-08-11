package com.cfVanguardBackend.oldskoolbackend.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
  @Autowired
  private VanguardAPI vanguardAPI;

  public List<Card> allCards() { // return a list of cards using allCards method. See controller where we call this method 'getallcards' to match with the get mapping phrase.
    return cardRepository.findAll();
  }

  public Optional<Card> oneCard(String name) {
    // return cardRepository.findByName(name).orElseThrow(() -> new CardNotFoundException(name));
    return cardRepository.findByName(name);
  }

  // have a method on our Card service that, when we want to add a new card, will use the api class to get the card from the external api and then save it to our database asynchronously.
  public void addCard(String id) {

    CompletableFuture<Card> future = CompletableFuture.supplyAsync(() -> vanguardAPI.fetchCard(id));
    future.thenAccept(card -> cardRepository.save(card));

  }

}
