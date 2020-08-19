# language: de
Funktionalität: Als Spieler möchte ich eine neue Karte ziehen um meinen Kartenwert zu erhöhen

  Szenario: Durch das Ziehen einer Karte erhöht sich mein Kartenwert
    Angenommen ich habe eine Karo 10 auf der Hand
    Wenn ich eine Karo 6 ziehe
    Dann liegt mein Kartenwert bei 16

  Szenario: Ich ziehe eine Karte und mein Kartenwert liegt über 21
    Angenommen ich habe eine Karo 10 auf der Hand
    Wenn ich eine Karo 8 ziehe
    Und ich eine Karo 9 ziehe
    Dann liegt mein Kartenwert über 21
    Und ich darf keine weitere Karte ziehen
