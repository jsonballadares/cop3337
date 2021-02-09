// File: RationalSortAndSearch.java

// A test class for the Rational class, which implements the Comparable
// interface and orders Rational objects by their decimal values.  The 
// decimal value is returned by method toDecimal()
// Demonstrates calling the compareTo method, and how you can use Arrays
// class methods sort() and binarySearch() with arrays of objects of any
// class, as long as that class implements the Comparable interface.
import java.util.Arrays;
import java.util.Random;

public class RationalSortAndSearch {
    public static void print(Rational[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].toDecimal() >= 0) {
                System.out.print(" ");
            }
            System.out.print(" " + list[i] + " = ");
            if (list[i].toDecimal() >= 0) {
                System.out.print(" ");
            }
            System.out.printf("%.4f%n", list[i].toDecimal());
        }
    }

    public static void search(Rational[] list, Rational target) {
        int position = Arrays.binarySearch(list, target);

        if (position >= 0) {
            System.out.println("\n" + target + " found in element #" + position);
        } else {
            System.out.println("\n" + target + " is not in the array");
        }
    }

    public static void main(String[] args) {
        Random r = new Random();

        Rational[] list = new Rational[8];

        // fill array with Rational objects where numerators and denominators
        // are random ints in the range -9..+9, inclusive
        for (int i = 0; i < list.length; i++) {
            int num = r.nextInt() % 10;
            int denom = r.nextInt() % 10;
            list[i] = new Rational(num, denom);
        }

        System.out.println("The array before sorting:");
        print(list);

        Arrays.sort(list);
        System.out.println("\nThe array after sorting:");
        print(list);

        // search for whatever Rational is in a "middle" element!
        Rational r1 = list[list.length / 2];
        search(list, r1);

        // search for a randomly-generated Rational
        Rational r2 = new Rational(r.nextInt() % 10, r.nextInt() % 10);
        search(list, r2);

        // show how compareTo works
        if (r1.compareTo(r2) < 0) {
            System.out.println("\n" + r1 + " is less than " + r2);
        } else if (r1.compareTo(r2) > 0) {
            System.out.println("\n" + r1 + " is greater than " + r2);
        } else {
            System.out.println("\n" + r1 + " and " + r2 + " are equal!");
        }
    }
}

/*
 * sample output:
 * 
 * The array before sorting: 0/1 = 0.0000 3/7 = 0.4286 8/7 = 1.1429 -2/1 =
 * -2.0000 3/1 = 3.0000 1/2 = 0.5000 -7/3 = -2.3333 -1/7 = -0.1429
 * 
 * The array after sorting: -7/3 = -2.3333 -2/1 = -2.0000 -1/7 = -0.1429 0/1 =
 * 0.0000 3/7 = 0.4286 1/2 = 0.5000 8/7 = 1.1429 3/1 = 3.0000
 * 
 * 3/7 found in element #4
 * 
 * 1/1 is not in the array
 * 
 * 3/7 is less than 1/1
 * 
 */