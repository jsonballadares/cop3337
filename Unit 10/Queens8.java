// Generates all 92 solutions to the 8 queens problem, recursively.
// Solutions are written to file "queens.out"

import java.io.*;

public class Queens8 {
    private boolean[][] board; // the chess board ;
    // a component = true if a queen is there, else it is false

    private boolean[] safeRow; // one element for each of 8 rows ;
    // if row i is safe, then element i is true, else it is false

    private boolean[] safeLeftDiag;
    // one element for each of 15 left-leaning diagonals ;
    // element i is for diagonal where row - col = i - 7

    private boolean[] safeRightDiag;
    // one element for each of 15 right-leaning diagonals ;
    // element i is for diagonal where row + col = i

    private int count; // counts number of solutions

    // constructor
    private Queens8() {
        board = new boolean[8][8];
        safeRow = new boolean[8];
        safeLeftDiag = new boolean[15];
        safeRightDiag = new boolean[15];
        count = 1;

        for (int i = 0; i < 15; i++) {
            safeLeftDiag[i] = true;
            safeRightDiag[i] = true;
            if (i < 8)
                safeRow[i] = true;
        }

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                board[i][j] = false;
    }

    // returns true if a queen may be safely placed in current row & col
    private boolean Safe(int row, int col) {
        return (safeRow[row] && safeLeftDiag[row - col + 7] && safeRightDiag[row + col]);
    }

    // prints final board layout
    private void print(PrintWriter out) {
        System.out.println("Printing solution #" + count);
        out.println("Solution # " + count++ + "\n");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                if (board[i][j])
                    out.print("Q ");
                else
                    out.print("* ");
            out.println();
        }
        out.println("\n");
    }

    // recursive procedure for attempting queen placement
    private void tryColumn(int col, PrintWriter out) {
        int row = 0;
        do {
            if (Safe(row, col)) {
                // place the queen
                safeRow[row] = false;
                safeLeftDiag[row - col + 7] = false;
                safeRightDiag[row + col] = false;
                board[row][col] = true;
                if (col < 7) // if not last queen...
                    tryColumn(col + 1, out); // ...place next queen in next column
                else {
                    print(out); // we're done!
                }

                // remove the queen
                safeRow[row] = true;
                safeLeftDiag[row - col + 7] = true;
                safeRightDiag[row + col] = true;
                board[row][col] = false;
            }
            row++;
        } while (row <= 7);
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("8Queens.out"));
        Queens8 queens = new Queens8();
        queens.tryColumn(0, out);
        out.close();
    }
}