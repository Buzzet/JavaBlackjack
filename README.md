# Blackjack in Java
## Discription
This is a basic Version of Blackjack in Java which you can use to learn Blackjack or count cards

## Usage
Simply clone the Project. All you need is in the Blackjack Folder and an example Logic, which isn't completed in the Main. All Unit tests are included.

A standart Deck contains 52 Cards, you can choose with how many decks you want to play by using the PlayDeck class.

You have to create an instance of the following.

```Java
PlayDeck deck = new PlayDeck(8) //8 is the amount of decks you want to play with
Hand playerHand = new Hand(deck) //for a standard player hand you just have to give him the deck he should draw from
Hand dealersHand = new Hand(deck, true) // if you want a dealers hand for blackjack, where the second Card is hidden until he draws, use this constructor
```

Then you are good to go!

------------------

## PlayDeck

#### `public PlayDeck(final int amount)`

New Playdeck with the amount of decks you want in it

 * **Parameters:** `amount` — - amount of decks you want to play with

#### `public int deckCount()`

Gets a deck Count

 * **Returns:** amount of decks in the PlayDeck

#### `public Card drawCard()`

Draws a Card

 * **Returns:** Card that was drawn

#### `public int cardCount()`

Counts all Cards in the PlayDeck

 * **Returns:** count of all Cards in the PlayDeck


## Hand

#### `public Hand(final PlayDeck deck)`

Basic Hand to draw cards from

 * **Parameters:** `deck` — - deck where to draw the cards from

#### `public Hand(final PlayDeck deck, final Boolean dealer)`

Hand for Blackjack

 * **Parameters:**
   * `deck` — - deck where to draw the cards from
   * `dealer` — - If this is a dealers hand. If so, hides the second card

#### `public Card draw()`

Draws a card in the Hand and reveals all other cards

 * **Returns:** 

#### `public void unhide()`

reveals all cards on the hand

#### `private Card draw(final boolean hidden)`

draws a hidden card if choosen. Does not reveal all cards on the hand

 * **Parameters:** `hidden` — if card should be hidden
 * **Returns:** 

#### `public int value()`

Gets the Basic Value of the Hand

 * **Returns:** - basic value

#### `public boolean isBusted()`

Returns if the players bust for Blackjack

 * **Returns:** 

#### `public LinkedList<Card> getCards()`

Gets all cards

 * **Returns:** - All cards as LinkedList

#### `@Override public String toString()`

Displays all non hidden cards

 * **Returns:** String with all non hidden cards




