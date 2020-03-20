package hu.ninedevs.pn;


/**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 * <p>
 * TEAM MUNKA 3 fős fejlesztői csoportokban.
 * <p>
 * Team 1:
 * - Zsigmond (dev1, lead developer)
 * - Tamás (dev2)
 * - Gábor (dev3)
 * <p>
 * Team 2:
 * - Attila (dev1)
 * - Levente (dev2)
 * - Kálmán (dev3, lead developer)
 * <p>
 * A csoport lead developer-e forkolja és klónozza a repository-t, és ellenőrizze, hogy a saját neve alatt létrejött-e a GitHub-on a másolat.
 * A lead developer hívja meg a másik két csapattagot kollaborációra a saját neve alatt létrejött másolathoz. Ezen a másolaton fog dolgozni a csapat.
 * Mindhárman klónozzák a forkolt repót.
 * Az eredeti repót (zsoltkiss/Java-Collaboration2) SENKI NE KLÓNOZZA!
 * Segítsétek a lead developer munkáját, de ha bármiről dönteni kell, ő dönt!
 * <p>
 * A PROJEKT: Rendszám generálás (PlateNumbers.java)
 * Írj olyan programot, amely szabályos magyar gépjármű rendszámokat generál (3 betű, kötőjel, 3 szám)!
 * A programot OOP szemlélettel írd meg, a következő komponensek (osztályok) alkalmazásával:
 * - hu.ninedevs.pn.Issuer
 * - hu.ninedevs.pn.Generator
 * - hu.ninedevs.pn.model.PlateNumber
 * - hu.ninedevs.pn.PlateNumbers
 * <p>
 * MUNKAMEGOSZTÁS:
 * Developer 1 csinálja: PlateNumbers.java, PlateNumber.java
 * Developer 2 csinálja: Issuer.java
 * Developer 3 csinálja: Generator.java
 * <p>
 * CÉL:
 * A team munka eredményeképp jöjjön létre a fordítási hibától mentes, futtatható, a megadott specifikációnak mindenben megfelelő program.
 * Minden olyan aspektusban, amit a feladatkiírás esetleg nem szab meg, a döntés elsősorban a lead developer-é, másodsorban azé a fejlesztőé, aki
 * az adott osztályt/kódrészletet implementálja.
 * <p>
 * DEADLINE/HATÁRIDŐ:
 * A kezdéstől számított 1 óra.
 */

/*
 * Második kör:
 *  Issuer improvement:
 *      DEVELOPER 3-as kapja meg ezt a feladatot!
 *      legyen az Issuer-nek egy olyan konstruktora, amiben át tudja venni a régebben létrehozott rendszámok tömbjét
 *
 *  PlateNumbers improvement:
 *      DEVELOPER 2-es kapja meg ezt a feladatot!
 *      1./ régebben kiadott rendszámok beolvasása fájlból (pl. rendszamok.txt), a fájl tartalma alapján
 *          PlateNumbers[] tömb létrehozása majd továbbadása az Issuer új konstruktorának
 *          (tehát gyakorlatilag a program indulásakor az Issuer úgy inicializálódjon, hogy a régebben kiadott rendszámokat
 *          a PlateNumbers egy statikus metódusa felolvassa, tömböt csinál és ezt adja oda az Issuer konstruktornak)
 *          a fájlt beolvasó és feldolgozó kód egy külön statikus metódus legyen a PlateNumbers-ben:
 *          static PlateNumbers[] readFromFile(String fileName) {...}
 *
 *      DEVELOPER 1-es kapja meg ezt a feladatot!
 *      2./ biztosítani azt, hogy minden egyes sikeres új rendszám igénylésnél az új rendszám hozzáíródjon a rendszamok.txt tartalmához
 *          (külön statikus metódus a PlateNumbers-ben)
 *          static void appendPlateNumber(PlateNumber pn) {...}
 */

import hu.ninedevs.pn.model.PlateNumber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Csapatok:
 *
 * Dev1: Zsigmond (lead)
 * Dev2: Tamás
 * Dev3: Gábor
 *
 *
 * Dev1: Attila
 * Dev2: Levi
 * Dev3: Kálmán (lead)

 /**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 * Az osztályt az alábbiak szerint implementáld:
 *
 *  - itt írd meg a program belépési pontját;
 *  - igényelj 5 rendszámot az Issuer-től és írasd ki őket;
 */
public class PlateNumbers {


    public static void main(String[] args) {
        PlateNumber[] test = PlateNumber.reader();
        try {
            appendPlateNumber(test);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    static void appendPlateNumber(PlateNumber[] pn) throws IOException {
        File f = new File("src/rendszam.txt");
        FileWriter fw = new FileWriter(f,true);
        PrintWriter pw = new PrintWriter(fw);
        Issuer b = new Issuer(pn);
        for (int i = 0; i < 5; i++) {
            PlateNumber newPlateNumber = b.require();
            pw.print(newPlateNumber.toString());
            System.out.println((i+1) + ". " +newPlateNumber.toString());
        }

    }


}
