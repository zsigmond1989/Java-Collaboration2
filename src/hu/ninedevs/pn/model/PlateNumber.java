package hu.ninedevs.pn.model;

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
        return "Rendszám:" +
                letterPart + "-"+
                 numberPart ;
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
}
