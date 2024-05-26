package zoppKodu5.Piimatoode;

public class Piim extends Piimatoode {
    public Piim(String nimi, double hind) {
        super(nimi, hind);
    }

    @Override
    public double getPrice(int kogus) {
        double totalPrice = super.getPrice(kogus);
        if (kogus >= 5)
            return totalPrice * 0.9;
        else
            return totalPrice;
    }
}