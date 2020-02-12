package com.buzzet.test;

import com.buzzet.blackjack.Card;
import com.buzzet.blackjack.PlayDeck;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayDeckShould {
    @Test public void containEightDecks() {
        //given
        final PlayDeck deck = new PlayDeck(8);
        //when
        final int count = deck.deckCount();
        //then
        assertThat(count).isEqualTo(8);
    }

    @Test public void returnACardOnDraw() {
        //given
        final PlayDeck deck = new PlayDeck(8);
        //when
        final Card card = deck.drawCard();
        //then
        assertThat(card).isInstanceOf(Card.class);
    }

    @Test public void returnFullCardCount() {
        //given
        final PlayDeck deck = new PlayDeck(8);
        //when
        final int cardCount = deck.cardCount();
        //then
        assertThat(cardCount).isEqualTo(8 * 52);
    }

    @Test public void returnLessCardsAfterDraw() {
        //given
        final PlayDeck deck = new PlayDeck(8);
        //when
        deck.drawCard();
        //then
        final int cardCount = deck.cardCount();
        assertThat(cardCount).isEqualTo(8 * 52 - 1);
    }
}
