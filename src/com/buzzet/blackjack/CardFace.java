package com.buzzet.blackjack;

import lombok.Getter;

@Getter
public enum CardFace {
  TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(
      10), QUEEN(10), KING(10), ACE(11);

  int value;

  CardFace(final int i) {
    this.value = i;
  }

  /**
   * @return if the card is an Ace
   */
  public boolean isAce() {
    return this.value == 11 ? true : false;
  }


}
