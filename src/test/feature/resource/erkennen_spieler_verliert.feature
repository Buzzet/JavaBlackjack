# language: de
Funktionalität: Als Dealer möchte ich erkennen, wenn ein Spieler das Spiel verloren hat

  Szenario: Wenn ein Spieler einen Kartenwert über 21 hat, hat dieser verloren
    Angenommen ein Spieler hat den Kartenwert 19
    Wenn er eine Karte mit einem Wert über 2 zieht
    Dann hat der Spieler verloren

  Szenario: Wenn der Dealer einen Kartenwert unter 22, aber über dem des Spielers hat, dann hat der Spieler verloren
    Angenommen ein Spieler hat den Kartenwert 14
    Wenn der Dealer einen Kartenwert von 17 hat
    Dann hat der Spieler verloren

  Szenario: Unendschieden bei gleichem Kartenwert
    Angenommen der Spieler hat den Kartenwert 17
    Wenn der Dealer den Kartenwert 17 hat
    Dann gibt es ein Unendschieden

  Szenario: Dealer hat nach dem austeilen 21
    Angenommen der Dealer teilt die Karten aus
    Wenn der Dealer den Kartenwert 21 hat
    Dann haben alle Spieler verloren
