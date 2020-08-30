package com.buzzet.blackjack;

import java.util.Scanner;

public class Game {

  private PlayDeck deck = new PlayDeck(8);
  private Hand dealerHand = new Hand(this.deck, true);
  private Hand playerHand = new Hand(this.deck, false);
  private boolean playerEndedTurn = false;
  private boolean dealerEndedTurn = false;
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RESET = "\u001B[0m";
  private Bank playerBank = new Bank(2000);
  private boolean startup = true;
  private boolean forfeit = false;
  private boolean singleGame = false;

  /**
   * Starts a single game
   */
  public Game() {

  }

  /**
   * @param singleGame if just one or multiple games are wanted
   */
  public Game(boolean singleGame) {
    this.singleGame = singleGame;
  }

  /**
   * Starts a game where dealer and player can't draw new cards
   *
   * @param dealerHand - Hand object for the dealers Hand
   * @param playerHand - Hand object for the players Hand
   */
  public Game(Hand dealerHand, Hand playerHand) {
    this.dealerHand = dealerHand;
    this.playerHand = playerHand;
    this.playerEndedTurn = true;
    this.dealerEndedTurn = true;
  }


  /**
   * starts the game
   */
  public void start() {
    if (this.startup) {
      askForBet();
      this.startup = false;
    }
    if (this.dealerHand.value() == 21) {
      this.dealerHand.unhide();
    }
    System.out.println("Dealers Hand:");
    System.out.println(this.dealerHand.toString());
    System.out.println("Players Hand:");
    System.out.println(this.playerHand.toString());
    System.out.println(status());
    if (status().contains("Wins")) {
      this.dealerHand.unhide();
      System.out.println("Dealers Hand:");
      System.out.println(this.dealerHand.toString());
      System.out.println("Players Hand:");
      System.out.println(this.playerHand.toString());
    }
    if (!this.playerEndedTurn) {
      playerDraws();
    }
    if (!this.dealerEndedTurn) {
      dealerDraws();
    }
    startAgain();
  }

  /**
   * restarts the game after a round
   */
  private void startAgain() {
    if (!this.singleGame) {
      this.dealerHand = new Hand(this.deck, true);
      this.playerHand = new Hand(this.deck, false);
      this.playerEndedTurn = false;
      this.dealerEndedTurn = false;
      this.startup = true;
      this.forfeit = false;
      start();
    }
  }

  /**
   * returns the status of the match as string and sets the player bank
   *
   * @return String of the current status
   */
  public String status() {
    if (this.forfeit) {
      return "Player forfeit";
    }
    if ((this.dealerHand.value() == 21 && this.playerHand.value() == 21) || (this.dealerEndedTurn
        && this.dealerEndedTurn && this.playerHand.value() == this.dealerHand.value()) || (this.dealerEndedTurn
        && this.playerEndedTurn && this.dealerHand.value() > 21 && this.playerHand.value() > 21)) {
      this.playerBank.draw();
      return "Draw";
    }
    if (this.dealerHand.value() > 21 || (this.dealerEndedTurn && this.playerEndedTurn
        && this.dealerHand.value() < this.playerHand
        .value()) && this.playerHand.value() < 21) {
      this.playerBank.won();
      return ANSI_GREEN + "Player Wins" + ANSI_RESET;
    }
    if ((this.dealerHand.value() == 21 && !this.playerEndedTurn) || (this.dealerHand.value() > this.playerHand.value()
        && this.playerEndedTurn) || this.playerHand.value() > 21) {
      this.playerBank.lose();
      return ANSI_RED + "Dealer Wins" + ANSI_RESET;
    }
    return "Do you want to draw a card? (y/n/f)";
  }

  /**
   * let the player draw
   */
  private void playerDraws() {
    if (this.playerHand.value() < 22 && askForCard()) {
      this.playerHand.draw();
    } else {
      this.playerEndedTurn = true;
    }
    start();
  }

  /**
   * asks the player for a card
   *
   * @return if the player wanted a card or not
   */
  public boolean askForCard() {
    final Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    s = s.toLowerCase();
    if (s.equals("f")) {
      this.playerBank.forfeit();
      return false;
    }
    if (!s.equals("y") && !s.equals("n")) {
      System.out.println("invalid input");
      return askForCard();
    }
    return s.equals("y");
  }

  /**
   * Asks the player for there bet
   */
  public void askForBet() {
    System.out.println("How much do you want to Bet? Bank: " + this.playerBank.getValue());
    final Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int value = 0;
    try {
      value = Integer.parseInt(s);
    } catch (Exception e) {
      System.out.println("Invalid Value, try again!");
      askForBet();
    }
    this.playerBank.bet(value);
  }

  /**
   * Lets the dealer draw a card until he hits 17 or higher
   */
  private void dealerDraws() {
    while (this.dealerHand.value() < 17) {
      this.dealerHand.draw();
    }
    this.dealerEndedTurn = true;
    start();
  }
}
