package com.cfVanguardBackend.oldskoolbackend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)// <- ignore all the properties not added in our design that we call from external API
public class Card2 {
  private String name;
  private String grade;
  private String cardType;
  private Long power;
  private Long shield;
  private String skill;
  private String flavor;
  private String effect;
  private String clan;
  private String race;
  private String imageurlen;
  private String legality;
}