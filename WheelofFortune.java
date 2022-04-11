import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WheelofFortune {
    static String[] entrys = new String[10];

    public static boolean addEntry(String entry) {
        if (getNumEntrys() < entrys.length) {
            entrys[getNumEntrys()] = entry;
            return true;
        }
        return false;
    }

    public static boolean removeEntry() {
        if (getNumEntrys() != 0) {
            entrys[getNumEntrys() - 1] = " ";
            return true;
        }
        return false;
    }

    public static int getNumEntrys() {
        int numEntrys = 0;
        while (entrys[numEntrys] != " ") {
            numEntrys++;
        }
        return numEntrys;
    }

    public static String Spin() {
        Random rd = new Random();
        return entrys[rd.nextInt(getNumEntrys())];
    }

    public static void initarray() {
        for (int i = 0; i < entrys.length; i++) {
            entrys[i] = " ";
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initarray();
        boolean running = true;
        while (running) {
            System.out.println("Hinzufügen(H), Entfernen(E), Anzahl einträge(A), Drehen(D), Beenden(B)");
            char x[] = new char[1];
            try {
                x = br.readLine().toCharArray();
            } catch (IOException ioe) {
                System.err.println("IOException");
            }
            switch (x[0]) {
            case 'H':
                String entry = "";
                System.out.println("Geben sie den Wert ein den sie hinzufügen möchten");
                try {
                    entry = br.readLine();
                } catch (IOException ioe) {
                    System.err.println("IOException");
                }
                if (addEntry(entry)) {
                    System.out.println("Wert wurde hinzugefügt");
                } else {
                    System.out.println("Das Glücksrad ist bereits voll");
                }
                break;
            case 'E':
                if (removeEntry()) {
                    System.out.println("Der letzte Wert wurde entfernt");
                } else {
                    System.out.println("Es ist kein Wert auf dem Glücksrad vorhanden der Gelöscht werden könnte");
                }
                break;
            case 'A':
                System.out.println("Es sind momentan " + getNumEntrys() + " auf dem Glücksrad vorhanden");
                break;
            case 'D':
                System.out.println("Das Grücksrad ist auf " + Spin() + " gelandet");
                break;
            case 'B':
                running = false;
                break;
            default:
                System.out.println("Die Eingabe wurde nicht erkannt bitte wiederholen");
            }
        }
    }
}