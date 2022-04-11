public class Palindrom {
    public static boolean isPalindrome(String s) {
        //Überprüfen ob es noch mehr als 1 Zeichen im string gibt
        if (s.length() < 2) {
            return true;
        }
        //String in temporären char array umwandeln
        char temp[] = s.toCharArray();
        //Überpüfen ob die erste und letzte stelle den gleichen Charakter besitzen
        if (Character.toLowerCase(temp[0]) == Character.toLowerCase(temp[temp.length-1])) {
            //lehren des Strings und eintragen der noch zu überprüfenden stellen
            s = "";
            for (int i = 1; i < temp.length-1; i++) {
                s += temp[i];
            }
            //recursiver aufruf mit dem gekürztem string
            return isPalindrome(s);
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        //Tests
        System.out.println(isPalindrome("Kajak"));
        System.out.println(isPalindrome("test"));
        System.out.println(isPalindrome("t"));
    }
}
