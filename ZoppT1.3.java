public class Zopp3 {
    public static void main(String [] args){
        int x = 4; //Algväärtused x, y, z
        int y = 8;
        int z = 7;
        int count = 0;

        while (count < 5 && y <= 50000) {
            x = x * 2 + y;
            y = x + y + z;
            count++;
        }
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        if (y > 50000) { //Võrdlus kas y ületas ette antud arvu
            System.out.println("y ületas arvu 50000.");
        } else {
            System.out.println("Töö peatus 5 korra järel.");
        }
    }
}

/*
Tunniülesanne 1

3. On antud kolm täisarvu x, y ja z. Arvutage 5 korda või senikaua, kuni y ei ületa arvu
50000, muutujatele x ja y uus väärtus eeskirja järgi:
x = x * 2 + y
y = x + y + z (esmalt x ja seejärel y).
Tulemuseks väljastatakse saadud arv ja teade, kas töö peatus 5 korra järel või arvu
50000 ületamise järel.
 */
