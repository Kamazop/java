package zoppKodu5.Piimatoode;

public class Piimatoode {
    protected String nimi;
    protected double hind;

    public Piimatoode(String nimi, double hind) {
        this.nimi = nimi;
        this.hind = hind;
    }

    public double getHind() {
        return hind;
    }

    public String getNimi() {
        return nimi;
    }

    public double getPrice(int kogus) {
        return hind * kogus;
    }
}