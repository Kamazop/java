import java.io.*;

//  Teha failid nimedega in1.txt (kus on vähemalt 5 rida teksti) ja in2.txt
//  (kus on maksimaalselt 3 rida teksti).
//  Teie programmi ülesanne on proovida välja trükkida mõlema faili 4. rida,
//  ja kui seda pole, anda veateade “Nii palju ridu pole!".
public class zoppT4 {

    public static void main(String[] args) throws IOException {
        loeNeljasRida("src/in1");
        loeNeljasRida("src/in2");
        koguFailJaTaisarvud("src/in3", "src/out");
        valjundFailiSisu("src/out");
    }
    public static void loeNeljasRida(String failiNimi) {
        try (BufferedReader reader = new BufferedReader(new FileReader(failiNimi))) { // Vaja lugeda reakaupa siis kasutasin BufferedReaderit
            String rida;
            int count = 0;
            while ((rida = reader.readLine()) != null) { // Loendab ridu 0-st kuni jõuab 4. readni
                count++;
                if (count == 4) { // Kui jõuab 4. reani siis tagastab konsooli stringi
                    System.out.println("Neljas rida failis " + failiNimi + ": " + rida);
                    return;
                }
            }
            System.out.println("Nii palju ridu pole!");
        } catch (IOException e) {
            System.err.println("Faili lugemisel tekkis viga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //  Teha fail nimega in3.txt. Programmi ülesanne on
    //- välja trükkida kogu faili sisu,
    //- leida sellest kõik täisarvud ning kirjutada need faili nimega out.txt,
    //- out.txt välja trükkida.
    public static void koguFailJaTaisarvud(String sisendFail, String valjundFail) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(sisendFail));
        BufferedWriter writer = new BufferedWriter(new FileWriter(valjundFail));
        String rida;
        while ((rida = reader.readLine()) != null) {
            String[] words = rida.split("\\s+");
            for (String word : words) {
                try {
                    int number = Integer.parseInt(word);
                    writer.write(Integer.toString(number));
                    writer.newLine();
                } catch (NumberFormatException e) {
                    // Ignore non-integer values
                }
            }
        }
        reader.close();
        writer.close();
    }

    public static void valjundFailiSisu(String valjundFailiNimi) throws IOException { // Selle meetodiga prindin konsooli out.txt faili sisus olevad täisarvud
        BufferedReader reader = new BufferedReader(new FileReader(valjundFailiNimi));
        String rida;
        System.out.println("Faili " + valjundFailiNimi + " sisu:");
        while ((rida = reader.readLine()) != null) {
            System.out.println(rida);
        }
        reader.close();
    }
}



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


public static void readIntegersAndWriteToFile(String inputFileName, String outputFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                try {
                    int number = Integer.parseInt(word);
                    writer.write(Integer.toString(number));
                    writer.newLine();
                } catch (NumberFormatException e) {
                    // Ignore non-integer values
                }
            }
        }
        reader.close();
        writer.close();
    }

    // Meetod faili sisu väljatrükiks
    public static void printFileContent(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        System.out.println("Faili " + fileName + " sisu:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}

import java.io.*;

//  Teha failid nimedega in1.txt (kus on vähemalt 5 rida teksti) ja in2.txt
//  (kus on maksimaalselt 3 rida teksti).
//  Teie programmi ülesanne on proovida välja trükkida mõlema faili 4. rida,
//  ja kui seda pole, anda veateade “Nii palju ridu pole!".
public class zoppT4 {

    public static void main(String[] args) throws IOException {
        // Käivitame meetodi loeNeljasRida mõlema faili jaoks
        loeNeljasRida("src/in1");
        loeNeljasRida("src/in2");
        // Käivitame meetodi koguFailJaTaisarvud sisendfaili ja väljundfaili nimedega
        koguFailJaTaisarvud("src/in3", "src/out");
        // Käivitame meetodi valjundFailiSisu väljundfaili sisu trükkimiseks konsooli
        valjundFailiSisu("src/out");
    }

    // Meetod loeb failist rida-realt ja trükib välja 4. rea.
    public static void loeNeljasRida(String failiNimi) {
        try (BufferedReader reader = new BufferedReader(new FileReader(failiNimi))) {
            String rida;
            int count = 0;
            // Loeme faili rida-realt
            while ((rida = reader.readLine()) != null) {
                count++;
                // Kui oleme jõudnud neljandani, prindime selle välja
                if (count == 4) {
                    System.out.println("Neljas rida failis " + failiNimi + ": " + rida);
                    return;
                }
            }
            // Kui neljandat rida ei leitud, prindime vastava veateate
            System.out.println("Nii palju ridu pole!");
        } catch (IOException e) {
            // Kui tekib viga faili lugemisel, prindime veateate koos veateatega
            System.err.println("Faili lugemisel tekkis viga: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Meetod loeb failist kõik täisarvud ning kirjutab need teise faili.
    public static void koguFailJaTaisarvud(String sisendFail, String valjundFail) throws IOException {
        // Avame sisendfaili lugemiseks ja väljundfaili kirjutamiseks vajalikud vooged
        BufferedReader reader = new BufferedReader(new FileReader(sisendFail));
        BufferedWriter writer = new BufferedWriter(new FileWriter(valjundFail));
        String rida;
        // Loeme sisendfailist ridu, et leida täisarvud
        while ((rida = reader.readLine()) != null) {
            // Jaga rida sõnadeks tühikute järgi
            String[] words = rida.split("\\s+");
            // Käime läbi kõik sõnad
            for (String word : words) {
                try {
                    // Proovime teisendada sõna täisarvuks
                    int number = Integer.parseInt(word);
                    // Kirjutame täisarvu väljundfaili ja lisame uue rea
                    writer.write(Integer.toString(number));
                    writer.newLine();
                } catch (NumberFormatException e) {
                    // Ignoreerime mittetäisarvulisi väärtusi
                }
            }
        }
        // Sulgeme faili lugemise ja kirjutamise vooged
        reader.close();
        writer.close();
    }

    // Meetod trükib välja teise faili sisu.
    public static void valjundFailiSisu(String valjundFailiNimi) throws IOException {
        // Avame väljundfaili lugemiseks
        BufferedReader reader = new BufferedReader(new FileReader(valjundFailiNimi));
        String rida;
        // Trükime väljundfaili sisu konsooli
        System.out.println("Faili " + valjundFailiNimi + " sisu:");
        while ((rida = reader.readLine()) != null) {
            System.out.println(rida);
        }
        // Sulgeme faili lugemise vooga
        reader.close();
    }
}
