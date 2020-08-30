# language: de
Funktionalität: Als Spieler möchte ich aufgeben können, um die Hälfte meines Einsatzes zurück zu bekommen

  Szenario: Wenn der Spieler aufgibt wird die Hälfte seines Einsatzes wieder seinem Konto gutgeschrieben
    Angenommen mein Kontostand beträgt 1000
    Wenn ich 500 setze
    Und danach aufgebe
    Dann beträgt mein Kontostand 750

  Szenario: Wenn der Spieler aufgibt, kann er kein zusätzliches Geld in dieser Runde gewinnen
    Angenommen mein Kontostand beträgt 1000
    Wenn ich 500 setze
    Und danach aufgebe
    Dann habe ich nach der Runde weniger als 1000 auf meinem Konto

  Szenario: Wenn der Spieler aufgibt, ist der nächste Spieler an der Reihe
    Angenommen ich bin an der Reihe
    Wenn ich aufgebe
    Dann ist der nächste Spieler an der Reihe
