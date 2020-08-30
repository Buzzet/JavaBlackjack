# language: de
Funktionalität: Als Dealer möchte ich am Start einer Runde Karten austeilen

  Szenario: Der Dealer bekommt die erste Karte offen
    Angenommen die Runde startet
    Wenn der Dealer die erste Karte zieht
    Dann bekommt diese Karte der Dealer
    Und die Karte ist offen

  Szenario: die nächste Karte geht an den Spieler
    Angenommen der Dealer hat eine Karte
    Und der Spieler hat keine Karte
    Dann bekommt die nächste Karte der Spieler
    Und die Karte ist offen

  Szenario: der Dealer bekommt als 2. Karte eine verdeckte
    Angenommen der Dealer hat eine Karte
    Und alle Spieler haben eine Karte
    Dann bekommt der Dealer eine zweite Karte
    Und die Karte ist verdeckte

  Szenario: Der Spieler bekommt seine zweite Karte
    Angenommen der Dealer hat zwei Karten
    Und der Spieler hat eine Karte
    Dann bekommt die nächste Karte der Spieler
    Und die Karte ist offen
