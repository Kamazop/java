import java.util.ArrayList;
import java.util.List;

public class zoppKt1 {
    public static void main(String[] args) {
        System.out.println("ÜL 7: väljund");
        ülesanne7();
        System.out.println("ÜL 6 väljund");
        ülesanne6();
        System.out.println("ÜL 8 väljund");
        ülesanne8();
    }

    public static void ülesanne7() {
        int[] massiiv = {1, 2, 2, 3, 4, 4, 5, 5, 5, 5};
        System.out.println("Tükkide arv: " + loendaTükke(massiiv));
    }

    public static void ülesanne6() {
        System.out.println(samaKaugus(2, 4, 6));
        System.out.println(samaKaugus(9, 1, 5));
        System.out.println(samaKaugus(7, 3, 2));
    }

    public static void ülesanne8() {
        List<String> sisendsõned = List.of("sdr", "erwe", "as", "erwghgh", "", "d");
        List<String> uuedSõned = keskeleTärn(sisendsõned);
        for (String sõne : uuedSõned) {
            System.out.println(sõne);
        }
    }
    // ÜL 7
    public static int loendaTükke(int[] massiiv) {
        if (massiiv.length <= 1) {
            return massiiv.length;
        }

        int tykkideArv = 0;

        if (massiiv[0] != massiiv[1]) {
            tykkideArv++;
        }

        for (int i = 1; i < massiiv.length - 1; i++) {
            if (massiiv[i] != massiiv[i - 1] && massiiv[i] != massiiv[i + 1]) {
                tykkideArv++;
            }
        }

        if (massiiv[massiiv.length - 1] != massiiv[massiiv.length - 2]) {
            tykkideArv++;
        }

        return tykkideArv;
    }
    // ÜL 6
    public static boolean samaKaugus(int a, int b, int c) {
        int kaugusAB = Math.abs(a - b);
        int kaugusBC = Math.abs(b - c);
        int kaugusAC = Math.abs(a - c);

        return kaugusAB == kaugusBC || kaugusBC == kaugusAC || kaugusAB == kaugusAC;
    }
    // ÜL 8
    public static List<String> keskeleTärn(List<String> sõned) {
        List<String> uuedSõned = new ArrayList<>();
        for (String sõne : sõned) {
            int pikkus = sõne.length();
            if (pikkus % 2 == 0) { // Paarisarvulise puhul lisab tärni
                int keskkoht = pikkus / 2;
                String uusSõne = sõne.substring(0, keskkoht) + '*' + sõne.substring(keskkoht);
                uuedSõned.add(uusSõne);
            } else { // Paaritu puhul asendab tärniga
                int keskkoht = pikkus / 2;
                String uusSõne = sõne.substring(0, keskkoht) + '*' + sõne.substring(keskkoht + 1);
                uuedSõned.add(uusSõne);
            }
        }
        return uuedSõned;
    }
}