package Pb1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void afisareImprimante(List<Echipamente> ech) {
        System.out.println("Imprimante: ");
        for (Echipamente e : ech) {
            if (e instanceof Imprimante) {
                System.out.println(e.toString());
            }
        }
    }

    public static void afisareCopiatoare(List<Echipamente> ech) {
        System.out.println("Copiatoare: ");
        for (Echipamente e : ech) {
            if (e instanceof Copiatoare) {
                System.out.println(e.toString());
            }
        }
    }

    public static void afisareSistemeCalcul(List<Echipamente> ech) {
        System.out.println("Sisteme de calcul: ");
        for (Echipamente e : ech) {
            if (e instanceof SistemeCalcul) {
                System.out.println(e.toString());
            }
        }
    }

    public static void modifStare(List<Echipamente> ech, String stare, int nr_inv) {
        boolean found = false;
        for (Echipamente e : ech) {
            if (e.getNr_inventar() == nr_inv) {
                e.setS(Stare.valueOf(stare));
                System.out.println("Stare noua: " + stare);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Echipamentul nu exista in inventar!");
        }
    }

    public static void modScriere(List<Echipamente> ech, String mod, int nr_inv) {
        boolean found = false;
        for (Echipamente e : ech) {
            if (e.getNr_inventar() == nr_inv && e instanceof Imprimante) {
                Imprimante imp = (Imprimante) e;
                imp.setMs(ModScriere.valueOf(mod));
                System.out.println("Mod setat la: " + mod);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Imprimanta nu exista in inventar!");
        }
    }

    public static void modCopiere(List<Echipamente> ech, String mod, int nr_inv) {
        boolean found = false;
        for (Echipamente e : ech) {
            if (e.getNr_inventar() == nr_inv && e instanceof Copiatoare) {
                Copiatoare c = (Copiatoare) e;
                c.setFm(FormatCopiere.valueOf(mod));
                System.out.println("Mod setat la: " + mod);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Copiatorul nu exista in inventar!");
        }
    }

    public static void instOS(List<Echipamente> ech, String os, int nr_inv) {
        boolean found = false;
        for (Echipamente e : ech) {
            if (e.getNr_inventar() == nr_inv && e instanceof SistemeCalcul) {
                SistemeCalcul sc = (SistemeCalcul) e;
                sc.setSo(SistemOperare.valueOf(os));
                System.out.println("S-a instalat: " + os);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Sistemul de calcul nu exista in inventar!");
        }
    }

    public static void afisareVanzari(List<Echipamente> ech) {
        System.out.println("Echipamente vandute: ");
        for (Echipamente e : ech)
            if (e.getS().toString().equals("vandut"))
                System.out.println(e.toString());
    }

    static void scrie(List<Echipamente> ech, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(ech);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Echipamente> citeste(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            List<Echipamente> ech = (List<Echipamente>) ois.readObject();
            ois.close();
            return ech;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        List<Echipamente> ech = new ArrayList<>();
        Scanner flux_in = new Scanner(new File("C:\\Users\\ghile\\IdeaProjects\\Laborator 4\\src\\Pb1\\echipamente.txt"));

        while (flux_in.hasNextLine()) {
            String temp = flux_in.nextLine();
            String[] temp_vect = temp.split(";");
            switch (temp_vect[5]) {
                case "imprimanta":
                    ech.add(new Imprimante(temp_vect[0], Integer.parseInt(temp_vect[1]), Double.parseDouble(temp_vect[2]),
                            temp_vect[3], Stare.valueOf(temp_vect[4]), Integer.parseInt(temp_vect[6]), temp_vect[7],
                            Integer.parseInt(temp_vect[8]), ModScriere.valueOf(temp_vect[9])));
                    break;

                case "copiator":
                    ech.add(new Copiatoare(temp_vect[0], Integer.parseInt(temp_vect[1]),
                            Double.parseDouble(temp_vect[2]), temp_vect[3], Stare.valueOf(temp_vect[4]), Integer.parseInt(temp_vect[6]),
                            Integer.parseInt(temp_vect[7]), FormatCopiere.valueOf(temp_vect[8])));
                    break;

                case "sistem de calcul":
                    ech.add(new SistemeCalcul(temp_vect[0], Integer.parseInt(temp_vect[1]),
                            Double.parseDouble(temp_vect[2]), temp_vect[3], Stare.valueOf(temp_vect[4]), temp_vect[6],
                            Double.parseDouble(temp_vect[7]), Integer.parseInt(temp_vect[8]), SistemOperare.valueOf(temp_vect[9])));
                    break;
            }
        }

        flux_in.close();

        int opt;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("--------------------------MENIU-------------------------------------");
            System.out.println("0.Iesire");
            System.out.println("1.Afisarea imprimantelor");
            System.out.println("2.Afisarea copiatoarelor");
            System.out.println("3.Afisarea sistemelor de calcul");
            System.out.println("4.Modificarea starii in care se afla un echipament");
            System.out.println("5.Setarea unui anumit mod de scriere pentru o imprimanta");
            System.out.println("6.Setarea unui format de copiere pentru copiatoare");
            System.out.println("7.Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("8.Afisarea echipamentelor vandute");
            System.out.println("9.Serializare");
            System.out.println("10.Deserializare");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\nIntroduceti optiunea: ");
            opt = Integer.parseInt(reader.readLine());
            switch (opt) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    afisareImprimante(ech);
                    break;
                case 2:
                    afisareCopiatoare(ech);
                    break;
                case 3:
                    afisareSistemeCalcul(ech);
                    break;
                case 4:
                    System.out.println("Introduceti starea (achizitionat/expus/vandut): ");
                    String stare = reader.readLine();
                    System.out.println("Introduceti numarul de inventar al echipamentului: ");
                    int nr_inv = Integer.parseInt(reader.readLine());
                    modifStare(ech, stare, nr_inv);
                    break;
                case 5:
                    System.out.println("Introduceti modul de scriere (color/albnegru): ");
                    String modScr = reader.readLine();
                    System.out.println("Introduceti numarul de inventar al echipamentului: ");
                    int nr_inv1 = Integer.parseInt(reader.readLine());
                    modScriere(ech, modScr, nr_inv1);
                    break;
                case 6:
                    System.out.println("Introduceti modul de copiere (A3/A4): ");
                    String modCop = reader.readLine();
                    System.out.println("Introduceti numarul de inventar al echipamentului: ");
                    int nr_inv2 = Integer.parseInt(reader.readLine());
                    modCopiere(ech, modCop, nr_inv2);
                    break;
                case 7:
                    System.out.println("Introduceti numele sistemului de operare (windows/linux): ");
                    String os = reader.readLine();
                    System.out.println("Introduceti numarul de inventar al echipamentului: ");
                    int nr_inv3 = Integer.parseInt(reader.readLine());
                    instOS(ech, os, nr_inv3);
                    break;
                case 8:
                    afisareVanzari(ech);
                    break;
                case 9:
                    scrie(ech, "C:\\Users\\ghile\\IdeaProjects\\Laborator 4\\src\\Pb1\\echipamente_ser.txt");
                    break;
                case 10:
                    List<Echipamente> deserializedEch = citeste("C:\\Users\\ghile\\IdeaProjects\\Laborator 4\\src\\Pb1\\echipamente_ser.txt");
                    if (deserializedEch != null) {
                        ech = deserializedEch;
                    }
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        } while (opt != 0);
    }
}
