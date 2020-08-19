package test.feature.stepDef;

import com.buzzet.blackjack.Hand;
import com.buzzet.blackjack.PlayDeck;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/feature/resource/spieler_zieht_karten.feature"}
)
public class CucumberRunner {

  @Rule
  public MockitoRule mockito = MockitoJUnit.rule();

  @InjectMocks
  public PlayDeck mockDeck = new PlayDeck(6);

  @InjectMocks
  public Hand hand = new Hand(this.mockDeck);
}
