package zoppT6.Soidukid;

public class Paat extends Soiduk {
    private Double syvis;

    public Double getSyvis() {
        return this.syvis;
    }

    public void setSyvis(Double syvis) {
        this.syvis = syvis;
    }

    public Paat(String number) {
        setNumber(number);
    }

    public Paat() {
        setHind(0);
    }

    public void Show() {
        System.out.println("Paadi Number: " + getNumber() + "\t\tKiirus: " + getKiirus() + "\tHind: " + getHind());
    }

    public void määraHind(Double syvis, int maxKiirus) {
        if (syvis < 0.5) setHind(100);
        else if (maxKiirus < 10) setHind(300);
        else setHind(1500);
    }
}