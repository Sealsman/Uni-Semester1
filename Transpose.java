public class Transpose {
    //Methode zur Bildung der Transponierenden
    public static int[][] transpose(int matrix[][]) {
        int transposedmatrix[][] = new int[matrix[1].length][matrix.length];
        
        //transponieren der Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                transposedmatrix[j][i] = matrix[i][j];
            }
        }
        return transposedmatrix;
    }
    
    //Ausgabe einer Matrix
    public static void ausgabe(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        int N = (int) (Math.random() * 8 + 3);
        int M = (int) (Math.random() * 8 + 3);

        int matrix[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        
        //Ausgabe Initaler Matrix
        ausgabe(matrix);

        //Berechnung und Ausgabe Transponiertermatrix
        ausgabe(transpose(matrix));
    }
}
