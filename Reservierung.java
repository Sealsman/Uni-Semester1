import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Reservierung {
    LocalDateTime datum;
    String person;

    public Reservierung(LocalDateTime _datum, String _person) {
        datum = _datum;
        person = _person;
    }

    // toString
    public String toString() {
        // Einzelene Componenten des LocalDateTime Objets ins angegebene Format bringen
        return ("Reservierung von " + person + " für den " + datum.getYear() + "." + datum.getMonthValue() + "."
                + datum.getDayOfMonth() + "  " + datum.getHour() + ":" + datum.getMinute());
    }

    // equals
    public boolean equals(Reservierung res) {
        // mit LocalDateTime.compareTo die Daten vergleichen sowie die person
        if (res.datum.compareTo(datum) == 0 && res.person == person) {
            return true;
        }
        return false;
    }

    // checkin
    public boolean checkin(Reservierung res) {
        // Personen Vergleich
        if (res.person == person) {
            // anzahl der minuten zwischen ersten und zweiten datum berechen
            long minutes = ChronoUnit.MINUTES.between(res.datum, datum);
            // abgleich ob in dem vorgegeben 20 minuten fenster
            if (minutes <= 5 && minutes >= -15) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        // Initzaliesieren der Testfälle
        Reservierung res1 = new Reservierung(LocalDateTime.parse("2022-02-02T12:45:00"), "Herr Müller");
        Reservierung res2 = new Reservierung(LocalDateTime.parse("2022-02-02T12:40:00"), "Herr Müller");
        Reservierung res3 = new Reservierung(LocalDateTime.parse("2022-02-02T13:00:00"), "Herr Müller");
        Reservierung res4 = new Reservierung(LocalDateTime.parse("2022-02-02T13:01:00"), "Herr Müller");
        Reservierung res5 = new Reservierung(LocalDateTime.parse("2022-02-02T12:44:00"), "Herr Müller");
        Reservierung res6 = new Reservierung(LocalDateTime.parse("2022-02-02T12:45:00"), "Frau Müller");

        // Tests

        // toString
        System.out.println(res1.toString());
        System.out.println();

        // Equals
        System.out.println(res1.equals(res1));
        System.out.println(res1.equals(res2));
        System.out.println();

        // Checkin
        System.out.println(res1.checkin(res1));
        System.out.println(res1.checkin(res2));
        System.out.println(res1.checkin(res3));
        System.out.println(res1.checkin(res4));
        System.out.println(res1.checkin(res5));
        System.out.println(res1.checkin(res6));
    }
}
