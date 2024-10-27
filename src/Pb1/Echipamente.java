package Pb1;

import java.io.Serializable;

public class Echipamente implements Serializable {

    private static final long serialVersionUID = 1L;
    private String denumire;
    private int nr_inventar;
    private double pret;
    private String zona_mag;
    private Stare s;

    public Echipamente(String denumire, int nr_inventar, double pret, String zona_mag, Stare s) {
        super();
        this.denumire = denumire;
        this.nr_inventar = nr_inventar;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.s = s;
    }

    public int getNr_inventar() {
        return nr_inventar;
    }

    public Stare getS() {
        return s;
    }

    public void setS(Stare s) {
        this.s = s;
    }
    @Override
    public String toString() {
        return denumire + ", " + nr_inventar + ", " + pret + ", " + zona_mag + ", " + s.toString();
    }
}
