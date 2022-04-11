public class SeperateDigits {
    public static int[] separateDigits(String number) {
        //String zu char array
        char[] numbers = number.toCharArray();
        //erstellen output arrays
        int[] output = new int[numbers.length];
        //Convertieren des Char arrays zu int array
        for (int i = 0; i < numbers.length; i++) {
            output[i] = Character.getNumericValue(numbers[i]);
        }
        return output;
    }
    //seperarien des Integers
    public static int[] separateDigits(int number) {
        //Int zu String zu Char array
        char[] numbers = Integer.toString(number).toCharArray();
        //erstellen output arrays
        int[] output = new int[numbers.length];
        //Convertieren des Char arrays zu int array
        for (int i = 0; i < numbers.length; i++) {
            output[i] = Character.getNumericValue(numbers[i]);
        }
        return output;
    }
    public static void main(String[] args){
        // Initalisieren der Eingaben
        String eingabe = "1337";
        int eingabeint = 1337;
        //Sperarieren der Bits mit String ausgabe
        int[] output = separateDigits(eingabe);
        //Ausgabe des getrennten Strings
        for (int i=0;i< output.length;i++){
            System.out.println(output[i]);
        }
        System.out.println(" ");
        //Seperarieren der Bist mit int eingabe
        output = separateDigits(eingabeint);
        //Ausgabe des getrennten integers
        for (int i=0;i< output.length;i++){
            System.out.println(output[i]);
        }
    }
}