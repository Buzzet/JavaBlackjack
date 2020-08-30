package com.buzzet.blackjack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import lombok.Getter;

@Getter
public class CardDeck {

  List<Card> deck;

  public CardDeck() {
    final Card[] init = {Card.builder().color(CardColor.Heart).face(CardFace.TWO).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.THREE).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.FOUR).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.FIVE).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.SIX).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.SEVEN).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.EIGHT).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.NINE).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.TEN).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.JACK).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.QUEEN).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.KING).build(),
        Card.builder().color(CardColor.Heart).face(CardFace.ACE).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.TWO).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.THREE).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.FOUR).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.FIVE).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.SIX).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.SEVEN).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.EIGHT).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.NINE).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.TEN).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.JACK).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.QUEEN).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.KING).build(),
        Card.builder().color(CardColor.Spade).face(CardFace.ACE).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.TWO).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.THREE).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.FOUR).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.FIVE).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.SIX).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.SEVEN).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.EIGHT).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.NINE).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.TEN).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.JACK).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.QUEEN).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.KING).build(),
        Card.builder().color(CardColor.Diamond).face(CardFace.ACE).build(),
        Card.builder().color(CardColor.Club).face(CardFace.TWO).build(),
        Card.builder().color(CardColor.Club).face(CardFace.THREE).build(),
        Card.builder().color(CardColor.Club).face(CardFace.FOUR).build(),
        Card.builder().color(CardColor.Club).face(CardFace.FIVE).build(),
        Card.builder().color(CardColor.Club).face(CardFace.SIX).build(),
        Card.builder().color(CardColor.Club).face(CardFace.SEVEN).build(),
        Card.builder().color(CardColor.Club).face(CardFace.EIGHT).build(),
        Card.builder().color(CardColor.Club).face(CardFace.NINE).build(),
        Card.builder().color(CardColor.Club).face(CardFace.TEN).build(),
        Card.builder().color(CardColor.Club).face(CardFace.JACK).build(),
        Card.builder().color(CardColor.Club).face(CardFace.QUEEN).build(),
        Card.builder().color(CardColor.Club).face(CardFace.KING).build(),
        Card.builder().color(CardColor.Club).face(CardFace.ACE).build()};
    this.deck = new LinkedList<Card>(Arrays.asList(init));
  }

  /**
   * @return amount of cards left in the deck
   */
  public int length() {
    return this.deck.size();
  }

  /**
   * @return Card that has been drawn
   */
  public Card draw() {
    final int randomInt = new Random().nextInt(51);
    return this.deck.remove(randomInt);
  }
}
