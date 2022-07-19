# CSV Viewer

From: https://ccd-school.de/coding-dojo/agility-katas/viewing-csv-files-i/

## German translation mapped to java

### Setup

Schreibe ein Programm das CSV Dateien auf der Konsole anzeigt.
Es soll dabei einfach von der Kommandozeile aufgerufen werden können:

```shell
./run.sh csv.csv
```

Build:

```shell
./build.sh
```

### Anforderungen 1
- Jede Zeile enthält maximal einen Datensatz (-> keine Multiline Datensätze)
- Das Trennsymbol ist ein ;
- Trennsymbole müssen nicht Escaped werden
- Die csv Datei ist immer Utf8-Codiert
- Die Spalten sollen eine feste Breite haben und sich nach dem größten Zellwert richten
- Horizontales Scrollen muss nicht beachtet werden

### Anforderungen 2 - Paging
Die Seiten der Datensätze werden als Tabelle mit Kopfzeile und Zellumrandungen (|cell|) angezeigt.
Es soll eine Seitengröße von 3 Datensätze pro Seite angenommen werden.

### Anforderungen 3 - Paging Verbesserungen
- Die Seitengröße soll als zusätzlicher parameter übergeben werden können
- Die Seitengröße soll sich automatisch an die Konsolengröße anpassen.

### Anforderungen 4 - (Zusatz)
- Das Paging soll über einen "Show All" Switch verfügen (CMD-Switch und nach dem Starten)
- Die CSV soll readme.md formatiert ausgegeben werden können [github docs](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/organizing-information-with-tables) 
- Weitere Symbole sollen als Trenner automatisch erkannt werden: `,|`
- Das Trennsymbol kann vom Nutzer frei gewählt werden
- Die Tabelle soll als HTML Tabelle gespeichert / ausgegeben werden können
- Die Tabelle soll als einfaches JSON Objekt gespeichert / ausgegeben werden können
- ... sei kreativ oder schnapp dir ein Bier

### Beispiel Ausgabe:
```
Name    | Alter| Stadt         |
--------|------|---------------|
Tim     | 32   | Sankt Blasien
Frank   | 89   | Frühling
Volker  | 15   | Elend
Patrick | 39   | Amerika
Ulf     | 55   | Hundeluft
Alex    | 5    | Ende
Chris   | 103  | Katzenelnbogen
F)irst page, P)revious page, N)ext page, L)ast page, E)xit
```
