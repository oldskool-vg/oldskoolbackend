package com.cfVanguardBackend.oldskoolbackend.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
  @Id // <- this is the primary key, auto incrementing
  private ObjectId _id;
  @Indexed(unique = true) // <- index the name field so it's a faster lookup and unique so we don't have duplicates
  private String name;
  private String grade;
  private String cardtype;
  private Short power;
  private Short shield;
  private String skill;
  private String flavor;
  private String effect;
  private String clan;
  private String race;
  @Field(name = "image") // <- this is the name of the field in the database, easier to say image than imageurlen
  private String imageurlen;
  private List<String> sets;
  private String legality;
}
