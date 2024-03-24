public class Zopp2 {
    public static void main(String[] args) {
        int a = 13;
        int b = 30;

        if (a % 3 == 0){ //Kontrollin kas esimene arv jagub 3-ga
            System.out.println("True");
        } else if (b % 3 == 0){//teen sama teise arvuga
            System.out.println("True");
        } else { //ehk siis kui ei jagu kumbi 3-ga siis on tulemuseks väär
            System.out.println("False");
        }
    }
}
/*
Tunniülesanne 1

2. On antud kaks täisarvu (muutujat). Väljastada tõeväärtus “true”, kui vähemalt üks
jagub kolmega, ja muidu “false”.
Nt. 13 ja 32 ==> vastuseks “false”
 25 ja 135 ==> vastuseks “true”
 */
