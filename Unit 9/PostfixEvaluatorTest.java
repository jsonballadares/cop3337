// File: PostfixEvaluatorTest.java

// Evaluates arithmetic expressions in postfix notation, read from
// a data file.

// The file consists of pairs of lines.  The first line of each pair
// is an infix expression, and the second is the equivalent postfix
// expression. Assumes valid input.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Test class for the PostfixEvaluator class
 */
public class PostfixEvaluatorTest {
    public static void main(String[] args) throws IOException {
        PostfixEvaluator p = new PostfixEvaluator();

        Scanner inFile = new Scanner(new File("postfix.txt"));

        while (inFile.hasNext()) // while not eof...
        {
            // read first line of each pair - the infix expression
            String infix = inFile.nextLine();
            System.out.println("   Infix expression:  \t" + infix);

            // read second line of each pair - the postfix expression
            String postfix = inFile.nextLine();
            System.out.println("   Postfix expression:\t" + postfix);

            double result = p.evaluate(postfix);
            System.out.println("   Result = " + result + "\n");
        }
        // loop postcondition: at eof
        inFile.close();

    }
}

/*
 * sample output:
 * 
 * Infix expression: 3 + 4 * 5 Postfix expression: 3 4 5 * + Result = 23.0
 * 
 * Infix expression: (3 + 4) * 5 Postfix expression: 3 4 + 5 * Result = 35.0
 * 
 * Infix expression: ((3 - (4 + 5)) * 6) $ (1 + 2) Postfix expression: 3 4 5 + -
 * 6 * 1 2 + $ Result = -46656.0
 * 
 * Infix expression: (3 + 4) * (5 - 6) $ 1 * 2 Postfix expression: 3 4 + 5 6 - 1
 * $ * 2 * Result = -14.0
 * 
 * Infix expression: (3 + 4) * (5 $ (6 - 1) + 2) - 7 Postfix expression: 5 6 1 -
 * $ 2 + 3 4 + * 7 - Result = 21882.0
 * 
 */