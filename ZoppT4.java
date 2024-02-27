import java.io.*;

public class FileHandlingExample {

    public static void main(String[] args) {
        // Ülesanne 1: proovida välja tükkida mõlema faili 4. rida
        readFourthLine("in1.txt");
        readFourthLine("in2.txt");

        // Ülesanne 2: väljatrükkida kogu faili sisu, leida täisarvud ja kirjutada need out.txt faili
        processFile("in3.txt");
    }

    // Meetod faili neljanda rea lugemiseks ja väljastamiseks
    public static void readFourthLine(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                count++;
                if (count == 4) {
                    System.out.println("Neljas rida failis " + fileName + ": " + line);
                    return;
                }
            }
            System.out.println("Nii palju ridu pole failis " + fileName + "!");
        } catch (IOException e) {
            System.err.println("Faili lugemisel ilmnes viga: " + e.getMessage());
        }
    }

    // Meetod faili töötlemiseks vastavalt ülesandele 2
    public static void processFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // väljastame kogu faili sisu
                String[] words = line.split("\\s+");
                for (String word : words) {
                    try {
                        int number = Integer.parseInt(word);
                        writer.write(number + "\n"); // kirjutame täisarvu out.txt faili
                    } catch (NumberFormatException ignored) {
                        // Kui sõna ei ole täisarv, jätkame järgmise sõnaga
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failide töötlemisel ilmnes viga: " + e.getMessage());
        }
        // out.txt faili sisu väljastamine
        System.out.println("\nout.txt sisu:");
        try (BufferedReader reader = new BufferedReader(new FileReader("out.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Faili lugemisel ilmnes viga: " + e.getMessage());
        }
    }
}
