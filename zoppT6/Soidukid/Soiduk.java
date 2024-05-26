package zoppT6.Soidukid;

public abstract class Soiduk {
    String number;
    int maxKiirus;
    int hind;
    public abstract void Show();

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getKiirus() {
        return this.maxKiirus;
    }

    public void setKiirus(int kiirus) {
        this.maxKiirus = kiirus;
    }

    public int getHind() {
        return hind;
    }
    public void setHind(int hind){
        this.hind = hind;
    }
}