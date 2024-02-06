// Iga ülesande lahendus olgu kirjas omaette meetodis, mida saab main-meetodist välja
// kutsuda. Main-meetodis on deklareeritud muutujad, mis antakse igale meetodile
// argumendiks ette. Tulemused trükitakse konsoolile.

public class Main {
    public static void main(String[] args) {
        System.out.println("1. " + symbolidKeskel("abba"));
        System.out.println("2. " + sisaldabAlams6ne("abaxaaaxc"));
        System.out.println("3. " + kordusteArv(new int[]{3, 2, 1, 4, 55, 2, 1, 9, 0, 2}, 2));
    }

    // 1. Olgu meetodi sisendiks suvalise pikkusega sõne (pikkus võib olla ka 0). Kui sõne
    // pikkus on paarisarvuline, tahame vastuseks selle sõne 2 keskmist sümbolit. Kui sõne
    // pikkus on paarituarvuline, tahame vastuseks saada sõne 3 keskmist sümbolit. Kui
    // sõne on liiga lühike, tuleb tagastada kogu sõne (ehk siis juhtudel, kui sõne pikkus on 0
    // või 1).
    
    public static String symbolidKeskel(String s6ne) {
        int pikkus = s6ne.length();
        if (pikkus <= 1) { // Kui sõne on liiga lühike
            return s6ne; // tagastab kogu sõne.
        } else if (pikkus % 2 == 0) { // Kui on paarisarv, siis...
            int keskmine = pikkus / 2; //  leiab keskmised sümbolid substringi kasutades.
            return s6ne.substring(keskmine - 1, keskmine + 1);
        } else {
            int keskmine = pikkus / 2; // Paarituarvu puhul kasutan sama substringi meetodit.
            return s6ne.substring(keskmine - 1, keskmine + 2);
        }
    }

    // 2. Olgu meetodi sisendiks suvalise pikkusega sõne (pikkus võib olla ka 0). Tahame
    // saada vastuseks tõeväärtuse “true”, kui 2. või 4. positsioonil asub alamsõne “aaa”, ja
    // “false” muidu.

    public static boolean sisaldabAlams6ne(String s6ne) {
        if (s6ne.length() < 4) {
            return false;
        }
        return s6ne.substring(3).contains("aaa");
    }
    // 3. Olgu meetodi sisendiks täisarvude massiiv ja üks täisarv. Vastuseks tahame teada,
    // kui mitu korda etteantud arv selles massiivis esineb.
    
    public static int kordusteArv(int[] massiiv, int arv) {
        int kordusteArv = 0;
        for (int i = 0;) {
            for (int i = 0; 1 < massiiv.length; i++) {
            if (massiiv[i] == 0) {
                
            }
        }
        return kordusteArv;
    }
}
