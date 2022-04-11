public class Primzahl {
    public static int[] Zerlegung(int n){
        int MaximaleFaktoren = (int) Math.ceil(Math.log10(n)/Math.log10(2));
        int[] tmp = new int[MaximaleFaktoren];
        int Faktoren = 0;
        for(int i = 2;i<=n;i++){
            if(n%i==0){
                tmp[Faktoren++] = i;
                n=n/i;
                i=1;
            }
        }
        int[] rueckgabe = new int[Faktoren];
        for (int i=0; i<rueckgabe.length;i++) {
            rueckgabe[i] = tmp[i];
        }
        return rueckgabe;
    }
    public static void main(String[] args){
        int eingabe = null;
        if(args.length ==1){
            eingabe = Integer.parseInt(args[0]);
        }else{
            System.exit(1);
        }
        int[] Primzahlen = Zerlegung(eingabe);
        System.out.print("Primfaktorzerlegung von " + eingabe +" lautet: "+Primzahlen[0]);
        for (int i=1; i<Primzahlen.length;i++) {
            System.out.print("*"+Primzahlen[i]);
        }
    }
}
