import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rauten {
    public static void raute(int N) {
        int counters = 0;
        int counterr = 0;
        for (int i = 0; i < N; i++) {
            counters = 0;
            counterr++;
            //Setzen der Sterne an der Linken oberen Kante so wie merken der position
            for (int j = i; j < N; j++) {
                System.out.print(" ");
                counters++;
            }
            System.out.print("*");
            //Cursor in die Mitte der raute bewegen
            for (int j = counters; j < N; j++) {
                System.out.print(" ");
            }
            //anhand der Zeile in der wir sind bestimmen der rechten oberen Kante
            for (int j = 0; j < counterr - 2; j++) {
                System.out.print(" ");
            }
            //Vermeiden Doppelter Punkte
            if (counters != N) {
                System.out.println("*");
            } else {
                System.out.println("");
            }
        }
        for (int i = N; i >= 0; i--) {
            counters = 0;
            counterr--;
            //Setzen der Punkte in der linken untern Kante
            for (int j = i; j < N; j++) {
                System.out.print(" ");
                counters++;
            }
            //Cursor in die Mitte der Raute bewegen
            System.out.print("*");
            for (int j = counters; j < N; j++) {
                System.out.print(" ");
            }
            //Bestimmen der Positionen der rechten unteren Kante
            for (int j = 0; j < counterr; j++) {
                System.out.print(" ");
            }
            //Vermeiden Doppelter Punkte
            if (counters != N) {
                System.out.println("*");
            } else {
                System.out.println("");
            }
        }
    }

    public static void main(String args[]) {
        //User Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Gebe die KantenLänge der Raute ein:");
        int i = 0;
        try {
            i = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        } catch (IOException ioe) {
            System.err.println("IOException");
        }
        //Garantieren einer leeren Zeile für Methodenbeginn
        System.out.println("");
        raute(i - 1);
    }
}
