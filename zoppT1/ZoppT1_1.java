package zoppT1;

import java.util.Arrays;

public class ZoppT1_1 {
    public static void main(String[] args) {
        int[] arvud = {8, 2, 16}; //Panen arvud massiivi
        Arrays.sort(arvud); //sorteerin arvud väiksemast suuremaks
        System.out.println(arvud[0]); // prindin konsooli esimese ja teise väärtuse, mis on kõige väiksemad väärtused
        System.out.println(arvud[1]);
    }
}

/*
Tunniülesanne 1

1. On antud kolm erinevat täisarvu (muutujat). Väljastada neist kaks väiksemat. Nt
kui arvud on 8, 2 ja 16, siis väljastatakse 8 ja 2.
 */