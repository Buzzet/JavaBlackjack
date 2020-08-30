package test.unitsTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

import com.buzzet.blackjack.Card;
import com.buzzet.blackjack.CardColor;
import com.buzzet.blackjack.CardDeck;
import com.buzzet.blackjack.CardFace;
import com.buzzet.blackjack.PlayDeck;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PlayDeckShould {


  @Mock
  public LinkedList<CardDeck> decks = new LinkedList<>();

  @Mock
  public CardDeck cardDeck;

  @InjectMocks
  public PlayDeck mockDeck = new PlayDeck(6);

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void containEightDecks() {
    //given
    final PlayDeck deck = new PlayDeck(8);
    //when
    final int count = deck.deckCount();
    //then
    assertThat(count).isEqualTo(8);
  }

  @Test
  public void containTenDecks() {
    //given
    final PlayDeck deck = new PlayDeck(10);
    //when
    final int count = deck.deckCount();
    //then
    assertThat(count).isEqualTo(10);
  }

  @Test
  public void returnACardOnDraw() {
    //given
    final PlayDeck deck = new PlayDeck(8);
    //when
    final Card card = deck.drawCard();
    //then
    assertThat(card).isInstanceOf(Card.class);
  }

  @Test
  public void returnADiamond10OnDraw() {
    //given
    Card givenCard = Card.builder().color(CardColor.Diamond).face(CardFace.TEN).build();
    given(this.cardDeck.draw())
        .willReturn(givenCard);
    given(this.decks.get(anyInt())).willReturn(this.cardDeck);
    given(this.decks.size()).willReturn(6);
    //when
    Card card = this.mockDeck.drawCard();
    //then
    assertThat(card.getFace()).isEqualByComparingTo(givenCard.getFace());
    assertThat(card.getColor()).isEqualByComparingTo(givenCard.getColor());
  }

  @Test
  public void returnAHeartAceOnDraw() {
    //given
    Card givenCard = Card.builder().color(CardColor.Heart).face(CardFace.ACE).build();
    given(this.cardDeck.draw())
        .willReturn(givenCard);
    given(this.decks.get(anyInt())).willReturn(this.cardDeck);
    given(this.decks.size()).willReturn(6);
    //when
    Card card = this.mockDeck.drawCard();
    //then
    assertThat(card.getFace()).isEqualByComparingTo(givenCard.getFace());
    assertThat(card.getColor()).isEqualByComparingTo(givenCard.getColor());
  }

  @Test
  public void returnFullCardCount() {
    //given
    final PlayDeck deck = new PlayDeck(8);
    //when
    final int cardCount = deck.cardCount();
    //then
    assertThat(cardCount).isEqualTo(8 * 52);

  }

  @Test
  public void returnLessCardsAfterDraw() {
    //given
    final PlayDeck deck = new PlayDeck(8);
    //when
    deck.drawCard();
    //then
    final int cardCount = deck.cardCount();
    assertThat(cardCount).isEqualTo(8 * 52 - 1);
  }
}
