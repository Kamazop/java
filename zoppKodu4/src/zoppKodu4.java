package zoppKodu4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class zoppKodu4 {
    public static void main(String[] args) {
        // 1. Luua hulk words ja leida kõik tekstis esinevad sõnad
        Set<String> words = new LinkedHashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/zoppKodu4/sisend.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+|,\\s*|\\.\\s*|\\?\\s*|!\\s*");
                for (String token : tokens) {
                    words.add(token.toLowerCase());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("1. Tekstis esinevad sõnad:");
        System.out.println(words);

        // 2. Luua kujutis letters ja leida tähtede k, p, t, r, s esinemissagedus
        Map<Character, Integer> letters = new TreeMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/zoppKodu4/sisend.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                for (char c : line.toCharArray()) {
                    if (c == 'k' || c == 'p' || c == 't' || c == 'r' || c == 's') {
                        letters.put(c, letters.getOrDefault(c, 0) + 1);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n2. Tähtede k, p, t, r, s esinemissagedus tekstis:");
        letters.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // 3. Luua list, mis koosneb tähega r ja s algavatest sõnadest
        List<String> resultList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/zoppKodu4/sisend.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+|,\\s*|\\.\\s*|\\?\\s*|!\\s*");
                for (String token : tokens) {
                    String word = token.toLowerCase();
                    if ((word.startsWith("r") || word.startsWith("s")) && !resultList.contains(word)) {
                        resultList.add(word);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(resultList);
        System.out.println("\n3. Sõnad, mis algavad tähega r või s:");
        System.out.println(resultList);

        // 4. Omal valikul konteiner - Leida ja väljastada sageduse järjekorras viis kõige sagedasemat r või s tähega algavat sõna
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/zoppKodu4/sisend.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\s+|,\\s*|\\.\\s*|\\?\\s*|!\\s*");
                for (String token : tokens) {
                    String word = token.toLowerCase();
                    if ((word.startsWith("r") || word.startsWith("s"))) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFrequency.entrySet());
        sortedWords.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("\n4. Omal valikul konteiner - Viis kõige sagedasemalt esinevat r või s tähega algavat sõna:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + ": " + sortedWords.get(i).getValue() + " korda");
        }
    }
}
