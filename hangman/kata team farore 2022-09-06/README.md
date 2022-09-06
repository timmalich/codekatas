# Galgenmännchen

Basierend auf: https://ccd-school.de/coding-dojo/class-katas/galgenmaennchen/

## Ablauf
1) Intro [5 min]
2) Selbststudium zur Kata [10 min]
3) Abstimmung zum Vorgehen in der Kata [10 min]
4) Start in 2 Teams um: 13:30 Uhr
5) Zusammenkunft um 15:15 Uhr 
6) Kurze Code Vorstellung je team 5 min
7) Diskussion
8) Feedback um 15:45Uhr

Die Kata wird aufgrund der größe gesplitted in 2 Teams:

### Team Nayru
- Mathbias Michter der Große
- Friss Kaule der Schnelle
- Prank Steif der Trickreiche
- Candreas Klüger der Erfahrene


### Team Farore
- Bin Mal Ich der Lustige
- Mathbias Möbele der Experte
- Chefin Hellenkerker der Schöne
- Volter Weiß der König



## Galgenmännchen

Erfülle die Klasse Hangman.java mit "leben".

### Setup

Build:
```shell
./build.sh
```

Run:
```shell
./run.sh hallo
```

### Anforderungen in absteigender Priorität
- Die Klasse Hangman erhält ein zu erratendes Wort als Eingabe.
- Das gesuchte Wort wird sofort maskiert zurückgegeben (siehe Beispiel)
- Pro Runde wird ein Buchstabe abgefragt, stimmt der Buchstabe mit einem Buchstaben aus der ursprünglichen Eingabe überein, werden alle übereinstimmenden Buchstaben aufgedeckt
- Werden mehrere Buchstaben übergeben, wird dies als Lösungsvorschlag betrachtet. Stimmt die Eingabe mit dem gesuchten Wort überein, ist das Spiel vorbei.
- Wurde der letzte Buchstabe aufgedeckt, ist das Spiel vorbei.
- Alle Vergleiche sollten Case Insensitiv sein

### Extension 0
- Die Anzahl der Versuche sollte optional beschränkbar sein. Wird die Anzahl überschritten, gewinnt der Input-Geber.
- Das Galgenmännchen soll grafisch visualisiert werden (siehe Beispiele)

### Extension 1
- Das Spiel soll als Webservice zur Verfügung gestellt werden
- Endpunkte: 
  - POST /hangman/{thewordtoguess} -> erstellt ein neues Spiel und generiert eine UUID und gibt diese zurück
  - POST /hangman/{uuid}/{guess}   -> Der Parameter guess ist der gleiche Input wie aus den ersten Anforderungen 

### Extension 2
- Verpacke den Service in einen Container
- Mach den Service in k8s deploybar

### Extension 3
- Schreibe einen Bot Bruteforce zum Lösen der Galgenmännchen
- Mach den Bot intelligenter (z.B. über Wortlisten oder häufigkeiten von Buchstaben in Wörtern

### Extension 4
- Erstelle einen Multiplayer-Mode

### Beispiele
#### Minimales Spiel
Eingabe Wort ist DEVELOPER
```text
####### WELCOME TO HANGMAN ########
Gimme a word: *********

Guess      Response
X          *********     
d          D********
e          DE*E***E*
r          DE*E***ER
r          DEVE***ER
O          DEVE*O*ER
DEVELOPER  DEVELOPER

Congrats you won!
```

#### Extension 1 Beispiel
Eingabe Wort ist DEVELOPER

```text
####### WELCOME TO HANGMAN ########
Gimme a word: *********






=========

Guess: E
*E*E***E*





=========

Guess: X
*E*E***E*

  |
  |
  |
  |
  |
  |
=========

Guess: Z
*E*E***E*

  |---+
  |
  |
  |
  |
  |
=========

Guess: F
*E*E***E*

  |---+
  |   |
  |
  |
  |
  |
=========

Guess: X
*E*E***E*

  |---+
  |   |
  |   0
  |
  |
  |
=========

Guess: C
*E*E***E*

  |---+
  |   |
  |   0
  |   |
  |
  |
=========

Guess: Ä
*E*E***E*

  |---+
  |   |
  |   0
  |  /|
  |
  |
=========

Guess: Ö
*E*E***E*

  |---+
  |   |
  |   0
  |  /|\
  |
  |
=========

Guess: t
*E*E***E*

  |---+
  |   |
  |   0
  |  /|\
  |  /
  |
=========

Guess: ValarMorghulis
*E*E***E*

  |---+
  |   |
  |   0
  |  /|\
  |  /`\
  |
=========

You've lost :-(
```
