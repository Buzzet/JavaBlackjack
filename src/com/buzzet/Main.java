package com.buzzet;

import com.buzzet.blackjack.Game;

public class Main {

  public static void main(final String[] args) {
    System.out.println("Welcome to Blackjack");
    System.out.println("Lets Draw Cards");
    //play();
    Game game = new Game();
    game.start();
  }
}
