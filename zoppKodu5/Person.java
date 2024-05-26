package zoppKodu5;

public class Person {
    private String eesnimi;
    private String perekonnanimi;
    private int sünniaasta;

    public Person(String eesnimi, String perekonnanimi, int sünniaasta) {
        this.eesnimi = eesnimi;
        this.perekonnanimi = perekonnanimi;
        this.sünniaasta = sünniaasta;
    }

    public String getPerekonnanimi() {
        return perekonnanimi;
    }

    public String getEesnimi() {
        return eesnimi;
    }

    public int getSünniaasta() {
        return sünniaasta;
    }
}