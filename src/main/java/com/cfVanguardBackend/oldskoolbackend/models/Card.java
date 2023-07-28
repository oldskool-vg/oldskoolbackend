package com.cfVanguardBackend.oldskoolbackend.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "allCards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties // <- ignore all the properties not added in our design that we call from external API
public class Card {
  @Id
  private ObjectId _id;
  private String name;
  private Byte grade;
  private String cardType;
  private Short power;
  private Short shield;
  private String skill;
  private String flavor;
  private String effect;
  private String clan;
  private String race;
  private String imageurlen;
  private List<String> sets;
  private String legality;
}
