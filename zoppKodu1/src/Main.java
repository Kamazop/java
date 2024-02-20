// Iga ülesande lahendus olgu kirjas omaette meetodis, mida saab main-meetodist välja
// kutsuda. Main-meetodis on deklareeritud muutujad, mis antakse igale meetodile
// argumendiks ette. Tulemused trükitakse konsoolile.

public class zopp1Kodu {
    public static void main(String[] args) {
        System.out.println("1. " + symbolidKeskel("abcba"));
        System.out.println("2. " + sisaldabAlams6ne("aabaaacda"));
        System.out.println("3. " + kordusteArv(new int[]{3, 2, 1, 4, 55, 2, 1, 9, 0, 2}, 2));
        String[] s6ned = {"hp", "asus", "lenovo", "dell", "rog"};
        kolmandaJaViimaseVahetus(s6ned);
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
            int keskmine = pikkus / 2; //  leiab keskmised sümbolid substringi kasutades
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
        if (s6ne.length() < 4) { // Kontrollib sõne pikkust
            return false; // Alamsõne ei saa olla
        }
        return (s6ne.charAt(1) == 'a' && s6ne.charAt(2) == 'a' && s6ne.charAt(3) == 'a') ||
                (s6ne.length() >= 6 && s6ne.charAt(3) == 'a' && s6ne.charAt(4) == 'a' && s6ne.charAt(5) == 'a');
    }

    // 3. Olgu meetodi sisendiks täisarvude massiiv ja üks täisarv. Vastuseks tahame teada,
    // kui mitu korda etteantud arv selles massiivis esineb.

    public static int kordusteArv(int[] massiiv, int arv) {
        int kordusteArv = 0; // Algväärtuseks 0
        for (int k : massiiv) { // Käib läbi massiivi kõik elemendid,
            if (k == arv) { // kõikjal kus elemendi k väärtus sama mis sisendis olev arv,
                kordusteArv++; // tõstab kordusteArvu +1 võrra
            }
        }
        return kordusteArv; // Väljund
    }

    // 4. Olgu meetodi sisendiks sõnede massiiv. Tulemuseks tahame massiivi, mille tagant
    // kolmas ja viimane element on ära vahetatud – juhul kui massiivis on vähemalt 3
    // elementi. Kui massiiv on liiga lühike, trükitakse konsoolile vastav teade.

    public static void kolmandaJaViimaseVahetus(String[] massiiv) {
        if (massiiv.length < 3) { // Kontrollib massiivi pikkust
            System.out.println("Liiga lühike massiiv");
        } else {
            String temp = massiiv[massiiv.length - 3]; // Salvestab kolmanda elemendi tempi
            massiiv[massiiv.length - 3] = massiiv[massiiv.length - 1]; // Vahetab kolmanda elemendi viimasega
            massiiv[massiiv.length - 1] = temp; // Viimase elemndi vahetab tempi salvestatud kolmanda elemendiga
            for (String n : massiiv) {
                System.out.println(n); // Prindib vahetatud elementidega massiivi
            }
        }
    }
}
