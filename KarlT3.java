Tunniülesanne 3.
Programm sisaldab kolme meetodit.
1. Meetod palub kasutajal sisestada esimese ja teise rea teksti. Konsoolile
väljastatakse teade, kas read on samad või mitte.
2. Meetod palub sisestada kaks täisarvu. Kui sisestatud pole täisarvud,
palutakse kasutajal uuesti sisestada. Seejärel kontrollitakse, kas nende
arvude summa on paarisarv ja tulemus väljastatakse konsoolile koos vastava
teatega (Summa on/ei ole paaris).
3. Meetod palub kasutajal sisestada ühe täisarvu vahemikus 1-5. Kui sisend
pole sobiv, küsitakse uus. Sobiva arvu korral luuakse täisarvude massiiv,
mille pikkus on sisestatud arv. Kasutajal palutakse sisestada vastav arv
täisarve. Kui pole sobivad, küsitakse uuesti. Lõpuks väljastatakse konsoolile
arvud massiivis ja nende summa. 

  import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Esimese meetodi test
        testStringEquality();

        // Teise meetodi test
        testEvenSum();

        // Kolmanda meetodi test
        testArraySum();
    }

    // Esimene meetod
    public static void testStringEquality() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sisesta esimene tekst: ");
        String text1 = scanner.nextLine();

        System.out.println("Sisesta teine tekst: ");
        String text2 = scanner.nextLine();

        if (text1.equals(text2)) {
            System.out.println("Read on samad.");
        } else {
            System.out.println("Read ei ole samad.");
        }
    }

    // Teine meetod
    public static void testEvenSum() {
        Scanner scanner = new Scanner(System.in);

        int number1 = 0, number2 = 0;
        boolean validInput = false;

        do {
            try {
                System.out.println("Sisesta esimene täisarv: ");
                number1 = scanner.nextInt();

                System.out.println("Sisesta teine täisarv: ");
                number2 = scanner.nextInt();
                
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Vale tüüp! Palun sisesta täisarv.");
                scanner.next(); // puhastab puhvri
            }
        } while (!validInput);

        int sum = number1 + number2;
        if (sum % 2 == 0) {
            System.out.println("Summa on paaris.");
        } else {
            System.out.println("Summa ei ole paaris.");
        }
    }

    // Kolmas meetod
    public static void testArraySum() {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        boolean validInput = false;

        do {
            try {
                System.out.println("Sisesta täisarv vahemikus 1-5: ");
                n = scanner.nextInt();
                
                if (n < 1 || n > 5) {
                    throw new IllegalArgumentException("Arv peab olema vahemikus 1-5.");
                }
                
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Vale tüüp! Palun sisesta täisarv.");
                scanner.next(); // puhastab puhvri
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            validInput = false;
            do {
                try {
                    System.out.println("Sisesta täisarv massiivi jaoks: ");
                    array[i] = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Vale tüüp! Palun sisesta täisarv.");
                    scanner.next(); // puhastab puhvri
                }
            } while (!validInput);
        }

        System.out.println("Massiivis olevad arvud:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("\nArvude summa: " + sum);
    }
}
