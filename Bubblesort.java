import java.text.BreakIterator;
import java.util.Random;

public class Bubblesort {
    public static void Bubblesort(int array[], int n) {
        boolean sortet = false;
        Bubblesortrec(array, 0, sortet);
    }

    public static void Bubblesortrec(int array[], int n, boolean sortet) {
        //System.out.println(n);
        if (array[n] > array[n + 1]) {
            sortet = false;
            int temp = array[n];
            array[n] = array[n + 1];
            array[n + 1] = temp;
        }
        if (n >= array.length - 2) {
            if (!sortet) {
                sortet = true;
                n = -1;
            } else {
                return;
            }
        }
        Bubblesortrec(array, n + 1, sortet);
    }

    public static void main(String args[]) {
        int size = 10;
        int arr[] = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(0, size);
        }
        Bubblesort(arr, size);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
}
