**MatrixCalculator -määrittelydokumentti**

Käytän matriisilaskimessa tietorakenteena double-taulukkoa, johon saa hyvin matriisimaisesti luvut paikoilleen. Taulukosta hakeminenkin sujuu nopeasti.

Perusoperaatioiden(plus, miinus, kerto, skalaarikertominen) lisäksi toteutan ainakin determinantin ja käänteismatriisin laskemisen.

Käyttäjä voi graaffisen käyttöliittymän kautta syöttää ohjelmalle erikokoisia matriiseja, joille tehdään valitut laskutoimitukset. Matriiseihin voi laittaa kokonaislukujen lisäksi desimaalilukuja. 

Perusoperaatioiden aikavaatimus pyrkii olemaan O(nm), missä n on rivien määrä ja m sarakkeiden määrä. Tilavaativuus on myös O(nm).
Determinantin aikavaativuus ja tilavaativuus on O(n^3).

Lähteet: TiRa-kurssi
