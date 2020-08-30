package test.feature.stepDef;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.BDDMockito.given;
import static test.feature.stepDef.StepDefHelper.getColorByString;
import static test.feature.stepDef.StepDefHelper.getFaceByValue;
import static test.feature.stepDef.StepDefHelper.randomCardColor;
import static test.feature.stepDef.StepDefHelper.randomCardFace;
import static test.feature.stepDef.StepDefHelper.randomPictureCard;

import com.buzzet.blackjack.Card;
import com.buzzet.blackjack.CardColor;
import com.buzzet.blackjack.CardFace;
import com.buzzet.blackjack.Hand;
import com.buzzet.blackjack.PlayDeck;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import java.util.LinkedList;
import org.mockito.Mockito;

public class BestimmenKartenwertStepDef {

  PlayDeck mockDeck = Mockito.mock(PlayDeck.class);

  public Hand hand = new Hand(this.mockDeck);

  private int handValue;

  @Angenommen("ich ziehe eine {string} {int}")
  public void ich_ziehe_eine(final String string, final Integer int1) {
    CardFace face = getFaceByValue(int1);
    CardColor color = getColorByString(string);
    given(this.mockDeck.drawCard()).willReturn(Card.builder().face(face).color(color).build());
    this.hand.draw();
    assumeThat(this.hand.value()).isEqualTo(int1);
  }

  @Wenn("ich ein Herz Ass ziehe")
  public void ich_ein_Herz_Ass_ziehe() {
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().face(CardFace.ACE).color(CardColor.Heart).build());
    this.hand.draw();
  }

  @Dann("beträgt mein Kartenwert {int}")
  public void beträgt_mein_Kartenwert(final Integer int1) {
    assertThat(this.hand.value()).isEqualTo(int1);
  }

  @Angenommen("ich ziehe eine Piek {int}")
  public void ich_ziehe_eine_Piek(final Integer int1) {
    CardFace face = getFaceByValue(int1);
    Card expectedCard = Card.builder().face(face).color(CardColor.Spade).build();
    given(this.mockDeck.drawCard()).willReturn(expectedCard);
    Card card = this.hand.draw();
    assumeThat(card.getColor()).isEqualByComparingTo(expectedCard.getColor());
    assumeThat(card.getFace()).isEqualByComparingTo(expectedCard.getFace());
  }

  @Angenommen("ich ziehe eine zufällige Zahlenkarten")
  public void ich_ziehe_eine_zufällige_Zahlenkarten() {
    Card expectedCard = Card.builder().face(randomCardFace()).color(randomCardColor()).build();
    given(this.mockDeck.drawCard()).willReturn(expectedCard);
    Card card = this.hand.draw();
    assumeThat(card.getColor()).isEqualByComparingTo(expectedCard.getColor());
    assumeThat(card.getFace()).isEqualByComparingTo(expectedCard.getFace());
  }

  @Wenn("ich den Kartenwert ermittle")
  public void ich_den_Kartenwert_ermittle() {
    this.handValue = this.hand.value();
  }

  @Dann("beträgt der Kartenwert den Wert der Zahlenkarte")
  public void beträgt_der_Kartenwert_den_Wert_der_Zahlenkarte() {
    LinkedList<Card> cards = this.hand.getCards();
    Card card = cards.get(0);
    assertThat(this.hand.value()).isEqualTo(card.getFace().getValue());
  }

  @Angenommen("ich ziehe eine zufällige Bildkarten")
  public void ich_ziehe_eine_zufällige_Bildkarten() {
    given(this.mockDeck.drawCard())
        .willReturn(Card.builder().color(randomCardColor()).face(randomPictureCard()).build());
    this.hand.draw();
  }


  @Dann("beträgt der Kartenwert den Wert {int}")
  public void beträgt_der_Kartenwert_den_Wert(final Integer int1) {
    assertThat(this.hand.value()).isEqualTo(int1);
  }
}
