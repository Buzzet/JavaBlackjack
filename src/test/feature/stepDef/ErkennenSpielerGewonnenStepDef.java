package test.feature.stepDef;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.BDDMockito.given;

import com.buzzet.blackjack.Game;
import com.buzzet.blackjack.Hand;
import com.buzzet.blackjack.PlayDeck;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import org.mockito.Mockito;

public class ErkennenSpielerGewonnenStepDef {

  PlayDeck deck = new PlayDeck(6);


  Hand dealerHand = Mockito.mock(Hand.class);

  Hand playerHand = Mockito.mock(Hand.class);

  Game game = new Game(this.dealerHand, this.playerHand);


  @Angenommen("der Dealer hat einen Kartenwert von {int}")
  public void der_Dealer_hat_einen_Kartenwert_von(Integer int1) {
    given(this.dealerHand.value()).willReturn(int1);
    assumeThat(this.dealerHand.value()).isEqualTo(int1);
  }

  @Wenn("er eine Karte mit dem Kartenwert über {int} zieht")
  public void er_eine_Karte_mit_dem_Kartenwert_über_zieht(Integer int1) {
    int value = this.dealerHand.value();
    given(this.dealerHand.value()).willReturn(value + int1 + 1);
    assumeThat(this.dealerHand.value()).isGreaterThan(21);
  }

  @Wenn("der Spieler einen Kartenwert unter {int} hat")
  public void der_Spieler_einen_Kartenwert_unter_hat(Integer int1) {
    given(this.playerHand.value()).willReturn(int1 - 1);
    assumeThat(this.playerHand.value()).isEqualTo(int1 - 1);
  }

  @Dann("hat der Spieler gewonnen")
  public void hat_der_Spieler_gewonnen() {
    assertThat(this.game.status()).contains("Player Wins");
  }

  @Wenn("er eine Karte mit dem Kartenwert {int} zieht")
  public void er_eine_Karte_mit_dem_Kartenwert_zieht(Integer int1) {
    int value = this.dealerHand.value();
    given(this.dealerHand.value()).willReturn(value + int1);
  }

  @Wenn("der Spieler einen kartenwert von {int} hat")
  public void der_Spieler_einen_kartenwert_von_hat(Integer int1) {
    given(this.playerHand.value()).willReturn(int1);
  }

}
