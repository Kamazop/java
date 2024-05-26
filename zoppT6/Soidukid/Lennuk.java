package zoppT6.Soidukid;

public class Lennuk extends Soiduk {
    private int maxKorgus, lennuUlatus;

    public int getKorgus() {
        return this.maxKorgus;
    }

    public void setKorgus(int kõrgus) {
        this.maxKorgus = kõrgus;
    }

    public int getUlatus() {
        return this.lennuUlatus;
    }

    public void setUlatus(int ulatus) {
        this.lennuUlatus = ulatus;
    }

    public Lennuk(String number) {
        setNumber(number);
    }

    public Lennuk(){
        setHind(0);
    }

    public void Show(){
        System.out.println("Lennuki Number: " + getNumber() + "\t\t\t\t\tHind: " + getHind());
    }

    public void määraHind(int maxKorgus, int lennuUlatus) {
        if (maxKorgus < 20000) setHind(1000);
        else if (lennuUlatus < 5000) setHind(2500);
        else setHind(1500000);
    }
}

