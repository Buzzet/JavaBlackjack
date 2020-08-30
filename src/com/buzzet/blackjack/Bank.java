package com.buzzet.blackjack;

import lombok.Getter;
import lombok.Setter;


public class Bank {

  @Getter
  @Setter
  private int value;


  @Getter
  private int bet = 0;

  public Bank(int value) {
    this.value = value;
  }

  public void bet(int bet) throws BetTooHighExeption {
    if (bet > this.value) {
      throw new BetTooHighExeption("You bet of " + bet + " exceeds your limit of " + this.value);
    }
    this.bet = bet;
    this.value = this.value - bet;
  }

  public void won() {
    this.value = this.value + this.bet * 2;
    this.bet = 0;
  }

  public void forfeit() {
    this.value = this.value + this.bet / 2;
    this.bet = 0;
  }

  public void draw() {
    this.value = this.value + this.bet;
    this.bet = 0;
  }

  public void lose() {
    this.bet = 0;
  }
}
