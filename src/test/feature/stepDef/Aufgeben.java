package test.feature.stepDef;

import com.buzzet.blackjack.Bank;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import org.assertj.core.api.Assertions;


public class Aufgeben {

  Bank bank;

  @Angenommen("mein Kontostand beträgt {int}")
  public void mein_Kontostand_beträgt(Integer int1) {
    this.bank = new Bank(int1);
  }

  @Wenn("ich {int} setze")
  public void ich_setze(Integer int1) {
    this.bank.bet(int1);
  }

  @Wenn("danach aufgebe")
  public void danach_aufgebe() {
    this.bank.forfeit();
  }

  @Dann("beträgt mein Kontostand {int}")
  public void beträgt_mein_Kontostand(Integer int1) {
    Assertions.assertThat(this.bank.getValue()).isEqualTo(int1);
  }

  @Dann("habe ich nach der Runde weniger als {int} auf meinem Konto")
  public void habe_ich_nach_der_Runde_weniger_als_auf_meinem_Konto(Integer int1) {
    Assertions.assertThat(this.bank.getValue()).isLessThan(int1);
  }

  @Angenommen("ich bin an der Reihe")
  public void ich_bin_an_der_Reihe() {
    this.bank = new Bank(1000);
  }

  @Wenn("ich aufgebe")
  public void ich_aufgebe() {
    this.bank.forfeit();
  }

  @Dann("ist der nächste Spieler an der Reihe")
  public void ist_der_nächste_Spieler_an_der_Reihe() {

  }
}
