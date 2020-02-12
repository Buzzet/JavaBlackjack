package com.buzzet.blackjack;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString public class Card {
    private CardColor color;
    private CardFace face;
    private boolean hidden;
}
