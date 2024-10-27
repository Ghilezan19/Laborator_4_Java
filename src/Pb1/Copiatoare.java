package Pb1;

public class Copiatoare extends Echipamente {

    private static final long serialVersionUID = 1L;
    private int ppm;
    private int p_ton;
    private FormatCopiere fm;

    public Copiatoare(String denumire, int nr_inventar, double pret, String zona_mag, Stare s, int ppm, int p_ton,
                      FormatCopiere fm) {
        super(denumire, nr_inventar, pret, zona_mag, s);
        this.ppm = ppm;
        this.p_ton = p_ton;
        this.fm = fm;
    }

    public FormatCopiere getFm() {
        return fm;
    }

    public void setFm(FormatCopiere fm) {
        this.fm = fm;
    }
    public void setFormatA4() {
        setFm(FormatCopiere.A4);
    }

    public void setFormatA3() {
        setFm(FormatCopiere.A3);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + ppm + ", " + p_ton + ", " + fm.toString();
    }

}
