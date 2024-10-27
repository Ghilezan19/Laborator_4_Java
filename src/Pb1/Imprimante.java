package Pb1;

public class Imprimante extends Echipamente {

    private static final long serialVersionUID = 1L;
    private int ppm;
    private String rezolutie;
    private int p_car;
    private ModScriere ms;

    public Imprimante(String denumire, int nr_inventar, double pret, String zona_mag, Stare s, int ppm, String rezolutie,
                      int p_car, ModScriere ms) {
        super(denumire, nr_inventar, pret, zona_mag, s);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.ms = ms;
    }

    public ModScriere getMs() {
        return ms;
    }

    public void setMs(ModScriere ms) {
        this.ms = ms;
    }

    public void tiparireAlbNegru() {
        ms = ModScriere.albnegru;
    }

    public void tipatireColor() {
        ms = ModScriere.color;
    }

    @Override
    public String toString() {
        return  super.toString() + ", " +ppm + ", " + rezolutie + ", " + p_car + ", " + ms.toString();
    }
}
