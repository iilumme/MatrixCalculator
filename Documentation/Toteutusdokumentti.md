**Toteutusdokumentti**

MatrixCalculatorin yleisrakenne on hieman sekava vielä tällä hetkellä. 
Main-luokka kuitenkin käynnistää graaffisen käyttöliittymän, joka koostuu monista pienistä komponenteista.
Kaikista laskutoimituksista huolehtii Calculator-luokka, jota kutsutaan OperationButtonListeneristä
(joka on luvattoman sekava).

Matriiseja mallintaa Matrix-luokka, ja sen alaluokat ZeroMatrix ja IdentityMatrix(joita ei ole vielä täysin otettu käyttöön).

Näkymä, jonka käyttäjä näkee rakentuu monesta pienestä palikasta. "Alimpana" on Background-luokka, jonka päälle laitetaan
ButtonsPanel, jossa on napit jokaiselle laskuoperaatiolle, sekä CalculationPanel.
CalculationPanel koostuu kahdesta MatrixPanelista ja MatrixLabelista, joka on luokka tulosmatriisille.
MatrixPanelissa on MatrixField, taulukon muodossa olevat tekstialueet joihinka matriisin luvut kirjoitetaan,
ja RowsAndColumnsPanel, joka sisältää rivien ja sarakkeiden määrän asettamisen, nolla- ja yksikkömatriisien luomisen ja matriisien tyhjentämisen.

Eri nappien toimintaa hallitsevat LeftRightButtonListener, MatrixButtonListener, OperationButtonListener ja SetButtonListener.

/Luokkakaavio tulossa/

/O-analyysit tulossa/

