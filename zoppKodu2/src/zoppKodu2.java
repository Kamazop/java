import java.util.Scanner;
import java.util.Random;

public class zoppKodu2 {
    private static final Scanner skanner = new Scanner(System.in);
    private static final Random juhuslik = new Random();

    public static void main(String[] args) {
        uusMang();
    }

    // Põhiülesanne (12p):
    // On fikseeritud kaks arvu, N ja M, M<N. Laual on alguses N tikku.
    // Mängija tohib oma käigu korral võtta laualt 1 kuni M tikku (1 < M < N).
    // See tähendab, et mängija peab võtma vähemalt 1 tiku, aga mitte rohkem kui M tikku.
    // Kordamööda käies mängitakse seni, kuni laual pole ühtegi tikku.
    // Mängija, kes viimase(d) tiku(d) võttis, on võitja.
    private static void uusMang() {
        System.out.println("Tere tulemast tikumängu!");
        int N = sobivSisend("Sisestage tikkude arv millega mängu alustada (N): ");
        int M = sobivSisend("Sisestage tikkude arv mida võib maksimaalselt ühel käigul võtta (M): ");
        boolean inimeseKord = true; // Kui true alustab inimene, kui false alustab arvuti
        int allesTikud = N;

        while (allesTikud > 0) { // Kui tikke laual on rohkem kui 0 jätkatakse mängu
            System.out.println("Hetkel on laual " + allesTikud + " tikku."); // Kuvatakse mängu seis
            if (inimeseKord) {
                int inimeseKaik = teeInimeseKaik(allesTikud, M);
                allesTikud -= inimeseKaik; // vähendab allestikkude arvu inimese poolt käidud tikkude arvu võrra
                System.out.println("Inimene võttis " + inimeseKaik + " tikku.");
            } else {
                int arvutiKaik = teeArvutiKaik(allesTikud, M);
                allesTikud -= arvutiKaik;
                System.out.println("Arvuti võttis " + arvutiKaik + " tikku.");
            }
            inimeseKord = !inimeseKord;
        }

        if (inimeseKord) {
            System.out.println("Arvuti võitis!");
        } else {
            System.out.println("Sina võitsid!");
        }

        // Lisapunktid (3p):
        // Mängu lõppedes küsitakse kasutajalt, kas ta soovib veel mängida.
        // Kui soovib, siis alustatakse uut mängu.
        // M ja N ühe mängukorra jooksul ei muudeta.
        System.out.println("Kas soovite veel mängida? (jah/ei)");
        String valik = skanner.next();
        if (valik.equalsIgnoreCase("jah")) { // Kui jah siis jooksutatakse mäng uuesti
            uusMang();
        } else { // Kui ei siis sulgeb mängu ja kuvab teate
            System.out.println("Oli meeldiv sinuga mängida!");
        }
    }

    // Lisapunktid (5p):
    // Iga mängukorra alguses küsitakse kasutajalt arvude N ja M väärtust, seejuures kontrollides, kas tegemist on sobivate täisarvudega.
    // Küsimist korratakse seni, kuni saadakse tingimustele sobivad arvud.
    private static int sobivSisend(String prompt) { // Meetod, mis kontrollib sisesndi sobivust
        int input;
        do {
            System.out.print(prompt);
            while (!skanner.hasNextInt()) {
                System.out.println("Palun sisestage täisarv!");
                skanner.next();
            }
            input = skanner.nextInt();
            if (input <= 0) { // arv peab olema pos. ja suurem kui 0
                System.out.println("Arv peab olema positiivne!");
            }
        } while (input <= 0);
        return input;
    }

    private static int teeInimeseKaik(int allesTikud, int M) { // meetod, mis kontrollib mängija sisendit
        int move;
        do {
            move = sobivSisend("Sisestage tikkude arv, mida soovite võtta (1-" + Math.min(allesTikud, M) + "): ");
            if (move > Math.min(allesTikud, M)) { // kontrollib kas ületab lubatud piire, kasutades võrdlust tingimuslausega Math.min
                System.out.println("Sisestatud arv ületab lubatud piiri!");
            }
        } while (move > Math.min(allesTikud, M));
        return move;
    }

    private static int teeArvutiKaik(int allesTikud, int M) { // Meetod, mille alusel arvuti oma käigud teeb
        int voimalikudKaigud = Math.min(allesTikud, M);
        if (allesTikud % (M + 1) != 0) { // Kontrollib kas jagamisel tekib jääk
            return allesTikud % (M + 1); // Kui tekib siis jääk on arvuti käigu suurus
        } else {
            return juhuslik.nextInt(voimalikudKaigud - 1) + 1; // juhuslik arv 0-st n-ni koos veaparandusega
        }
    }
}

// Nõuded programmile:
// - Alustab inimene.
// - Inimese käigu ajal küsitakse tikkude arvu, mille kasutaja saab sisestada klaviatuurilt.
// - Sisendit tuleb kontrollida. See tähendab, et sisestatud tikkude arv peab olema täisarv ja lubatud vahemikus.
// - Kui sisend pole korrektne, korratakse sisendi küsimise protsessi.
// - Kui kasutaja on teinud korrektse käigu, on arvuti käik.
// - Arvuti teeb oma käigu ajal suvalise (random) käigu, mis vastab reeglitele. Välja arvatud juhul, kui arvuti saab ühe käiguga võita.
// - Peale arvuti käiku on jälle inimese käik.
// - Sedasi käiakse kordamööda, kuni üks mängija võidab.
// - Peale iga mängija käiku kuvatakse mänguseis (tikkude arv laual).
// - Kood peab olema mõistlikult kommenteeritud.

// Programmi osad:
// main() - põhiline loogika kordamööda käimine jms kohta.
// newGame() - alustab uut mängu.
// makeComputerMove() - arvuti teeb oma käigu. Võidukäigu olemasolu korral võidukäik, muul juhul suvaline lubatud käik. Meetod tagastab laual olevate tikkude arvu peale käiku.
// Kui laual on 10 tikku ja kutsutakse makeComputerMove() ning arvuti teeb näiteks käigu, mis võtab 3 tikku, siis see meetod peab tagastama sellisel juhul 7 (so allesjäänud tikkude arv).
// makeHumanMove(int) - etteantud numbri puhul tehakse vastava inimese käik.
