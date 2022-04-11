public class Kombinationen {
    public static void printCombinations(int[] array, int n, int tiefe) {
        //bestimmen ob die Zahl weiter aufgedrosselt werden muss
        if (n > tiefe) {
            //verbleibenden Zahlen aufrufen
            for (int i = 0; i < array.length; i++) {
                //aufgerufene Zahl ausgeben und aus dem array streichen
                int temp[] = new int[array.length - 1];
                System.arraycopy(array, 0, temp, 0, i);
                System.arraycopy(array, i + 1, temp, i, temp.length - i);
                spacer(tiefe);
                System.out.println(array[i]);
                //recursiver aufruf
                printCombinations(temp, n, tiefe + 1);
            }
        }
    }

    //zur besseren veranschaulichung hinzufügen von Lehrzeichen
    public static void spacer(int n){
        if(n!=0){
            System.out.print("  ");
            spacer(n-1);
        }
    }

    public static void main(String args[]) {
        //tests

        //printCombinations(new int[] { 1, 2, 3, 4 }, 1, 0);
        printCombinations(new int[] { 1, 2, 3, 4 }, 2, 0);
        //printCombinations(new int[] { 1, 2, 3, 4 }, 3, 0);
        //printCombinations(new int[] { 1, 2, 3, 4 }, 4, 0);
    }
}