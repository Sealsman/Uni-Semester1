public class Multiplikation {
    //Initalieseren der Verschiedenen Matrizen
    public static int[][] initMatrix(int N, int M) {
        int matrix[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }
    //Multiplikation der Matrizen
    public static int[][] multiplikation(int matrix[][], int matrix2[][], int N) {
        int ergMatrix[][] = new int[N][N];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ergMatrix[i][j] = 0;
                //Summe der Elemete der Reihe i von matrix mit der Spalte j von matrix2 
                for (int k = 0; k < matrix2.length; k++) {
                  ergMatrix[i][j] += matrix[i][k] * matrix2[k][j];
                }
            }
        }
        return ergMatrix;
    }

    //Allgemeine Ausgabe einer Matrix
    public static void ausgabe(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        int N = (int) (Math.random() * 8 + 3);
        int M = (int) (Math.random() * 8 + 3);
        
        //Erstellen der Matrizen
        int matrix[][] = initMatrix(N, M);
        int matrix2[][] = initMatrix(M, N);
        
        //Ausgabe der Initalen Matizen
        ausgabe(matrix);
        ausgabe(matrix2);

        //Ausgabe der Multiplizierten Matrizen
        ausgabe(multiplikation(matrix, matrix2, N));
    }
}
