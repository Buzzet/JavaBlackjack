package test.unitsTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.buzzet.blackjack.Game;
import com.buzzet.blackjack.Hand;
import com.buzzet.blackjack.PlayDeck;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class GameShould {

  @Rule
  public final TextFromStandardInputStream systemInMock
      = TextFromStandardInputStream.emptyStandardInputStream();
  @Spy
  PlayDeck deck = new PlayDeck(8);

  @Spy
  Hand playerHand = new Hand(this.deck, false);

  @Spy
  Hand dealerHand = new Hand(this.deck, true);

  @InjectMocks
  Game game = new Game();

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(this.outContent));
    System.setErr(new PrintStream(this.errContent));
  }

  @Before
  public void setInStreams() {
    this.systemInMock.provideLines("1000", "n");
  }

  @After
  public void restoreStreams() {
    System.setOut(this.originalOut);
    System.setErr(this.originalErr);
  }

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void letDealerWinIfHeHits21() {
    given(this.dealerHand.value()).willReturn(21);
    assertThat(this.game.status()).contains("Dealer Wins");
  }

  @Test
  public void letDealerLoseIfHeHits25() {
    given(this.dealerHand.value()).willReturn(25);
    assertThat(this.game.status().contains("Dealer Wins"));
  }

  @Test
  public void dealTwoCardsOnStart() {
    assertThat(this.dealerHand.getCards().size()).isEqualTo(2);
    assertThat(this.dealerHand.getCards().size()).isEqualTo(2);
  }

  @Test
  public void letDealerWinsIfHeDraws21OnStart() {
    //given
    given(this.dealerHand.value()).willReturn(21);
    //when
    this.game.start();
    //then
    assertThat(this.game.status()).contains("Dealer Wins");

  }

  @Test
  public void letPlayerWinsIfDealerHasOver21() {
    //given
    given(this.dealerHand.value()).willReturn(23);
    //when
    this.game.start();
    //then
    assertThat(this.game.status()).contains("Player Wins");

  }

  @Test
  public void returnDrawIfBothHave21() {
    //given
    given(this.dealerHand.value()).willReturn(21);
    given(this.playerHand.value()).willReturn(21);
    //when
    this.game.start();
    //then
    assertThat(this.game.status()).isEqualTo("Draw");

  }

  @Test
  public void printHands() {
    //when
    this.game.start();
    //then
    assertThat(this.outContent.toString())
        .contains(
            "Dealers Hand:\n" + this.dealerHand.toString() + "\nPlayers Hand:\n" + this.playerHand.toString() + "\n");
  }

  @Test
  public void printHandsUnhiddenIfDealerHit21() {
    //given
    given(this.dealerHand.value()).willReturn(21);
    //when
    this.game.start();
    //then
    assertThat(this.outContent.toString()).doesNotContain("Hidden");
  }

  @Test
  public void askForACard() {
    //given
    given(this.dealerHand.value()).willReturn(17);
    given(this.playerHand.value()).willReturn(7);
    //when
    this.game.start();
    //then
    assertThat(this.outContent.toString()).contains("Do you want to draw a card?");
  }

  @Test
  public void letPlayerWinIfValueOverDealerAndBothEndetTheTurn() {
    given(this.playerHand.value()).willReturn(19);
    given(this.dealerHand.value()).willReturn(18);
    //when
    this.game.start();
    assertThat(this.outContent.toString()).contains("Player Wins");
  }

}
