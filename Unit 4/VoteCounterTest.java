// File: VoteCounterTest.java --- Demonstrates 2-Dimensional Arrays

/* Recently a poll was taken on the question "Is there life after birth?"
   The results are shown in the following table:

                YES		NO	   UNDECIDED
 FRESHPERSONS	123	 	78	      37
 SOPHOMORES	117	 	92	      31
 JUNIORS	101	 	99	      23
 SENIORS	96              103	      17

 The data are read from file "Votes.data" which has four records.  The first 
 has the freshperson data, the second the sophomore, etc., so the data are 
 read into successive rows of a "4 by 3" 2-Dimensional array (or, "table")
	
 Then, the following operations are done on the table:

 1. Print the data in table form, as shown above (i.e., by rows)
 2. Compute the total of each type of vote (yes, no, and undecided). This
    is a column-wise operation.
 3. Compute the total votes cast by students in each class (freshman thru
    senior). This is a row-wise operation.
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * A class to demonstrate a two-dimensional array.
 */
class VoteCounter {
    private int[][] votes; // a table to store the votes
    private static final String[] rank = { "Freshperson", "Sophomore", "Junior", "Senior" };
    private static final String[] voteType = { "YES", "NO", "UNDECIDED" };

    /**
     * Create a VoteCounter object with a specified number of rows and columns.
     *
     * @param rows the number of rows
     * @param cols the number of columns
     */
    public VoteCounter(int rows, int cols) {
        votes = new int[rows][cols];
    }

    /**
     * Read data from file into votes table. NOTE: Since the file contains one
     * record for each class, this is a row-wise operation
     */
    public void readData(String fileName) throws IOException {
        Scanner scan = new Scanner(new File(fileName));

        for (int row = 0; row < votes.length; row++) {
            for (int col = 0; col < votes[row].length; col++) {
                votes[row][col] = scan.nextInt();
            }
        }
    }

    /**
     * Print the table by rows.
     */
    public void printTable() {
        // print column headings
        System.out.printf("%23s%12s%12s%n", "YES", "NO", "UNDECIDED");
        System.out.printf("%23s%12s%12s%n", "===", "==", "=========");

        for (int row = 0; row < votes.length; row++) {
            System.out.printf("%-11s", rank[row]);
            for (int col = 0; col < votes[row].length; col++) {
                System.out.printf("%12d", votes[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Compute and print the total YES, NO, and UNDECIDED votes. This is a
     * column-wise operation
     */
    public void printVoteTotals() {
        System.out.printf("%13s%n%13s%n", "Total Votes", " ==============");

        for (int col = 0; col < votes[0].length; col++) {
            // initial accumulator for current column
            int total = 0;

            // print type of vote for current column
            System.out.printf("%10s", voteType[col]);

            for (int row = 0; row < votes.length; row++) {
                // accumulate total for current row
                total += votes[row][col];
            }
            System.out.println(": " + total);
        }
        System.out.println();
    }

    /**
     * Compute and print the total votes cast by members of each class. NOTE: Is
     * this a row-wise or column-wise operation?
     */
    public void printClassTotals() {
        // this method is left as an excercise for the reader!
    }
}

public class VoteCounterTest {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        VoteCounter myVoteCounter = new VoteCounter(4, 3);

        System.out.print("Enter name of input file (including path): ");
        String fileName = input.nextLine();
        System.out.println();

        myVoteCounter.readData(fileName);
        myVoteCounter.printTable();
        myVoteCounter.printVoteTotals();
        myVoteCounter.printClassTotals();
    }
}

/*
 * Sample output:
 * 
 * Enter name of input file (including path): Votes.data
 * 
 * YES NO UNDECIDED === == ========= Freshperson 123 78 37 Sophomore 117 92 31
 * Junior 101 99 23 Senior 96 103 17
 * 
 * Total Votes ============== YES : 437 NO : 372 UNDECIDED: 108
 * 
 */