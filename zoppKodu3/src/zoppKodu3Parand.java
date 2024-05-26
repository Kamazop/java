package zoppKodu3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Kalad said püütud, sisendfailist ei saanud rida eemaldada, sest otsitavas Stringis oli trükiviga ja olin tõesti unustanud lisada rea, mis kahe sama sageduse puhul võrdlust teeks */
/* Rida 40 on lisatud funktsioon */
public class zoppKodu3 {

    public static void main(String[] args) {
        String tekst = "The years were 1777,1799,1997,1998 and 2007!!!!";
        char kõigeSagedaminiEsinev = leiaKõigeSagedasemNumber(tekst);
        System.out.println("Kõige sagedamini esinev number: " + kõigeSagedaminiEsinev);
        String eemaldatudTekst = eemaldaKõigeSagedasemNumber(tekst, kõigeSagedaminiEsinev);
        String asendaPunktiga = eemaldaMitteASCII(eemaldatudTekst);
        // Esimese ül väljund
        System.out.println("Eemaldatud tekst: " + asendaPunktiga);

        // Teise ül meetodite välja kutsumiseks
        convert("src/zoppKodu3/inimesed.txt", "src/zoppKodu3/valjund1.txt", "src/zoppKodu3/valjund2.txt");
        eemaldaRida("src/zoppKodu3/inimesed.txt", "81234442345|Kask|Joosep|300"); // Näiteks eemaldame selle rea
    }
    static char leiaKõigeSagedasemNumber(String tekst) {
        if (!tekst.matches(".*\\d+.*")) {
            System.out.println("Tekstis pole numbreid.");
            return ' ';
        }

        Map<Character, Integer> sagedused = new HashMap<>();
        for (char c : tekst.toCharArray()) {
            if (Character.isDigit(c)) {
                sagedused.put(c, sagedused.getOrDefault(c, 0) + 1); // Mapis number on juba esinenud siis tõstetakse vastava chari sagedust ühe võrra
            }
        }

        // Leiab kõige sagedamini esineva numbri
        char kõigeSagedaminiEsinev = ' ';
        int maxSagedus = 0;
        for (char c : sagedused.keySet()) { // Tsükkel, kus map võtmete hulgast käiakse iga tähemärk läbi ja tagastatakse char tüüpi võtmed
            int sagedus = sagedused.get(c); // Sagedus muutujale määratakse sagedus väärtus, mis on mapist võetud vastava sümboli sagedus
            if (sagedus > maxSagedus || (sagedus == maxSagedus && c > kõigeSagedaminiEsinev)) { // Kontroll, kas võrreldav sagedus on suurem kui hetkel suurim sagedus, pidades arvesse numbri suurusjärku
                maxSagedus = sagedus; // Määrab uueks väärtuseks, kontrollitud sageduse
                kõigeSagedaminiEsinev = c;
            }
        }

        return kõigeSagedaminiEsinev;
    }

    // Meetod eemaldab tekstist kõige sagedamini esineva numbri
    static String eemaldaKõigeSagedasemNumber(String tekst, char symbol) {
        StringBuilder sb = new StringBuilder(); // Loob StringBuilder-i objekti
        for (char c : tekst.toCharArray()) { // Teisendab sisendi tähemärkide massiiviks
            if (Character.isDigit(c) && c == symbol) { // Kas kõigeSagedaminiEsinev on sama, mis sümbol
                continue;
            } else {
                sb.append(c); // Kui char pole number, lisatakse sb objekti
            }
        }
        return sb.toString();
    }

    static String eemaldaMitteASCII(String tekst) {
        return tekst.replaceAll("[^a-zA-Z0-9\\s]", "."); // Asendab sümbolid punktiga
    }

    static void convert(String sisendfail, String valjundfail1, String valjundfail2) { // Meetod teisendab sisendfaili andmed vajalikule kujule
        try (BufferedReader br = new BufferedReader(new FileReader(sisendfail));
             BufferedWriter bw1 = new BufferedWriter(new FileWriter(valjundfail1));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(valjundfail2))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] andmed = line.split("\\|");
                if ((andmed.length == 4) && onSobiv(andmed[1]) && onSobiv(andmed[2]) && onSobivPalk(andmed[3]) && onSobivId(andmed[0])) { // Kontrollib, kas rida sisaldab õiget arvu osi
                    bw1.write("Perekonnanimi: " + andmed[1] + "\n");
                    bw1.write("Eesnimi: " + andmed[2] + "\n");
                    bw1.write("Isikukood: " + andmed[0] + "\n");
                    bw1.write("Palk: " + andmed[3] + "\n\n");
                } else {
                    bw2.write(line + "\n"); // Kirjutab ebakorrektseid ridu teise väljundfaili
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void eemaldaRida(String sisendfail, String otsitav) {
        try (BufferedReader br = new BufferedReader(new FileReader(sisendfail)); // Sisendfaili lugemiseks
             BufferedWriter bw = new BufferedWriter(new FileWriter(sisendfail + "_tmp"))) { // Faili kirjutamiseks

            String line; // Hoiustab iga rea sisu sisendfailist
            while ((line = br.readLine()) != null) { // Iga rida sisendfailist
                if (!line.equals(otsitav)) { // Kontrollib kas loetav rida ei ole sama, mida otsitakse
                    bw.write(line + "\n"); // Kirjutab tmp faili
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File originaal = new File(sisendfail); // Loob originaalfaili objekti
        File tmp = new File(sisendfail + "_tmp"); // ja ajutise faili objekti, et need hiljem asendada
        if (originaal.delete() && tmp.renameTo(originaal)) {
            System.out.println("Rida eemaldatud.");
        } else {
            System.out.println("Rida ei saanud eemaldada.");
        }
    }

    private static boolean onSobiv(String nimi) { // Meetod kontrollib, kas nimi ja perekonna nimi ei sisalda numbreid
        return !nimi.matches(".*\\d.*");
    }

    private static boolean onSobivPalk(String palk) { // Meetod kontrollib, kas palk sisaldab vaid numbreid
        return palk.matches(".*\\d.*");
    }

    private static boolean onSobivId(String id) { // Meetod kontrollib, kas isikukood on õige pikkusega ja koosneb ainult numbritest
        return id.length() == 11 && id.matches("\\d+");
    }
}
