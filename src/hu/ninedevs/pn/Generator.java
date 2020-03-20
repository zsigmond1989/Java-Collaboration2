package hu.ninedevs.pn;

/**
 *  FONTOS! Ezt a leírást NE MÓDOSÍTSD, NE TÖRÖLD KI semmilyen részletét a munka során!
 *
 *  Az osztályt az alábbiak szerint implementáld:
 *
 * - egyetlen static metódust tartalmazzon, ami egy kételemű String[] tömböt ad vissza;
 * - a visszaadott tömb 0. eleme legyen a rendszám 3 betűből álló része, az 1. eleme pedig a rendszám 3 számból álló része;
 * - véletlenszerű számot és betűkombinációt generáljon minden meghívásra
 * - ennek az osztálynak nem kell törődnie azzal, hogy a generált kombinációk fel lettek-e már használva kiadott rendszámokban
 */

import java.util.Random;

public class Generator {
        public static String[] getPlateNumber(){
            StringBuilder letterPart= new StringBuilder();
            StringBuilder numberPart= new StringBuilder();
            char c ;
            Random r = new Random();

            for(int i = 0; i<3; i++){
                c = (char)(r.nextInt( ('Z'-'A')+1 )+'A');
                letterPart.append(c);
                c = (char)(r.nextInt( ('9'-'0')+1 )+'0');
                numberPart.append(c);
            }

            return new String[]{letterPart.toString(), numberPart.toString()};
        }
}
