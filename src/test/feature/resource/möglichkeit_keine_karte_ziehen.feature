# language: de
Funktionalität: Als Spieler möchte ich in meinem Zug die Möglichkeit haben, keine Karte zu ziehen, damit ich meinen kartenwert behalte

  Szenario: Der Spieler kann jederzeit seinen Zug selbstständig beenden, wenn sein Kartenwert unter 22 liegt
    Angenommen ich habe die Karten Karo 10 und Herz König
    Und ich bin am Zug
    Wenn ich keine Karte mehr ziehen möchte
    Dann kann ich meinen Zug beenden

  Szenario: Wenn der Spieler seinen Zug beendet, ist der nächste Spieler an der Reihe
    Angenommen ich habe die Karten Karo 10 und Herz König
    Und ich bin am Zug
    Wenn ich meinen Zug beende
    Dann ist der nächste Spieler an der Reihe
    Und ich bin nicht mehr am Zug

  Szenario: Wenn der Spieler seinen Zug beendet, ändert sich sein Kartenwert in der Runde nicht mehr
    Angenommen ich habe die Karten Karo 10 und Herz König
    Und ich bin am Zug
    Wenn ich meinen Zug beende
    Dann behalte ich den Kartenwert 20 für den Rest der Runde
