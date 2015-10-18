##Toteutusdokumentti

**Ohjelman yleisrakenne**

Ohjelman logiikasta vastaavat pääosin luokat Matrix, Calculator, LUDecomposition, DeterminantCalculator ja InverseCalculator.
Matrix mallintaa matriiseja, Calculator laskee laskuoperaatioita tai sysää vastuun eteenpäin DeterminantCalculatorille, joka laskee determinantteja, tai InverseCalculatorille, joka etsii käänteismatriisin. LUDecomposition tekee annetulle matriisille LU-hajotelman, jonka avulla voidaan laskea determinantti ja käänteismatriisi.


**Saavutetut aika- ja tilavaativuudet**

Yhteenlaskun, vähennyslaskun ja  skalaarikertolaskun aikavaativuus on O(mn), missä m on rivien ja n sarakkeiden määrä, sillä jokaisessa matriisin luvussa käydään kerran. Tilavaativuus on myös O(mn).

Kertolaskun AB aikavaativuus on O(mnp), missä A = m x n ja B = n x p. Tilavaativuus on O(mp), sillä AB:n koko on m x p.
```
MatrixMultiply(Matrix A, Matrix B) 

    if A.columns != B.rows break

    Matrix M (A.rows, B.columns)
    
    aRow = 0
    aColumn = 0

    bRow = 0
    int bColumn = 0

    while (aRow < A.rows AND aColumn < A.columns) 

        M[aRow][bColumn] += A[aRow][aColumn] * B[bRow][bColumn]

        if (bColumn == B.columns - 1 AND aColumn == A.columns - 1) 
            aRow++
            aColumn = 0

            if (bRow == B.rows - 1 AND bColumn == B.columns - 1) 
                bRow = 0
            else 
                bRow++
                
            bColumn = -1

        else if (bColumn == B.columns - 1) 
            aColumn++
            bRow++
            bColumn = -1

        bColumn++;

```

LUDecompositionin aikavaativuus on O(n^3), kolme for-looppia. Tilavaativuus on O(n^2), koska matriisit L ja U ovat neliömatriiseja n x n. 

```
LUDecomposition(Matrix A)

        Matrix L(A.rows, A.columns)
        Matrix U(A.rows, A.columns)

        for (int i = 0; i < A.rows; i++) 
            for (int j = 0; j < A.columns; j++) 
                elements[]
                pos = 0
                for (int k = 0; k < rows; k++) 
                    elements[pos] = L[i][k]
                    pos++
                    elements[pos] = U[k][j]
                    pos++
                    
                countables[]
                posit = 0

                for (int k = 0; k < elements.length; k++) 
                
                    first = elements[k]
                    second = elements[k + 1]

                    if (first == 1 AND second == Double.MAX_VALUE) 
                        countables[posit] = second
                        posit++
                    else if (first == Double.MAX_VALUE AND second == 1) 
                        countables[posit] = first
                        posit++
                    else if (first != 0 AND second == Double.MAX_VALUE) 
                        countables[posit] = first
                        posit++
                        countables[posit] = second
                        posit++
                    else if (first == Double.MAX_VALUE AND second != 0) 
                        countables[posit] = second
                        posit++
                        countables[posit] = first
                        posit++
                    else if (first != 0 AND second != 0) 
                        double result = first * second;
                        A[i][j] -= result;
                    
                    k++
                
                
                ...

```
LU-hajotelmaa käytetään determinantin laskemisessa. Determinantin saa laskettua kertomalla U-matriisin diagonaalin luvut keskenään, minkä aikavaativuus on lineaarinen joten determinantti löytyy ajassa O(n^3) ja tilassa O(n^2).

Käänteismatriisin löytämisessä käytetään myös LU-hajotelmaa ja sen lisäksi tehdään lisätoimituksia. Ilman LU-hajotelmaa käänteismatriisialgoritmin aikavaativuus on O(n^3) ja tilavaativuus on O(n^2).

```
Inverse(Matrix A)

    LUDecomposition lud(A)
    Matrix L = lud.LowerTriangularMatrix
    Matrix U = lud.UpperTriangularMatrix
    IdentityMatrix I(A.rows)
    Matrix inverse(A.rows, A.columns)

    y[] = new double[A.rows]
    x[] = new double[A.rows]

    for (int i = 0; i < A.columns; i++) 
        identityMatrixColumn[] = I.getColumn(i)

        for (int j = 0; j < A.rows; j++) 
            minus = 0

            for (int k = 0; k < A.columns; k++) 
                if (j == k) 
                    continue
                minus += L[j][k] * y[k]
                    
            y[j] = identityMatrixColumn[j] - minus

        for (int l = rows - 1; l >= 0; l--) 

            minus = 0;

            for (int k = 0; k < columns; k++) 
                if (l == k) 
                    continue

                if (U[l][k] == 0) 
                    continue;

                minus += U[l][k] * x[k];
                    
          x[l] = (y[l] - minus) / U[l][l]
          inverse[l][i] = x[l]

```
**Työn mahdolliset puutteet ja parannusehdotukset**

Ohjelman syötteeksi ei voi antaa murtolukuja, mikä olisi hyvä lisä. Sekä vastausmatriisissa voisi olla murtolukuja.
Double käyttämisen takia luvut ovat usein väärin, ja niiden saaminen oikein Rounder-luokassa voisi olla parempikin.
Graaffisen käyttöliittymän luokat ovat melko sekavat ja niitä on aikas monta, joten niitä voisi siistiä.

Lähteet: 
  TiRa
