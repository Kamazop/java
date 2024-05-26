package zoppKodu5;
import zoppKodu5.Piimatoode.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Ülesanne 1: Andmekonteiner inimeste loomiseks
        List<Person> inimesed = new ArrayList<>();
        inimesed.add(new Person("Artur", "Aas", 1996));
        inimesed.add(new Person("Tauri", "Tamm", 1985));
        inimesed.add(new Person("Jaan", "Juurikas", 1978));
        inimesed.add(new Person("Kati", "Kask", 1991));
        inimesed.add(new Person("Karl", "Kask", 1999));
        inimesed.add(new Person("Mati", "Murakas", 1979));
        inimesed.add(new Person("Liisa", "Lepp", 2000));
        inimesed.add(new Person("Kaido", "Kartul", 1960));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta perekonnanimi:");
        String sisend = scanner.nextLine().trim();

        // Sisendikontroll
        if (!sisend.matches("[a-zA-Z]+")) {
            System.out.println("Sisestatud perekonnanimi sisaldab keelatud sümboleid.");
        } else {
            boolean leitud = false;
            for (Person isik : inimesed) {
                if (isik.getPerekonnanimi().equalsIgnoreCase(sisend)) {
                    System.out.println("Leitud isikud perekonnanimega '" + sisend + "':");
                    System.out.println(isik.getEesnimi() + ", sündinud " + isik.getSünniaasta());
                    leitud = true;
                }
            }
            if (!leitud) {
                System.out.println("Sellist perekonnanime ei leitud.");
            }
            System.out.println();
        }

        // Ülesanne 2: Toodete lisamine
        Juust eestiJuust = new Juust("Eesti juust", 6.5);
        Juust hollandiJuust = new Juust("Hollandi juust", 7.0);
        Piim täispiim = new Piim("Täispiim", 1.2);
        Piim kakaogaPiim = new Piim("Kakaoga piim", 1.5);
        Kohupiim maitsestatudKohupiim = new Kohupiim("Maitsestatud kohupiim", 2.0);
        Kohupiim kohupiim = new Kohupiim("Kohupiim", 1.8);
        Kohupiim rosinategakohupiim = new Kohupiim("Rosinatega kohupiim", 1.9);

        // Arvete loomine
        Arve arve1 = new Arve("Klient 1");
        arve1.lisa(eestiJuust, 3);
        arve1.lisa(täispiim, 2);
        arve1.lisa(kohupiim, 2);

        Arve arve2 = new Arve("Klient 2");
        arve2.lisa(hollandiJuust, 5);
        arve2.lisa(kakaogaPiim, 3);

        Arve arve3 = new Arve("Klient 3");
        arve3.lisa(maitsestatudKohupiim, 2);
        arve3.lisa(kohupiim, 4);
        arve3.lisa(rosinategakohupiim, 2);

        // Arvete väljatrükk
        arve1.maksa();
        System.out.println();
        arve2.maksa();
        System.out.println();
        arve3.maksa();
    }
}

