package test.feature.stepDef;

import com.buzzet.blackjack.Card;
import com.buzzet.blackjack.CardColor;
import com.buzzet.blackjack.CardFace;
import com.buzzet.blackjack.Hand;
import com.buzzet.blackjack.PlayDeck;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class SpielerZiehtKarteStepDef {


  PlayDeck mockDeck = Mockito.mock(PlayDeck.class);

  public Hand hand;


  @Angenommen("ich habe eine Karo {int} auf der Hand")
  public void ich_habe_eine_Karo_auf_der_Hand(final Integer int1) {
    //given
    BDDMockito.given(this.mockDeck.drawCard())
        .willReturn(
            Card.builder().color(CardColor.Diamond).face(getFaceByValue(int1)).build());
    this.hand = new Hand(this.mockDeck);
    //when
    this.hand.draw();
    //then
    Assumptions.assumeThat(this.hand.value()).isEqualTo(int1);
  }

  @Wenn("ich eine Karo {int} ziehe")
  public void ich_eine_Karo_ziehe(final Integer int1) {
    //given
    Mockito.when(this.mockDeck.drawCard())
        .thenReturn(Card.builder().color(CardColor.Diamond).face(getFaceByValue(int1)).build());
    //when
    final Card card = this.hand.draw();
    //then
    Assumptions.assumeThat(card.getFace().getValue()).isEqualTo(int1);
  }

  @Dann("liegt mein Kartenwert bei {int}")
  public void liegt_mein_Kartenwert_bei(final Integer int1) {
    Assertions.assertThat(this.hand.value()).isEqualTo(int1);
  }


  @Dann("liegt mein Kartenwert über {int}")
  public void liegt_mein_Kartenwert_über(final Integer int1) {
    Assertions.assertThat(this.hand.value()).isGreaterThan(int1);
  }

  @Dann("ich darf keine weitere Karte ziehen")
  public void ich_darf_keine_weitere_Karte_ziehen() {
    Assertions.assertThat(this.hand.isBusted()).isTrue();
  }

  private CardFace getFaceByValue(final int value) {
    switch (value) {
      case 2:
        return CardFace.TWO;
      case 3:
        return CardFace.THREE;
      case 4:
        return CardFace.FOUR;
      case 5:
        return CardFace.FIVE;
      case 6:
        return CardFace.SIX;
      case 7:
        return CardFace.SEVEN;
      case 8:
        return CardFace.EIGHT;
      case 9:
        return CardFace.NINE;
      case 10:
        return CardFace.TEN;
      default:
        return CardFace.ACE;
    }
  }
}
