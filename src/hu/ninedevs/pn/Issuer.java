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
    public int maxNumbers = 0;

    public PlateNumber require(){
        PlateNumber returnVal = null;
        String[] newNum = Generator.getPlateNumber();
        returnVal = new PlateNumber(newNum[0],newNum[1]);
        boolean voltmar = false;
        for (int i = 0; i < maxNumbers; i++){
            if (returnVal.equals(kiadottRendszamok[i])) {
                voltmar = true;
            }
        }
        if (!voltmar){
            maxNumbers++;
            kiadottRendszamok[maxNumbers]=returnVal;
        }
        else {
            require();
        }
        return returnVal;
    }
}
