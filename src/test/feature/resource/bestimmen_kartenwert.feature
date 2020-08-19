# language: de
Funktionalität: Als Dealer möchte ich den Kartenwert bestimmen können

  Szenario: Der Kartenwert vom Ass beträgt 11, solange der summierte Kartenwert nicht über 21 liegt
    Angenommen ich ziehe eine "Herz" 6
    Wenn ich ein Herz Ass ziehe
    Dann beträgt mein Kartenwert 17

  Szenario: Der Kartenwert vom Ass beträgt 1, wenn der Kartenwert sonst über 21 liegt
    Angenommen ich ziehe eine "Herz" 6
    Und ich ziehe eine Piek 10
    Wenn ich ein Herz Ass ziehe
    Dann beträgt mein Kartenwert 17

  Szenario: Der Kartenwert von allen Zahlenkarten beträgt die Zahl selber
    Angenommen ich ziehe eine zufällige Zahlenkarten
    Wenn ich den Kartenwert ermittle
    Dann beträgt der Kartenwert den Wert der Zahlenkarte

  Szenario: Der Kartenwert von allen Bildkarten beträgt 10, außer vom Ass
    Angenommen ich ziehe eine zufällige Bildkarten
    Und diese Karte ist kein Ass
    Wenn ich den Kartenwert ermittle
    Dann beträgt der Kartenwert den Wert 10
