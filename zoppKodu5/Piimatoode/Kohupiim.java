package zoppKodu5.Piimatoode;

public class Kohupiim extends Piimatoode {
    public Kohupiim(String nimi, double hind) {
        super(nimi, hind);
    }

    @Override
    public double getPrice(int kogus) {
        double totalPrice = super.getPrice(kogus);
        if (kogus >= 2)
            return totalPrice * 0.9;
        else
            return totalPrice;
    }
}