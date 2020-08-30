package test.feature.stepDef;

import com.buzzet.blackjack.CardColor;
import com.buzzet.blackjack.CardFace;
import java.util.Random;

public class StepDefHelper {

  public static CardFace getFaceByValue(final int value) {
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

  public static CardColor getColorByString(String color) {
    switch (color) {
      case "Herz":
        return CardColor.Heart;
      case "Piek":
        return CardColor.Spade;
      case "Karo":
        return CardColor.Diamond;
      case "Kreuz":
        return CardColor.Club;
      default:
        return null;
    }
  }

  public static CardColor randomCardColor() {
    int random = new Random().nextInt(4);
    switch (random) {
      case 0:
        return CardColor.Heart;
      case 1:
        return CardColor.Spade;
      case 2:
        return CardColor.Diamond;
      default:
        return CardColor.Club;
    }
  }

  public static CardFace randomCardFace() {
    int random = new Random().nextInt(13);
    switch (random) {
      case 0:
        return CardFace.TWO;
      case 1:
        return CardFace.THREE;
      case 2:
        return CardFace.FOUR;
      case 3:
        return CardFace.FIVE;
      case 4:
        return CardFace.SIX;
      case 5:
        return CardFace.SEVEN;
      case 6:
        return CardFace.EIGHT;
      case 7:
        return CardFace.NINE;
      case 8:
        return CardFace.TEN;
      case 9:
        return CardFace.ACE;
      case 10:
        return CardFace.JACK;
      case 11:
        return CardFace.QUEEN;
      default:
        return CardFace.KING;
    }
  }

  public static CardFace randomPictureCard() {
    int random = new Random().nextInt(3);
    switch (random) {
      case 0:
        return CardFace.JACK;
      case 1:
        return CardFace.QUEEN;
      default:
        return CardFace.KING;
    }
  }
}
