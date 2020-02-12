package com.buzzet.test;

import com.buzzet.blackjack.*;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class HandShould {
    @Rule public MockitoRule mockito = MockitoJUnit.rule();

    @Mock public PlayDeck mockDeck = new PlayDeck(8);

    @Mock public Hand mockHand = new Hand(this.mockDeck);

    @Test public void drawCard() {
        final Hand hand = new Hand(new PlayDeck(8));
        //when
        final Card card = hand.draw();
        //then
        assertThat(card).isInstanceOf(Card.class);
    }

    @Test public void returnHandValue() {
        //given
        final Hand hand = new Hand(new PlayDeck(8));
        //then
        assertThat(hand.value()).isGreaterThan(0).isLessThan(22);
    }

    @Test public void returnFalseIfBusted() {
        //given
        given(this.mockDeck.drawCard())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.KING).build());
        final Hand hand = new Hand(this.mockDeck);
        //when
        hand.draw();
        //then
        assertThat(hand.isBusted()).isTrue();
    }

    @Test public void returnFalseOnBustetOnThreeAsses() {
        //given
        given(this.mockDeck.drawCard())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build());
        final Hand hand = new Hand(this.mockDeck);
        //when
        hand.draw();
        //then
        assertThat(hand.isBusted()).isFalse();
    }

    @Test public void returnValueThirteenOnThreeAsses() {
        //given
        given(this.mockDeck.drawCard())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build());
        final Hand hand = new Hand(this.mockDeck);
        //when
        hand.draw();
        //then
        assertThat(hand.value()).isEqualTo(13);
    }

    @Test public void drawCardsOnNewHand() {
        //given
        final Hand hand = new Hand(new PlayDeck(8));
        //when
        final LinkedList<Card> cards = hand.getCards();
        //then
        final int handSize = cards.size();
        assertThat(handSize).isEqualTo(2);
    }

    @Test public void returnReadableToString() {
        //given
        given(this.mockDeck.drawCard())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build());
        final Hand hand = new Hand(this.mockDeck);
        //then
        assertThat(hand.toString()).isEqualTo("Card 1: ASS of Heart\nCard 2: ASS of Heart\n");
    }

    @Test public void returnOnlyOneCardOnToStringIfDealersHand() {
        //given
        given(this.mockDeck.drawCard())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build());
        final Hand hand = new Hand(this.mockDeck, true);
        //then
        assertThat(hand.toString()).isEqualTo("Card 1: ASS of Heart\nCard 2: Hidden\n");
    }

    @Test public void unhideCardsAfterDraw() {
        //given
        given(this.mockDeck.drawCard())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build())
                .willReturn(Card.builder().color(CardColor.Heart).face(CardFace.ASS).build());
        final Hand hand = new Hand(this.mockDeck, true);
        //when
        hand.draw();
        //then
        assertThat(hand.toString())
                .isEqualTo("Card 1: ASS of Heart\nCard 2: ASS of Heart\nCard 3: ASS of Heart\n");
    }
}
