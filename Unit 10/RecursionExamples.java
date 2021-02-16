// File: RecursionExamples.java

// Class contains a number of unrelated recursive methods and a main method
// that tests them all.
import java.util.Arrays;
import java.util.Scanner;

public class RecursionExamples {
    public static void printReversed(int n) {
        if (n < 0) // error
        {
            System.out.println("Sorry, number must be non-negative!");
        } else if (n <= 9) // trivial case: single-digit integer...
        {
            System.out.print(n); // ... print it and we're done
        } else // multi-digit number ...
        {
            System.out.print(n % 10); // ... print last digit
            printReversed(n / 10); // ... remove last digit and print
                                   // what's left, recursively
            // ret. addr. B
        }
    }

    public static int fibonacci(int n) {
        if (n <= 0) // error, so return bogus value
        {
            System.out.println("Sorry, number must be positive!");
            return -999;
        } else if (n == 1 || n == 2) // trivial cases: first or second term
        {
            return 1;
        } else // other terms = sum of 2 previous terms
        {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    public static void printReversed(int a[], int count) {
        if (count == 1) // trivial case: single-element array
        {
            System.out.print(a[0]); // ...print it
        } else // multiple elements ...
        {
            System.out.print(a[count - 1] + "  "); // print last element...
            printReversed(a, count - 1); // ...print remaining elements
        }
    }

    public static boolean isEqual(int a[], int b[], int count) {
        if (count == 1) // TC: single-element arrays
        {
            return a[0] == b[0];
        } else {
            return (a[count - 1] == b[count - 1] && isEqual(a, b, count - 1));
        }
        // arrays are equal if last elements are equal and corresponding
        // elements 0 thru next-to-last are equal
    }

    public static void main(String args[]) {
        // Tests the recursive methods
        Scanner input = new Scanner(System.in);

        int number;
        System.out.print("Enter a positive integer: ");
        number = input.nextInt();
        System.out.print("The number " + number + " reversed is: ");
        printReversed(number); // return address A
        System.out.println('\n');

        int nthTerm;
        System.out.print("Which term in fibonacci sequence? ");
        nthTerm = input.nextInt();
        System.out.println("The " + nthTerm + "th term is: " + fibonacci(nthTerm) + '\n');

        int a[] = { 2, 5, 8, 10, 41 };
        int b[] = { 2, 5, 8, 10, 41 };

        int count = a.length; // number of elements

        System.out.print("Here's the array in reverse order: ");
        printReversed(a, count);
        System.out.println('\n');

        if (isEqual(a, b, count)) {
            System.out.println("The arrays are equal!\n");
        } else {
            System.out.println("The arrays are NOT equal!\n");
        }
    }
}

/*
 * sample output
 * 
 * Enter a positive integer: 67890 The number 67890 reversed is: 09876
 * 
 * Which term in fibonacci sequence? 11 The 11th term is: 89
 * 
 * Here's the array in reverse order: 41 10 8 5 2
 * 
 * Here's the array in original order: 2 5 8 10 41
 * 
 * The arrays are equal!
 * 
 */