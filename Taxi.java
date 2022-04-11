import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Taxi {
    //Variablen
    final double grundpreis;
    final double kilometerpreis;
    final double kraftstoffverbrauch;
    final double tankvolumen;
    double tankinhalt;
    double taxometer = 0;
    double gesamteinnahme = 0;

    //initaliesierung der verschiedenen vorgegeben werten
    public Taxi(double _grundpreis, double _kilometerpreis, double _kraftstoffverbrauch, double _tankvolumen, double _tankinhalt) {
        grundpreis = _grundpreis;
        kilometerpreis = _kilometerpreis;
        kraftstoffverbrauch = _kraftstoffverbrauch;
        tankvolumen = _tankvolumen;
        tankinhalt = _tankinhalt;
    }

    //Drive
    public double drive(double distance) {
        //Überprüfen ob Strecke gefahren werden kann
        if (distance < kraftstoffverbrauch * tankinhalt){
            //Wenn keine andere Unbezahlte Fahrt vorliegt Taxometer um Grundpreis erhöhen
            if (taxometer == 0) {
                taxometer = grundpreis;
            }
            //Preis der zufahrenden Strecke berechnen und auf 2 Kommastellen runden
            BigDecimal bd = new BigDecimal(kilometerpreis * distance).setScale(2, RoundingMode.HALF_UP);
            //Taxometer um berechnet wert erhöhen und zurückgeben
            taxometer += bd.doubleValue();
            return bd.doubleValue();
        }
        System.out.println("Tankinhalt reicht für die fahrt nicht aus");
        return 0;
    }

    //Pay
    public boolean pay(double amount) {
        //Überpüfen ob genug bezhalt wurde
        if (amount >= taxometer) {
            // Überprüfen ob wechselgeld zurückgegeben werden muss
            if (amount > taxometer) {
                System.out.println("Es wurden " + (amount - taxometer) + " als wechselgeld zurückgegeben");
            }
            //Einnahmen erhöhen und taxometer zurücksetzen
            gesamteinnahme += taxometer;
            taxometer = 0;
            return true;
        } else {
            return false;
        }
    }

    //Refill 
    public void refill(double pricePerLitre) {
        //Tankbare menge herrausfinden
        double missing = tankvolumen - tankinhalt;
        //Überprüfen ob Vollgetankt werden kann
        if ((missing * pricePerLitre) > gesamteinnahme) {
            //Budgettanken
            tankinhalt = tankinhalt + gesamteinnahme / pricePerLitre;
            gesamteinnahme = 0;
        } else {
            //Volltanken
            tankinhalt = tankvolumen;
            gesamteinnahme -= missing * pricePerLitre;
        }
    }

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double input = 0;
        String tmp = "";
        double temp; 
        boolean run = true;
        //initalieseren unseres Taxis
        Taxi taxi = new Taxi(2.8, 1.75, 7, 45, 41);
        while (run) {
            //User abfrage nach zu erledigten aktion
            System.out.println("Für Fahren(f), Zahlen(z), tanken(t), exit(x)");
            try {
                tmp = br.readLine();
            } catch (IOException ioe) {
                System.err.println("IOException");
            }
            switch (tmp) {
                //Drive
                case "f":
                    System.out.println("Wie weit soll gefahren werden?");
                    //Userinput
                    try {
                        input = Double.parseDouble(br.readLine());
                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Format!");
                    } catch (IOException ioe) {
                        System.err.println("IOException");
                    }
                    if (input > 0) {
                        //driving
                        temp = taxi.drive(input);
                        System.out.println("Erfolgreich " + input + " Kilometer gefahren für" + temp);
                        input = 0;
                    } else {
                        System.out.println("Ihre eingabe war ungültig");
                    }
                    break;
                //Pay
                case "z":
                    System.out.println("Der Fahrtpreis beträgt " + taxi.taxometer);
                    System.out.println("Wie viel wurde gezahlt?");
                    //Userinput
                    try {
                        input = Double.parseDouble(br.readLine());
                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Format!");
                    } catch (IOException ioe) {
                        System.err.println("IOException");
                    }
                    if (input > 0) {
                        //paying
                        if(taxi.pay(input)){
                            System.out.println("erfolgreich bezahlt");
                        }else{
                            System.out.println("Zahlung unvollständig");
                        }
                    } else {
                        System.out.println("Ihre eingabe war ungültig");
                    }
                    break;
                //Refill
                case "r":
                    System.out.println("Bitte geben sie den Preis pro Liter an");
                    //Userinput
                    try {
                        input = Double.parseDouble(br.readLine());
                    } catch (NumberFormatException nfe) {
                        System.err.println("Invalid Format!");
                    } catch (IOException ioe) {
                        System.err.println("IOException");
                    }
                    if (input > 0) {
                        //paying
                        taxi.refill(input);
                        System.out.println("neuer tankinhalt"+taxi.tankinhalt);
                        input = 0;
                    } else {
                        System.out.println("Ihre eingabe war ungültig");
                    }
                    break;
                //exit
                case "x":
                    run = false;
                    break;
                default:
                    System.out.println("Ihre eingabe war ungültig");
                    break;
            }
        }
    }
}
