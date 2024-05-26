package zoppT4;

import java.io.*;

//  Teha failid nimedega in1.txt (kus on vähemalt 5 rida teksti) ja in2.txt
//  (kus on maksimaalselt 3 rida teksti).
//  Teie programmi ülesanne on proovida välja trükkida mõlema faili 4. rida,
//  ja kui seda pole, anda veateade “Nii palju ridu pole!".
public class zoppT4 {

    public static void main(String[] args) throws IOException {
        loeNeljasRida("src/zoppT4/in1");
        loeNeljasRida("src/zoppT4/in2");
        koguFailJaTaisarvud("src/zoppT4/in3", "src/zoppT4/out");
        valjundFailiSisu("src/zoppT4/out");
    }
    public static void loeNeljasRida(String failiNimi) { // Meetod loeb failist rida-realt ja konsooli annab vaid 4. read
        try (BufferedReader reader = new BufferedReader(new FileReader(failiNimi))) { // Vaja lugeda reakaupa siis kasutasin BufferedReaderit
            String rida;
            int loenda = 0; // Annan loendamise alguseks väärtuse 0
            while ((rida = reader.readLine()) != null) { // Loendab ridu 0-st kuni jõuab 4. reani
                loenda++;
                if (loenda == 4) { // Kui jõuab 4. reani siis tagastab konsooli väljundi
                    System.out.println("Neljas rida failis " + failiNimi + ": " + rida);
                    return;
                }
            }
            System.out.println("Nii palju ridu pole!"); // Kui failis on vähem kui 4 rida siis tagastab veateate
        } catch (IOException e) {
            System.err.println("Faili lugemisel tekkis viga: " + e.getMessage()); // Kui tekib faili lugedes viga siis tagastab ka vastav veateade
            e.printStackTrace();
        }
    }

    //  Teha fail nimega in3.txt. Programmi ülesanne on
    //- välja trükkida kogu faili sisu,
    //- leida sellest kõik täisarvud ning kirjutada need faili nimega out.txt,
    //- out.txt välja trükkida.
    public static void koguFailJaTaisarvud(String sisendFail, String valjundFail) throws IOException { // Meetod loeb sisend failist kõik täisarvud ja kirjutab need väljund faili
        BufferedReader reader = new BufferedReader(new FileReader(sisendFail)); // Loon buffri voo sisendfaili lugemiseks
        BufferedWriter writer = new BufferedWriter(new FileWriter(valjundFail)); // sama ka väljundifaili kirjutamiseks
        String rida;
        while ((rida = reader.readLine()) != null) { // Loeb sisend faili ridu
            String[] s6nad = rida.split("\\s+"); // Jaotab sõnad tühikute järgi
            for (String s : s6nad) { // Käib läbi kõik s6nad
                try {
                    int number = Integer.parseInt(s);
                    writer.write(Integer.toString(number)); // Kirjutab leitud täisarvu väljundfaili
                    writer.newLine();
                } catch (NumberFormatException e) { // Ignoreerib mitte täisarvulisi väärtusi
                }
            }
        }
        reader.close(); // Sulgeb lugemiseks ja kirjutamiseks loodud buffri vood
        writer.close();
    }

    public static void valjundFailiSisu(String valjundFailiNimi) throws IOException { // Selle meetodiga prindin konsooli out.txt faili sisu
        BufferedReader reader = new BufferedReader(new FileReader(valjundFailiNimi)); // Taaskord loon buffri voo lugemiseks
        String rida;
        System.out.println("Faili " + valjundFailiNimi + " sisu:"); // Tagastab konsooli out.txt sisu
        while ((rida = reader.readLine()) != null) {
            System.out.println(rida);
        }
        reader.close(); // Suleb lugemis buffri voo
    }
}