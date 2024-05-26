package zoppKodu5;
import zoppKodu5.Piimatoode.*;
import java.text.DecimalFormat;
import java.util.*;

public class Arve {
    private static int järgmineArveNr = 1;
    private String klient;
    private Map<Piimatoode, Integer> ostud;

    public Arve(String klient) {
        this.klient = klient;
        this.ostud = new HashMap<>();
    }

    public void lisa(Piimatoode toode, int kogus) {
        ostud.put(toode, ostud.getOrDefault(toode, 0) + kogus);
    }

    public double leiaKoguSumma() {
        double summa = 0;
        for (Map.Entry<Piimatoode, Integer> entry : ostud.entrySet()) {
            Piimatoode toode = entry.getKey();
            int kogus = entry.getValue();
            summa += toode.getPrice(kogus);
        }
        return summa;
    }

    public int leiaArveNr() {
        return järgmineArveNr++;
    }

    public void maksa() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Arve number: " + leiaArveNr());
        System.out.println("Tellija: " + klient);
        System.out.println("Tellitud kaubad:");
        for (Map.Entry<Piimatoode, Integer> entry : ostud.entrySet()) {
            Piimatoode toode = entry.getKey();
            int kogus = entry.getValue();
            System.out.println("- " + toode.getNimi() + ", kogus: " + kogus + ", hind: " + toode.getHind());
        }
        System.out.println("Kogusumma: " + df.format(leiaKoguSumma()));
    }
}

