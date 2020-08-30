package test.feature.stepDef;

import com.buzzet.blackjack.Card;
import com.buzzet.blackjack.CardColor;
import com.buzzet.blackjack.CardFace;
import com.buzzet.blackjack.Game;
import com.buzzet.blackjack.Hand;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import java.util.LinkedList;
import org.assertj.core.api.Assertions;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class MöglichkeitKeineKarteZiehenStepDef {

  Hand playerHand = Mockito.mock(Hand.class);

  Hand dealerhand = Mockito.mock(Hand.class);

  Game game = new Game();

  @Angenommen("ich habe die Karten Karo {int} und Herz König")
  public void ich_habe_die_Karten_Karo_und_Herz_König(Integer int1) {
    LinkedList cards = new LinkedList();
    cards.add(Card.builder().color(CardColor.Diamond).face(StepDefHelper.getFaceByValue(int1)).build());
    cards.add(Card.builder().color(CardColor.Heart).face(CardFace.KING).build());
    BDDMockito.given(this.playerHand.getCards()).willReturn(cards);
  }

  @Wenn("ich keine Karte mehr ziehen möchte")
  public void ich_keine_Karte_mehr_ziehen_möchte() {

  }

  @Dann("kann ich meinen Zug beenden")
  public void kann_ich_meinen_Zug_beenden() {
    Assertions.assertThat(this.game.status()).contains("Do you want to draw a card? (y/n/f)");
  }

}
