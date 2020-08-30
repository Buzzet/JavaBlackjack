package test.feature.stepDef;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/feature/resource/spieler_zieht_karten.feature",
    "src/test/feature/resource/bestimmen_kartenwert.feature",
    "src/test/feature/resource/erkennen_spieler_gewonnen.feature",
    "src/test/feature/resource/möglichkeit_keine_karte_ziehen.feature",
    "src/test/feature/resource/erkennen_spieler_verliert.feature"}
)
public class CucumberRunner {


}
