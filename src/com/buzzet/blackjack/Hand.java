package com.buzzet.blackjack;

import java.util.LinkedList;

public class Hand {

  LinkedList<Card> hand = new LinkedList<>();
  PlayDeck deck;

  /**
   * Basic Hand to draw cards from
   *
   * @param deck - deck where to draw the cards from
   */
  public Hand(final PlayDeck deck) {
    this.deck = deck;
  }

  /**
   * Hand for Blackjack
   *
   * @param deck - deck where to draw the cards from
   * @param dealer - If this is a dealers hand. If so, hides the second card
   */
  public Hand(final PlayDeck deck, final Boolean dealer) {
    this.deck = deck;
    this.draw();
    if (dealer) {
      draw(true);
    } else {
      draw();
    }
  }

  /**
   * Draws a card in the Hand and reveals all other cards
   */
  public Card draw() {
    final Card card = this.deck.drawCard();
    this.hand.add(card);
    unhide();
    return card;
  }

  /**
   * reveals all cards on the hand
   */
  public void unhide() {
    for (final Card c : this.hand) {
      c.setHidden(false);
    }
  }

  /**
   * draws a hidden card if choosen. Does not reveal all cards on the hand
   *
   * @param hidden if card should be hidden
   */
  private Card draw(final boolean hidden) {
    final Card card = this.deck.drawCard();
    card.setHidden(true);
    this.hand.add(card);
    return card;
  }

  /**
   * Gets the Basic Value of the Hand
   *
   * @return - basic value
   */
  public int value() {
    long amountAsses = amountAss();
    Integer value = this.hand.stream().map(x -> x.getFace().getValue()).reduce(0, Integer::sum);
    if (amountAsses <= 0) {
      return value;
    }
    while (value > 21 && amountAsses > 0) {
      value = value - 10;
      amountAsses--;
    }
    return value;
  }

  private long amountAss() {
    return this.hand.stream().filter(x -> x.getFace().isAce()).count();
  }

  /**
   * Returns if the players bust for Blackjack
   */
  public boolean isBusted() {
    return this.value() > 21;
  }

  /**
   * Gets all cards
   *
   * @return - All cards as LinkedList
   */
  public LinkedList<Card> getCards() {
    return this.hand;
  }

  /**
   * Displays all non hidden cards
   *
   * @return String with all non hidden cards
   */
  @Override
  public String toString() {
    int count = 0;
    String s = "";
    for (final Card c : this.hand) {
      count++;
      if (!c.isHidden()) {
        s = s + "Card " + count + ": " + c.getFace() + " of " + c.getColor() + "\n";
      } else {
        s = s + "Card " + count + ": Hidden\n";
      }
    }
    return s;
  }
}
