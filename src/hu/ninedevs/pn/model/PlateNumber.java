package hu.ninedevs.pn.model;

import hu.ninedevs.pn.Issuer;
import hu.ninedevs.pn.PlateNumbers;

import java.io.*;

/**
 * FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 * Az osztályt az alábbiak szerint implementáld:
 *
 * - konstruktora vegyen át 2 String-et, a rendszám betű és szám részeit;
 * - a konstruktor az átvett paramétereket tárolja el az osztály ezen két adattagjában: String letterPart és String numberPart;
 * - az osztálytól lehessen lekérdezni a teljes rendszámot, mondjuk a public String getFullPlateNumber() metódusban,
 *      ami összefűzi a rendszám 2 részét, köztük egy kötőjelet téve;
 * - a toString() metódust is írd meg: adja vissza ugyanazt, mint a getFullPlateNumber(), természetesen kódduplikáció nélkül
 */
public class PlateNumber {

    private String letterPart;
    private String numberPart;

    @Override
    public String toString() {
        return "Rendszám: " + getFullPlateNumber();
    }

    public PlateNumber (String letters, String numbers){
        this.letterPart=letters;
        this.numberPart=numbers;
    }
    public String getFullPlateNumber(){
        String full = new String();
        full+=letterPart;
        full+="-";
        full+=numberPart;

        return full;
    }

    public static PlateNumber[] reader() {
        BufferedReader br = null;
        PlateNumber[] beolvasottRendszamok = new PlateNumber[100];
        int i = 0;
        File f = null;
        try {
            f = new File("remdszam.txt");
            if (!f.exists()){
                return null;
            }
            br = new BufferedReader(new FileReader(new File("rendszam.txt")));
            String line;

            while((line = br.readLine()) != null) {
                String[] oneNumber = new String[2];
                oneNumber = line.split("-");
                beolvasottRendszamok[i]= new PlateNumber(oneNumber[0],oneNumber[1]);
                i++;
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (f.exists()){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return beolvasottRendszamok;

    }
}
