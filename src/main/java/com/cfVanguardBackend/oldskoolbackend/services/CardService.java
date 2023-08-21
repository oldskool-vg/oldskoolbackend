package com.cfVanguardBackend.oldskoolbackend.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfVanguardBackend.oldskoolbackend.models.Card;
import com.cfVanguardBackend.oldskoolbackend.models.CardRepository;
import com.cfVanguardBackend.oldskoolbackend.services.Scheduler.DailyCardService;

@Service
public class CardService {

  @Autowired
  private CardRepository cardRepository;

  @Autowired
  private VanguardAPI vanguardAPI;

  @Autowired
  private DailyCardService dailyCardService;

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
    String randomCard = dailyCardService.getCardName();
    return cardRepository.findByName(randomCard);
  }

  // THE BIG RED ABORT BUTTON
  public void deleteAll() {
    cardRepository.deleteAll();
  }

}
