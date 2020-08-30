package test.feature.stepDef;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.buzzet.blackjack.Game;
import com.buzzet.blackjack.Hand;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import org.mockito.Mockito;

public class ErkennenSpielerVerliert {

  Hand playerHand = Mockito.mock(Hand.class);
  Hand dealerHand = Mockito.mock(Hand.class);
  Game game = new Game(this.dealerHand, this.playerHand);

  @Angenommen("ein Spieler hat den Kartenwert {int}")
  public void ein_Spieler_hat_den_Kartenwert(Integer int1) {
    given(this.playerHand.value()).willReturn(int1);
    given(this.dealerHand.value()).willReturn(17);
  }

  @Wenn("er eine Karte mit einem Wert über {int} zieht")
  public void er_eine_Karte_mit_einem_Wert_über_zieht(Integer int1) {
    int value = this.playerHand.value();
    given(this.playerHand.value()).willReturn(value + int1 + 1);
  }

  @Dann("hat der Spieler verloren")
  public void hat_der_Spieler_verloren() {
    assertThat(this.game.status()).contains("Dealer Wins");
  }

  @Wenn("der Dealer einen Kartenwert von {int} hat")
  public void der_Dealer_einen_Kartenwert_von_hat(Integer int1) {
    given(this.dealerHand.value()).willReturn(int1);
  }

  @Angenommen("der Spieler hat den Kartenwert {int}")
  public void der_Spieler_hat_den_Kartenwert(Integer int1) {
    this.game = new Game(this.dealerHand, this.playerHand);
    given(this.playerHand.value()).willReturn(int1);
  }

  @Wenn("der Dealer den Kartenwert {int} hat")
  public void der_Dealer_den_Kartenwert_hat(Integer int1) {
    given(this.dealerHand.value()).willReturn(int1);
  }

  @Dann("gibt es ein Unendschieden")
  public void gibt_es_ein_Unendschieden() {
    assertThat(this.game.status()).contains("Draw");
  }

  @Angenommen("der Dealer teilt die Karten aus")
  public void der_Dealer_teilt_die_Karten_aus() {

  }

  @Dann("haben alle Spieler verloren")
  public void haben_alle_Spieler_verloren() {
    assertThat(this.game.status()).contains("Dealer Wins");
  }

}
