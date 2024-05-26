package zoppT6;

import zoppT6.Soidukid.*;

import java.util.*;
import java.util.stream.Stream;

public class zoppT6 {
    public static void main(String[] args) {
        System.out.println("\nÜlesanne 1: ");
        ülesanne1();
        System.out.println("\nÜlesanne 2: ");
        ülesanne2();
        System.out.println("\nÜlesanne 3: ");
        ülesanne3();
    }

    static void ülesanne1() {
        Auto auto1 = new Auto("MAR 260");
        auto1.setKiirus(51);

        Auto auto2 = new Auto("");
        auto2.setNumber("RAM 062");
        auto2.setKiirus(49);
        auto2.määraHind(auto2.getKiirus());

        Paat paat1 = new Paat("PAA-260");
        paat1.setKiirus(9);
        paat1.setSyvis(0.4);
        paat1.määraHind(paat1.getSyvis(), paat1.getKiirus());

        Paat paat2 = new Paat("");
        paat2.setNumber("AAP-062");
        paat2.setKiirus(11);
        paat2.setSyvis(0.6);
        paat2.määraHind(paat2.getSyvis(), paat2.getKiirus());

        Lennuk lennuk1 = new Lennuk("FIN6EP");
        lennuk1.setKorgus(7000);
        lennuk1.setUlatus(500);
        lennuk1.määraHind(lennuk1.getKorgus(), lennuk1.getUlatus());

        Lennuk lennuk2 = new Lennuk("CSS124");
        lennuk2.setKorgus(4250);
        lennuk2.setUlatus(752);
        lennuk2.määraHind(lennuk2.getKorgus(), lennuk2.getUlatus());

        //int[] soidukid = {auto1.getHind(), auto2.getHind(), paat1.getHind(), paat2.getHind()};

        ArrayList<Soiduk> soidukid = new ArrayList<Soiduk>();
        soidukid.add(auto1);
        soidukid.add(auto2);
        soidukid.add(paat1);
        soidukid.add(paat2);
        soidukid.add(lennuk1);
        soidukid.add(lennuk2);
        for (Soiduk s : soidukid) s.Show();
    }

    static void ülesanne2() {
        String[] sõned = {"Jaanus", "Marek", "Martin", "Tiit", "Kaisa", "Marija", "Cristopher", "Kadri"};
        Stream<String> wordStream = Arrays.stream(sõned);
        Optional<String> lühim = wordStream.min(Comparator.comparingInt(String::length));
        System.out.print("Nendest lühim sõne on: ");
        lühim.ifPresent(System.out::println);
    }

    static void ülesanne3() {
        List<Integer> arvud = Arrays.asList(7, 15, 21, 33, 48, 59, 62, 84);
        Stream<Integer> väikseim = arvud.stream()
        .filter(number -> number < 100)
        .map(number -> number % 10);
        System.out.println("Iga arvu viimased numbrid: ");
        väikseim.forEach(System.out::println);
    }
}