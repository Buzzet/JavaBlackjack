package com.buzzet.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.buzzet.blackjack.CardFace.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class) public class CardFaceShould {
    @Parameterized.Parameters public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { TWO.getValue(), 2 }, { THREE.getValue(), 3 },
                { FOUR.getValue(), 4 }, { FIVE.getValue(), 5 }, { SIX.getValue(), 6 },
                { SEVEN.getValue(), 7 }, { EIGHT.getValue(), 8 }, { NINE.getValue(), 9 },
                { TEN.getValue(), 10 }, { JACK.getValue(), 10 }, { QUEEN.getValue(), 10 },
                { KING.getValue(), 10 }, { ASS.getValue(), 11 }

        });
    }

    private final int result;

    private final int expected;

    public CardFaceShould(final int input, final int expected) {
        this.result = input;
        this.expected = expected;
    }

    @Test public void returnCardValue() {
        //given

        //when

        //then
        assertThat(this.result).isEqualTo(this.expected);
    }

    @Test public void trueWhenAss() {
        assertThat(ASS.isAss()).isTrue();
    }

}
