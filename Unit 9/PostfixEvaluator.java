// File: EvaluatePostfixEvaluator.java

// Evaluates an arithmetic expression in postfix notation.
// (Also serves as test class for a stack class - in this case, Stack2.java)

// Demonstrates stack operations push and pop

import java.util.Scanner;

/**
 * Evaluates arithmetic expressions in postfix notation.
 */
public class PostfixEvaluator {

    private Stack2<Double> stack;
    // create String containing all valid aritmetic operators
    private static final String OPERATORS = "$*/+-"; // "$" = exponentiation

    /**
     * Create a PostfixEvaluator object
     */
    public PostfixEvaluator() {
        stack = new Stack2<Double>();
    }

    /**
     * Evaluate a postfix arithmetic expression
     * 
     * @param postfix the expression to be evaluated
     * @return the result
     */
    public double evaluate(String postfix) {
        Scanner scan = new Scanner(postfix); // to scan postfix string

        // extract and process each symbol of postfix string

        while (scan.hasNext()) // while more symbols in string
        {
            String symbol = scan.next(); // get next symbol

            if (!OPERATORS.contains(symbol)) // operand, not operator
            {
                // convert to double and place on stack
                double number = Double.parseDouble(symbol);
                stack.push(number);
            } else // must be operator
            {
                // pop stack twice, execute operation, and push result

                double opnd2 = stack.pop(); // right-hand operand
                double opnd1 = stack.pop(); // left-hand operand

                if (symbol.equals("$"))
                    stack.push(Math.pow(opnd1, opnd2));
                else if (symbol.equals("*"))
                    stack.push(opnd1 * opnd2);
                else if (symbol.equals("/"))
                    stack.push(opnd1 / opnd2);
                else if (symbol.equals("+"))
                    stack.push(opnd1 + opnd2);
                else // must be "-"

                    stack.push(opnd1 - opnd2);
            }
        }
        // loop postcondition: all symbols of current postfix expression
        // have been processed

        // final result is on top of stack - pop and return
        return stack.pop();
    }
}