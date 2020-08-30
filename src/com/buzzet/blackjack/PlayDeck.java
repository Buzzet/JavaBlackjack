package com.buzzet.blackjack;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Stream;

public class PlayDeck {

  private LinkedList<CardDeck> decks = new LinkedList<>();

  /**
   * New Playdeck with the amount of decks you want in it
   *
   * @param amount - amount of decks you want to play with
   */
  public PlayDeck(final int amount) {
    for (int i = 0; i < amount; i++) {
      this.decks.add(new CardDeck());
    }
  }

  /**
   * Gets a deck Count
   *
   * @return amount of decks in the PlayDeck
   */
  public int deckCount() {
    return this.decks.size();
  }

  /**
   * Draws a Card
   *
   * @return Card that was drawn
   */
  public Card drawCard() {
    int randomInt = new Random().nextInt(this.decks.size());
    return this.decks.get(randomInt).draw();
  }

  /**
   * Counts all Cards in the PlayDeck
   *
   * @return count of all Cards in the PlayDeck
   */
  public int cardCount() {
    final Stream<CardDeck> stream = this.decks.stream();
    return stream.map(x -> x.length()).reduce(0, Integer::sum);
  }
}
