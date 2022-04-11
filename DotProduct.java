public class DotProduct {

    //Berechnung des Skalarprodukts
    public static int Dotproduct(int vector1[], int vector2[]) {
        int summe = 0;
        for (int i = 0; i < vector1.length; i++) {
            summe += vector1[i] * vector2[i];
        }
        return summe;
    }

    public static void main(String args[]) {
        int length = (int) (Math.random() * 8 + 3);

        int vector1[] = new int[length];
        int vector2[] = new int[length];

        for (int i = 0; i < length; i++) {
            vector1[i] = (int) (Math.random() * 11 - 5);
            vector2[i] = (int) (Math.random() * 11 - 5);
        }              

        //Ausgabe der Vektoren
        for (int i : vector1) {
            System.out.print(i+" ");
        }
        System.out.println("");
        System.out.println("");
        
        System.out.println("*") ;
        System.out.println("");

        for (int i : vector2) {
            System.out.print(i+" ");
        }
        System.out.println("");
        System.out.println("");

        //Berechnung und Ausgabe des Skalarprodukts
        System.out.println(Dotproduct(vector1, vector2));
    }
}