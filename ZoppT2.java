// Kõik ülesanded teha meetoditena, mmille main-meetod etteantud argumentidega välja kutsub. Pidage kinni meetodite spetsifikatsioonist. Vastused väljastatakse konsoolile.

// 1. Olgu antud täisarvude massiiv. Anda vastuseks teise ja viimase liikme korrutis. Kui massiivis on ainult 1 element, siis on vastuseks see element ja kui massiivi pikkus on 0, on vastuseks 0.
static int korrutis(int[]jada)
  {2,3,4,6}  18
  {8}  8
  {}  0
  
// 2. On antud 2 sõnet. Kui esimene lõpeb sama sümboliga, millega teine algab, on vastuseks nende ühend, kust on välja jäetud 1.sõne viimane sümbol ja 2.sõne esimene sümbol.
// Muudel juhtudel jäetakse ühendist välja ainult 2.sõne esimene sümbol. Kui 2.sõne on tühi, on vastuseks esimene sõne.
  static String kaksS6na(String s1,String s2)
  "kapsas", "sibul" - "kapsaibul"
  "tere", "hommikust" - "tereommikust"
  "tere", "" - "tere"
  
// 3. On antud täisarvude massiiv.
// Anda vastuseks tõeväärtus “true”, kui selles leidub järjestikku  kolm  järjestikust arvu, ja “false” muidu.
  static boolean kolmReas(int[] massiiv)
{2,3,3,4,4,2,3,4} - true
{1,1,3,2,1,2,2,2} - false 

  public class Main {

    public static void main(String[] args) {
        // 1. Olgu antud täisarvude massiiv. Anda vastuseks teise ja viimase liikme korrutis.
        // Kui massiivis on ainult 1 element, siis on vastuseks see element
        // ja kui massiivi pikkus on 0, on vastuseks 0.
        int[] jada1 = {2, 3, 4, 6};
        System.out.println("1. Korrutis: " + korrutis(jada1)); // Väljastab: 18
        
        int[] jada2 = {8};
        System.out.println("1. Korrutis: " + korrutis(jada2)); // Väljastab: 8
        
        int[] jada3 = {};
        System.out.println("1. Korrutis: " + korrutis(jada3)); // Väljastab: 0

        // 2. On antud 2 sõnet. Kui esimene lõpeb sama sümboliga, millega teine algab,
        // on vastuseks nende ühend, kust on välja jäetud 1.sõne viimane sümbol ja 2.sõne esimene sümbol.
        // Muudel juhtudel jäetakse ühendist välja ainult 2.sõne esimene sümbol.
        // Kui 2.sõne on tühi, on vastuseks esimene sõne.
        String s1 = "kapsas";
        String s2 = "sibul";
        System.out.println("2. Sõnade ühend: " + kaksS6na(s1, s2)); // Väljastab: kapsaibul
        
        s1 = "tere";
        s2 = "hommikust";
        System.out.println("2. Sõnade ühend: " + kaksS6na(s1, s2)); // Väljastab: tereommikust
        
        s1 = "tere";
        s2 = "";
        System.out.println("2. Sõnade ühend: " + kaksS6na(s1, s2)); // Väljastab: tere

        // 3. On antud täisarvude massiiv.
        // Anda vastuseks tõeväärtus “true”, kui selles leidub järjestikku  kolm  järjestikust arvu,
        // ja “false” muidu.
        int[] massiiv1 = {2, 3, 3, 4, 4, 2, 3, 4};
        System.out.println("3. Kas on kolm reas: " + kolmReas(massiiv1)); // Väljastab: true
        
        int[] massiiv2 = {1, 1, 3, 2, 1, 2, 2, 2};
        System.out.println("3. Kas on kolm reas: " + kolmReas(massiiv2)); // Väljastab: false
    }

    // Meetod korrutis, mis arvutab teise ja viimase liikme korrutise,
    // või tagastab ainukese elemendi või 0 vastavalt massiivi pikkusele.
    static int korrutis(int[] jada) {
        if (jada.length == 1) {
            return jada[0];
        } else if (jada.length == 0) {
            return 0;
        } else {
            return jada[1] * jada[jada.length - 1];
        }
    }

    // Meetod kaksS6na, mis ühendab kaks sõnet vastavalt esimese sõne lõpu
    // ja teise sõne alguse sümbolitele ning vastavalt ülesande tingimustele.
    static String kaksS6na(String s1, String s2) {
        if (s2.isEmpty()) {
            return s1;
        } else if (s1.charAt(s1.length() - 1) == s2.charAt(0)) {
            return s1 + s2.substring(1);
        } else {
            return s1 + s2;
        }
    }

    // Meetod kolmReas, mis kontrollib, kas massiivis leidub järjestikku kolm järjestikust arvu.
    static boolean kolmReas(int[] massiiv) {
        for (int i = 0; i < massiiv.length - 2; i++) {
            if (massiiv[i] == massiiv[i + 1] - 1 && massiiv[i] == massiiv[i + 2] - 2) {
                return true;
            }
        }
        return false;
    }
}
