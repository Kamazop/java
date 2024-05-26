package zoppKodu5.Piimatoode;

public class Juust extends Piimatoode {
    public Juust(String nimi, double hind) {
        super(nimi, hind);
    }

    @Override
    public double getPrice(int kogus) {
        double totalPrice = super.getPrice(kogus);
        if (kogus >= 3)
            return totalPrice * 0.9;
        else
            return totalPrice;
    }
}