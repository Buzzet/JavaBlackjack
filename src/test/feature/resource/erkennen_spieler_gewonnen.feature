# language: de
Funktionalität: Als Dealer möchte ich erkennen, wenn ein Spieler gewonnen hat.

  Szenario: Dealer hat einen Kartenwert über 21
    Angenommen der Dealer hat einen Kartenwert von 15
    Wenn er eine Karte mit dem Kartenwert über 6 zieht
    Und der Spieler einen Kartenwert unter 22 hat
    Dann hat der Spieler gewonnen

  Szenario: Dealer hat einen niedrigeren Kartenwert
    Angenommen der Dealer hat einen Kartenwert von 16
    Wenn er eine Karte mit dem Kartenwert 1 zieht
    Und der Spieler einen kartenwert von 19 hat
    Dann hat der Spieler gewonnen
