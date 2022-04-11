import java.util.Random;

public class CocktailSort {
    /*
     * static void cocktailSort(int a[]) {
     * boolean swapped = true;
     * int start = 0;
     * int end = a.length;
     * 
     * while (swapped == true) {
     * swapped = false;
     * for (int i = start; i < end - 1; ++i) {
     * if (a[i] > a[i + 1]) {
     * int temp = a[i];
     * a[i] = a[i + 1];
     * a[i + 1] = temp;
     * swapped = true;
     * }
     * }
     * 
     * if (swapped == false)
     * break;
     * 
     * swapped = false;
     * 
     * end = end - 1;
     * 
     * for (int i = end - 1; i >= start; i--) {
     * if (a[i] > a[i + 1]) {
     * int temp = a[i];
     * a[i] = a[i + 1];
     * a[i + 1] = temp;
     * swapped = true;
     * }
     * }
     * 
     * start = start + 1;
     * }
     * }
     */
    public static void CocktailSort(int[] a) {
        Cocktailsortrec(a, 0, true, true, 0, a.length - 2, 0);
    }

    public static void Cocktailsortrec(int array[], int n, boolean sortet, boolean up, int start, int end,
            int intermediate) {
        // Überprüfen ob wir hoch oder runterzählen
        if (up) {
            //auf Tausch überprüfen
            if (array[n] > array[n + 1]) {
                sortet = false;
                int temp = array[n];
                array[n] = array[n + 1];
                array[n + 1] = temp;
                intermediate = n;
            }
            //Richtungswechsel oder abbruch
            if (n >= end) {
                if (!sortet) {
                    sortet = true;
                    up = !up;
                    end = intermediate;
                } else {
                    return;
                }
            }
        } else {
            //auf Tausch prüfen
            if (array[n] > array[n + 1]) {
                sortet = false;
                int temp = array[n];
                array[n] = array[n + 1];
                array[n + 1] = temp;
                intermediate = n + 1;
            }
            //Richtungswechsel oder Abbruch
            if (n <= start) {
                if (!sortet) {
                    sortet = true;
                    up = !up;
                    start = intermediate;
                } else {
                    return;
                }
            }
        }
        //schleifenzähler
        if (up) {
            n++;
        } else {
            n--;
        }
        Cocktailsortrec(array, n, sortet, up, start, end, intermediate);
    }

    public static void main(String[] args) {
        int size = 10;
        int arr[] = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(0, size);
        }
        CocktailSort(arr);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}