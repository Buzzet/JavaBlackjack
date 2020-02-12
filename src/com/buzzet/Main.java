package com.buzzet;

import com.buzzet.blackjack.Hand;
import com.buzzet.blackjack.PlayDeck;

import java.util.Scanner;

public class Main {

    static PlayDeck deck = new PlayDeck(8);
    static Hand dealerHand = new Hand(deck, true);
    static Hand playerHand = new Hand(deck);

    public static void main(final String[] args) {
        System.out.println("Welcome to Blackjack");
        System.out.println("Lets Draw Cards");
        play();

    }

    public static void play() {
        if (dealerHand.value() == 21) {
            dealerHand.unhide();
            System.out.println("Dealers Hand:");
            System.out.println(dealerHand.toString());
            System.out.println("Dealer Wins");
        } else {
            System.out.println("Dealers Hand:");
            System.out.println(dealerHand.toString());
            System.out.println("Your Hand");
            System.out.println(playerHand.toString());
            System.out.println("Your Value: " + playerHand.value());
            if (askForCard()) {
                playerHand.draw();
                if (!playerHand.isBusted()) {
                    play();
                } else {
                    System.out.println("Dealers Hand:");
                    System.out.println(dealerHand.toString());
                    System.out.println("Your Hand");
                    System.out.println(playerHand.toString());
                    System.out.println("Your Value: " + playerHand.value());
                }
            }
            dealersTurn();
            win();
        }
    }

    private static void dealersTurn() {
        while (dealerHand.value() < 17) {
            dealerHand.draw();
            System.out.println("Dealers Hand:");
            System.out.println(dealerHand.toString());
            System.out.println("Dealers Value: " + dealerHand.value());
        }
    }

    private static void win() {
        if (playerHand.isBusted()) {
            if (dealerHand.isBusted()) {
                System.out.println("Draw");
            } else {
                System.out.println("Dealer wins");
            }
        } else {
            if (dealerHand.isBusted()) {
                System.out.println("Player Win");
            } else if (dealerHand.value() > playerHand.value()) {
                System.out.println("Dealer Wins");
            } else if (dealerHand.value() == playerHand.value()) {
                System.out.println("Draw");
            } else {
                System.out.println("Player Wins");
            }
        }
    }

    public static boolean askForCard() {
        System.out.println("Do you want a card? (y/n)");
        final Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.toLowerCase();
        if (!s.equals("y") && !s.equals("n")) {
            System.out.println("invalid input");
            return askForCard();
        }
        return s.equals("y");
    }

}
