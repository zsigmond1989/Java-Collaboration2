package hu.ninedevs.pn;

import hu.ninedevs.pn.model.PlateNumber;

/**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 * Az osztályt az alábbiak szerint implementáld:
 *
    - tartson nyilván egy PlateNumber[] tömböt, (kiadottRendszamok néven) amiben eltárolja a már kiadott rendszámokat;
    - legyen egy require() nevű példánymetódusa, amelyen igényelni lehet egy új, még nem létező rendszámot;
    - a require() visszatérési értéke PlateNumber legyen;
    - az Issuer a Generator osztályt kérje meg, hogy gyártson számára egy új rendszámot, de csak akkor fogadja el,
        ha kiadott rendszámok között még nem létezik a legyártott rendszám;
    - az Issuer addig próbálkozzon a Generator-nál, ameddig nem kap olyan rendszámot, ami még nem létezik
    - ha megfelelő rendszámot kapott, akkor tárolja el a kiadottRendszámok tömbbben is
 */
public class Issuer {
    public PlateNumber[] kiadottRendszamok = new PlateNumber[100];

    public PlateNumber require(){
        PlateNumber returnVal = null;
        //returnVal = returnVal.Generator();
        return returnVal;
    }
}
