package test.unitsTests;

import static org.assertj.core.api.Assertions.assertThat;

import com.buzzet.blackjack.Card;
import com.buzzet.blackjack.CardDeck;
import org.junit.Test;

public class CardDeckShould {

  @Test
  public void contain52Cards() {
    final int length = new CardDeck().length();
    assertThat(length).isEqualTo(52);
  }

  @Test
  public void contain52CardsOnDraw() {
    //given
    final CardDeck cardDeck = new CardDeck();
    //when
    final Card card = cardDeck.draw();
    //then
    assertThat(cardDeck.length()).isEqualTo(51);
    assertThat(card).isNotNull();
  }
}
