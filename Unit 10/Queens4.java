// Generates all solutions to the 4 queens problem, recursively.
// Solutions are written to file "4queens.out"

import java.io.*;
import javax.swing.JOptionPane;

public class Queens4 {
    private boolean traceOn;
    private boolean[][] board; // the chess board ;
    // a component = true if a queen is there, else it is false

    private boolean[] safeRow; // one element for each of 4 rows ;
    // if row i is safe, then element i is true, else it is false

    private boolean[] safeLeftDiag;
    // one element for each of 7 left-leaning diagonals ;
    // element i is for diagonal where row - col = i - 3

    private boolean[] safeRightDiag;
    // one element for each of 7 right-leaning diagonals ;
    // element i is for diagonal where row + col = i

    private int count; // counts number of solutions

    // constructor
    private Queens4(boolean traceOn) {
        this.traceOn = traceOn;
        board = new boolean[4][4];
        safeRow = new boolean[4];
        safeLeftDiag = new boolean[7];
        safeRightDiag = new boolean[7];
        count = 1;

        for (int i = 0; i < 7; i++) {
            safeLeftDiag[i] = true;
            safeRightDiag[i] = true;
            if (i < 4) {
                safeRow[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = false;
            }
        }
    }

    // returns true if a queen may be safely placed in current row & col
    private boolean Safe(int row, int col) {
        return (safeRow[row] && safeLeftDiag[row - col + 3] && safeRightDiag[row + col]);
    }

    // prints final board layout
    private void print(PrintWriter out) {
        System.out.println("\nPrinting solution #" + count + " to file\n");
        out.println("Solution # " + count++ + "\n");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j]) {
                    out.print("Q ");
                } else {
                    out.print("* ");
                }
            }
            out.println();
        }
        out.println("\n\n");
    }

    // recursive procedure for attempting queen placement
    private void tryColumn(int col, PrintWriter out) {
        int row = 0;
        do {
            if (Safe(row, col)) {
                // place the queen
                safeRow[row] = false;
                safeLeftDiag[row - col + 3] = false;
                safeRightDiag[row + col] = false;
                board[row][col] = true;
                if (traceOn) {
                    System.out.println("Placing Queen at [" + row + "][" + col + "]");
                }
                if (col < 3) // if not last queen...
                // ...try to place next queen in next column
                {
                    tryColumn(col + 1, out);
                    // return here
                } else {
                    print(out); // found a solution!
                }
                // remove the queen
                safeRow[row] = true;
                safeLeftDiag[row - col + 3] = true;
                safeRightDiag[row + col] = true;
                board[row][col] = false;
                if (traceOn) {
                    System.out.println("Removing Queen from [" + row + "][" + col + "]");
                }
            }
            row++;
        } while (row <= 3);
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("4Queens.out"));
        String input = JOptionPane.showInputDialog("Trace on?\n" + "[OK]=YES, [Cancel]=NO");
        Queens4 queens = new Queens4(input != null);
        queens.tryColumn(0, out);
        out.close();
    }
}