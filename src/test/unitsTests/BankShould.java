package test.unitsTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.buzzet.blackjack.Bank;
import org.junit.Test;

public class BankShould {

  @Test
  public void returnItsValue() {
    //given
    Bank bank = new Bank(0);
    //when
    bank.setValue(1000);
    //then
    assertThat(bank.getValue()).isEqualTo(1000);
  }

  @Test
  public void setBetValue() {
    //given
    Bank bank = new Bank(1000);
    //when
    bank.bet(500);
    //then
    assertThat(bank.getBet()).isEqualTo(500);
  }

  @Test
  public void throwExceptionIfBetIsHigherThanValue() {
    //given
    Bank bank = new Bank(200);
    //when
    //then
    assertThatThrownBy(() -> {
      bank.bet(500);
    }).hasMessage("You bet of 500 exceeds your limit of 200");
  }

  @Test
  public void doubleTheBetOnWin() {
    //given
    Bank bank = new Bank(500);
    bank.bet(500);
    //when
    bank.won();
    //then
    assertThat(bank.getValue()).isEqualTo(1000);
  }

  @Test
  public void returnHalfWhenGivingUp() {
    //given
    Bank bank = new Bank(1000);
    bank.bet(200);
    //when
    bank.forfeit();
    //then
    assertThat(bank.getValue()).isEqualTo(900);
  }

  @Test
  public void returnBetOnDraw() {
    //given
    Bank bank = new Bank(1000);
    bank.bet(500);
    //when
    bank.draw();
    //then
    assertThat(bank.getValue()).isEqualTo(1000);
  }

  @Test
  public void loseMoneyOnLose() {
    //given
    Bank bank = new Bank(1000);
    bank.bet(500);
    //when
    bank.lose();
    //then
    assertThat(bank.getValue()).isEqualTo(500);
  }

}
