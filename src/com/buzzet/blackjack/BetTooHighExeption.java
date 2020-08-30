package com.buzzet.blackjack;

public class BetTooHighExeption extends RuntimeException {

  public BetTooHighExeption(String message) {
    super(message);
  }

}
