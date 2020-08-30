package com.buzzet.blackjack;

import lombok.Getter;
import lombok.Setter;


/**
 * Bank of the Player
 */
public class Bank {

  @Getter
  @Setter
  private int value;


  @Getter
  private int bet = 0;

  /**
   * @param value Amount of Money you want to start with
   */
  public Bank(int value) {
    this.value = value;
  }

  /**
   * To enter the amount you want to Bet
   *
   * @param bet amount you want to bet
   * @throws BetTooHighExeption - when the bet is higher then the amount of money you have
   */
  public void bet(int bet) throws BetTooHighExeption {
    if (bet > this.value) {
      throw new BetTooHighExeption("You bet of " + bet + " exceeds your limit of " + this.value);
    }
    this.bet = bet;
    this.value = this.value - bet;
  }

  /**
   * Adds the winning to your account on a win
   */
  public void won() {
    this.value = this.value + this.bet * 2;
    this.bet = 0;
  }

  /**
   * returns half the bet to you account on a forfeit
   */
  public void forfeit() {
    this.value = this.value + this.bet / 2;
    this.bet = 0;
  }

  /**
   * Adds all the bet back on a draw
   */
  public void draw() {
    this.value = this.value + this.bet;
    this.bet = 0;
  }

  /**
   * losses the bettet money
   */
  public void lose() {
    this.bet = 0;
  }
}
