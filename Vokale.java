public class Vokale {
    public static void main(String[] args){
        String input = null;
        if(args.length ==1){
            input = args[0];
        }else{
            System.exit(1);
        }
        char[] InputChars = input.toCharArray();
        int a = 0, e=0, i=0, o=0, u=0;
        for (char c : InputChars) {
            switch (c){
                case 'A':
                case 'a':
                    a++;
                    break;
                case 'E':
                case 'e':
                    e++;
                    break;
                case 'I':
                case 'i':
                    i++;
                    break;
                case 'O':
                case 'o':
                    o++;
                    break;
                case 'U':
                case 'u':
                    u++;
                    break;
                default:
                    continue;
            }
        }
        System.out.println("Das Wort "+input+"enthält");
        System.out.println("a: "+a);
        System.out.println("e: "+e);
        System.out.println("i: "+i);
        System.out.println("o: "+o);
        System.out.println("u: "+u);
    }
}
