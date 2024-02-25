// Programm sisaldab kolme meetodit.
import java.util.InputMismatchException;
import java.util.Scanner;
public class ZoppT3 {
        public static void main(String[]args) {
            testiTekstiV6rdsust();
            testiT2isarve();
            testiMassiiviSummat();

        }
    // Esimene meetod palub kasutajal sisestada esimese ja teise rea teksti. Konsoolile
    // väljastatakse teade, kas read on samad või mitte.
    public static void testiTekstiV6rdsust() {
            Scanner skanner = new Scanner(System.in); // Loob skanner objekti, et lugeda kasutaja sisendit

            System.out.println("Sisesta esimene tekst"); // Küsib kasutajalt esimese teksti ja
            String tekst1 = skanner.nextLine(); // salvestab muutujasse tekst1
            System.out.println("Sisesta teine tekst");
            String tekst2 = skanner.nextLine();

            if (tekst1.equals(tekst2)) { // Võrdleb muutujatesse salvestatud tekste
                System.out.println("Teksti read on samad.");
            } else {
                System.out.println("Tekstid on erinevad.");
            }
    }

    // Teine meetod palub sisestada kaks täisarvu. Kui sisestatud pole täisarvud,
    // palutakse kasutajal uuesti sisestada. Seejärel kontrollitakse, kas nende
    // arvude summa on paarisarv ja tulemus väljastatakse konsoolile koos vastava
    // teatega (Summa on/ei ole paaris).
    public static void testiT2isarve() {
            Scanner skanner = new Scanner(System.in); // Loob skanner objekti, sisendi lugemiseks
            int arv1 = 0, arv2 = 0; // Annab muutujatele väärtusteks nullid
            boolean validInput = false;

            do { // Kasutan do-while tsüklit, et küsida kasutajalt täisarvulised sisendid
                try {
                    System.out.println("Sisesta esimene täisarv.");
                    arv1 = skanner.nextInt();

                    System.out.println("Sisesta teine täisarv.");
                    arv2 = skanner.nextInt();

                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("See pole täisarv, sisesta uuesti!");
                    skanner.next(); // Puhastab puhvri
                }
            } while (!validInput);

            int sum = arv1 + arv2;
            if (sum % 2 == 0) { // Kontrollib kas kahe arvu summa on paaris, ehk jääk on 0
                System.out.println("Summa on paaris.");
            } else {
                System.out.println("Summa ei ole paaris");
            }
    }

    // Kolmas meetod palub kasutajal sisestada ühe täisarvu vahemikus 1-5. Kui sisend
    // pole sobiv, küsitakse uus. Sobiva arvu korral luuakse täisarvude massiiv,
    // mille pikkus on sisestatud arv. Kasutajal palutakse sisestada vastav arv
    // täisarve. Kui pole sobivad, küsitakse uuesti. Lõpuks väljastatakse konsoolile
    // arvud massiivis ja nende summa.
    public static void testiMassiiviSummat() {
            Scanner skanner = new Scanner(System.in);

            int t = 0;
            boolean validInput = false;

            System.out.println("Sisesta täisarv vahemikus 1-5.");
            t = skanner.nextInt();

        do {
            try {
                System.out.println("Sisesta täisarv vahemikus 1-5");
                t = skanner.nextInt();

                if (t < 1 || t > 5) {
                    throw new IllegalArgumentException("Arv peab olema vahemikus 1-5!");
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Vale tüüpi arv! Palun sisesta täisarv.");
                skanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);

        int[] array = new int[t];
        for (int i = 0; i < t; i++) {
            validInput = false;
            do {
                try {
                    System.out.println("Sisesta täisarv massiivi jaoks: ");
                    array[i] = skanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Vale tüüpi arv! Palun sisesta täisarv.");
                    skanner.next(); // puhastab puhvri
                }
            } while (!validInput);
        }

        System.out.println("Massiivis olevad arvud:");
        for (int arv : array) {
            System.out.print(arv + " ");
        }

        int sum = 0;
        for (int arv : array) {
            sum += arv;
        }
        System.out.println("\nArvude summa: " + sum);
    }
}
