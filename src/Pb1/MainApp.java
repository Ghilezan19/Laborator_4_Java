package Pb1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class MainApp {
    public static void afisareImprimante(Echipamente[] ech){
        System.out.println("Imprimante: ");
        for(Echipamente e : ech) {
            if(e instanceof Imprimante) {
                System.out.println(e.toString());
            }
        }
    }

    public static void afisareCopiatoare(Echipamente[] ech){
        System.out.println("Copiatoare: ");
        for(Echipamente e : ech) {
            if(e instanceof Copiatoare) {
                System.out.println(e.toString());
            }
        }
    }

    public static void afisareSistemeCalcul(Echipamente[] ech){
        System.out.println("Sisteme de calcul: ");
        for(Echipamente e : ech) {
            if(e instanceof SistemeCalcul) {
                System.out.println(e.toString());
            }
        }
    }

    public static void modifStare(Echipamente[] ech, String stare, int nr_inv) {
        for(Echipamente e : ech) {
            boolean flg = true;

            if(e.getNr_inventar() == nr_inv) {
                flg = false;
                e.setS(Stare.valueOf(stare));
                System.out.println("Stare noua: " + stare);
                break;
            }

            if(flg == false)
                System.out.println("Echipamentul nu exista in inventar!");
        }
    }

    public static void modScriere(Echipamente[] ech, String mod, int nr_inv) {
        for(Echipamente e : ech) {
            boolean flg = true;

            if(e.getNr_inventar() == nr_inv) {
                flg = false;
                Imprimante imp = (Imprimante)e;
                imp.setMs(ModScriere.valueOf(mod));
                System.out.println("Mod setat la: " + mod);
                break;
            }

            if(flg == false)
                System.out.println("Echipamentul nu exista in inventar!");
        }
    }

    public static void modCopiere(Echipamente[] ech, String mod, int nr_inv) {
        for(Echipamente e : ech) {
            boolean flg = true;

            if(e.getNr_inventar() == nr_inv) {
                flg = false;
                Copiatoare c = (Copiatoare)e;
                c.setFm(FormatCopiere.valueOf(mod));
                System.out.println("Mod setat la: " + mod);
                break;
            }

            if(flg == false)
                System.out.println("Echipamentul nu exista in inventar!");
        }
    }

    public static void instOS(Echipamente[] ech, String os, int nr_inv) {
        for(Echipamente e : ech) {
            boolean flg = true;

            if(e.getNr_inventar() == nr_inv) {
                flg = false;
                SistemeCalcul sc = (SistemeCalcul)e;
                sc.setSo(SistemOperare.valueOf(os));
                System.out.println("S-a instalat: " + os);
                break;
            }

            if(flg == false)
                System.out.println("Echipamentul nu exista in inventar!");
        }
    }

    public static void afisareVanzari(Echipamente[] ech) {
        System.out.println("Echipamente vandute: ");
        for(Echipamente e : ech)
            if(e.getS().toString() == "vandut")
                System.out.println(e.toString());
    }

    static void scrie(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object citeste(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        final int nr_ech = 6;
        int index=0;
        Scanner flux_in = new Scanner(new File("C:\\Users\\ghile\\IdeaProjects\\Laborator 4\\src\\Pb1\\echipamente.txt"));
        Echipamente[] ech = new Echipamente[nr_ech];


        while(flux_in.hasNextLine()){

            String temp = flux_in.nextLine();
            String[] temp_vect = temp.split(";");

            switch(temp_vect[5]) {

                case "imprimanta": ech[index++] = (Echipamente) new Imprimante(temp_vect[0], Integer.parseInt(temp_vect[1]), Double.parseDouble(temp_vect[2]),
                        temp_vect[3], Stare.valueOf(temp_vect[4]), Integer.parseInt(temp_vect[6]), temp_vect[7],
                        Integer.parseInt(temp_vect[8]), ModScriere.valueOf(temp_vect[9]));
                    break;

                case "copiator": ech[index++] = (Echipamente) new Copiatoare(temp_vect[0], Integer.parseInt(temp_vect[1]),
                        Double.parseDouble(temp_vect[2]), temp_vect[3], Stare.valueOf(temp_vect[4]), Integer.parseInt(temp_vect[6]),
                        Integer.parseInt(temp_vect[7]), FormatCopiere.valueOf(temp_vect[8]));
                    break;

                case "sistem de calcul": ech[index++] = (Echipamente) new SistemeCalcul(temp_vect[0], Integer.parseInt(temp_vect[1]),
                        Double.parseDouble(temp_vect[2]), temp_vect[3], Stare.valueOf(temp_vect[4]), temp_vect[6],
                        Double.parseDouble(temp_vect[7]), Integer.parseInt(temp_vect[8]), SistemOperare.valueOf(temp_vect[9]));
                    break;
            }
        }

        int opt;
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

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
            switch(opt){

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
                    Echipamente[] e;
                    e=(Echipamente[])citeste("echipamente_ser.txt");
                    for(Echipamente ec : e)
                        System.out.println(ec.toString());
                    break;

                default:
                    System.out.println("Optiune gresita!");
            }
        }while(opt!=0);
    }
}

