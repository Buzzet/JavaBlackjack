package com.buzzet.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.buzzet.blackjack.Card;
import com.buzzet.blackjack.CardColor;
import com.buzzet.blackjack.CardFace;
import com.buzzet.blackjack.Hand;
import com.buzzet.blackjack.PlayDeck;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class HandShould {

  @Rule
  public MockitoRule mockito = MockitoJUnit.rule();

  @Mock
  public PlayDeck mockDeck = new PlayDeck(8);

  @Mock
  public Hand mockHand = new Hand(this.mockDeck);

  @Test
  public void drawCard() {
    final Hand hand = new Hand(new PlayDeck(8));
    //when
    final Card card = hand.draw();
    //then
    assertThat(card).isInstanceOf(Card.class);
  }

  @Test
  public void returnHandValue() {
    //given
    final Hand hand = new Hand(new PlayDeck(8));
    //then
    hand.draw();
    hand.draw();
    assertThat(hand.value()).isGreaterThan(0).isLessThan(22);
  }

  @Test
  public void returnFalseIfBusted() {
    //given
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.KING).build());
    final Hand hand = new Hand(this.mockDeck);
    //when
    hand.draw();
    hand.draw();
    hand.draw();
    //then
    assertThat(hand.isBusted()).isTrue();
  }

  @Test
  public void returnFalseOnBustetOnThreeAsses() {
    //given
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build());
    final Hand hand = new Hand(this.mockDeck);
    //when
    hand.draw();
    //then
    assertThat(hand.isBusted()).isFalse();
  }

  @Test
  public void returnValueThirteenOnThreeAsses() {
    //given
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build());
    final Hand hand = new Hand(this.mockDeck);
    //when
    hand.draw();
    hand.draw();
    hand.draw();
    //then
    assertThat(hand.value()).isEqualTo(13);
  }

  /*@Test
  public void drawCardsOnNewHand() {
    //given
    final Hand hand = new Hand(new PlayDeck(8));
    //when
    hand.draw
    final LinkedList<Card> cards = hand.getCards();
    //then
    final int handSize = cards.size();
    assertThat(handSize).isEqualTo(2);
  }*/

  @Test
  public void returnReadableToString() {
    //given
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build());
    final Hand hand = new Hand(this.mockDeck);
    //when
    hand.draw();
    hand.draw();
    //then
    assertThat(hand.toString()).isEqualTo("Card 1: ACE of Heart\nCard 2: ACE of Heart\n");
  }

  @Test
  public void returnOnlyOneCardOnToStringIfDealersHand() {
    //given
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build());
    final Hand hand = new Hand(this.mockDeck, true);
    //then
    assertThat(hand.toString()).isEqualTo("Card 1: ACE of Heart\nCard 2: Hidden\n");
  }

  @Test
  public void unhideCardsAfterDraw() {
    //given
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build())
        .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ACE).build());
    final Hand hand = new Hand(this.mockDeck, true);
    //when
    hand.draw();
    //then
    assertThat(hand.toString())
        .isEqualTo("Card 1: ACE of Heart\nCard 2: ACE of Heart\nCard 3: ACE of Heart\n");
  }
}
