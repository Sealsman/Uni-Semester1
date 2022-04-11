import java.util.Scanner;

public class TicTacToe {
    public static Scanner scanner;

    public static char[][] getMove(int player, char[][] board) {
        //Input des Spielers abfragen
        System.out.println("Spieler " + player + " ist am Zug:");
        int input = scanner.nextInt();
        //überprüfung ob eingabe im Spielfeld liegt
        if (0 < input && input < 10) {
            input--;
            //Überprüfen ob position bereits beleegt ist
            if (board[input / 3][input % 3] != 'X' && board[input / 3][input % 3] != 'O') {
                //Zuweisen des neuen werts
                if (player == 1) {
                    board[input / 3][input % 3] = 'X';
                } else {
                    board[input / 3][input % 3] = 'O';
                }
            } else {
                System.out.println("Positon bereits belegt");
                board = getMove(player, board);
            }
        } else {
            System.out.println("Ungültige Eingabe");
            board = getMove(player, board);
        }
        return board;
    }

    public static void printBoard(char[][] board) {
        //Ausgabe des momentanigen Spielfelds
        for (int i = 0; i < board.length; i++) {
            System.out.println("+---+---+---+");
            String line = "";
            for (int j = 0; j < board[0].length; j++) {
                line += "| ";
                line += board[i][j];
                line += " ";
            }
            System.out.println(line);
        }
        System.out.println("+---+---+---+");
    }

    public static boolean horizontel(char player, char[][] board) {
        int score = 0;
        //Reihenweise überprüfung ob ein Spieler gewonnen hat
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == player) {
                    score++;
                }
            }
            if (score == 3) {
                return true;
            } else {
                score = 0;
            }
        }
        return false;
    }

    public static boolean vertical(char player, char[][] board) {
        int score = 0;
        //Splatenweise überprüfung ob ein Spieler gewonnen hat
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == player) {
                    score++;
                }
            }
            if (score == 3) {
                return true;
            } else {
                score = 0;
            }
        }
        return false;
    }

    public static boolean diagonal(char player, char[][] board) {
        //Diagonale des Felds auf Sieger überprüfen
        if ((board[0][0] == board[2][2] && board[1][1] == player && board[1][1] == board[0][0])
                || (board[2][0] == board[0][2] && board[1][1] == player && board[1][1] == board[0][2])) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean winningMove(int player, char[][] board) {
        //Umwandlung des int player in entsprechenden char
        char playerChar = ' ';
        if (player == 1) {
            playerChar = 'X';
        } else {
            playerChar = 'O';
        }
        //überprüfen ob Spieler ine einer der 3 Möglichen weisen gewonnen hat1
        if (horizontel(playerChar, board) || vertical(playerChar, board) || diagonal(playerChar, board)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //Nutzen von Move für Offset um Feldern passende Nummern zuzuweisen
        int move = 48;
        scanner = new Scanner(System.in);
        int player = 2;
        //Deklaration und Initzaliesierung von board
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                move++;
                board[i][j] = (char) move;
            }
        }
        //Zurücksetzen von move um ihn als Zähler für die Runden zu verwenden 
        move = 0;
        //Schleife die Solange läuft solange kein Spieler gewonnen hat
        while (!winningMove(player, board)) {
            //Spielerwechsel
            if (player == 1) {
                player++;
            } else {
                player--;
            }
            //Überprüfen eines Möglichen unentschiedens
            if (move == 9) {
                System.out.println("Unentschieden");
                System.exit(1);
            }
            //Durchführen eines Spielzugs
            board = getMove(player, board);
            printBoard(board);
            //incrementierung der Runden
            move++;
        }
        System.out.println("Spieler " + player + " hat gewonnen");
    }
}
