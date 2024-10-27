package Pb1;

public class SistemeCalcul extends Echipamente {


    private static final long serialVersionUID = 1L;
    private String tip_monitor;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare so;

    public SistemeCalcul(String denumire, int nr_inventar, double pret, String zona_mag, Stare s, String tip_monitor,
                         double vit_proc, int c_hdd, SistemOperare so) {
        super(denumire, nr_inventar, pret, zona_mag, s);
        this.tip_monitor = tip_monitor;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.so = so;
    }


    public SistemOperare getSo() {
        return so;
    }

    public void setSo(SistemOperare so) {
        this.so = so;
    }

    public void instalWin() {
        setSo(SistemOperare.windows);
    }

    public void instalLinux(){
        setSo(SistemOperare.linux);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + tip_monitor + ", " + vit_proc + ", " + c_hdd + ", " + so.toString();
    }

}
