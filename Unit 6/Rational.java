// File: Rational.java

// Shows how to implement ("realize") the Comparable interface by overriding 
// the compareTo method.  

// Note: In the interest of brevity, methods to add, subtract, multiply, and
//       divide Rational objects are not shown

/**
 * A class to represent rational numbers. I.e., any number that can be expressed
 * as the quotient of 2 integers (i.e., a "fraction", such as 3/7). Rational
 * objects are always reduced to lowest terms.
 */
class Rational implements Comparable {
    // instances var's
    private int numerator;
    private int denominator;

    /**
     * No-argument constructor creates Rational object 0/1
     */
    public Rational() {
        this(0, 1); // calls 2-arg constructor, passing 0 and 1
    }

    /**
     * One-argument constructor creates Rational object with numerator specified by
     * user and denominator of 1.
     * 
     * @param num the numerator
     */
    public Rational(int num) {
        this(num, 1); // calls 2-arg constructor, passing numerator and 1
    }

    /**
     * Two-argument constructor creates Rational object with numerator and
     * denominator specified by user.
     * 
     * @param num   the numerator
     * @param denom the denominator Postconditions: 1. the Rational object created
     *              is reduced to lowest terms 2. the denominator will be positive
     *              3. if the user specifies a zero denominator, 0/1 is created
     *              instead
     */
    public Rational(int num, int denom) {
        if (denom == 0) // denominator of 0? Create 0/1
        {
            numerator = 0;
            denominator = 1;
        } else if (denom < 0) // handle negative denominator...
        {
            numerator = -num; // Ex. 3,-7 will create -3/7
            denominator = -denom; // Ex. -3,-7 will create 3/7
            reduce(); // reduce to lowest terms
        } else // denominator > 0 so use it...
        {
            numerator = num;
            denominator = denom;
            reduce(); // ...and reduce to lowest terms
        }
    }

    /**
     * Convert a Rational object to a primitive double value.
     * 
     * @return the decimal equivalent of the Rational object
     */
    public double toDecimal() {
        return (double) numerator / denominator;
    }

    /**
     * Convert a Rational to a String.
     * 
     * @return a string in the form "x/y"
     */
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Are two rational objects equal?
     * 
     * @param other Rational object tested for equality to implicit param
     * @return true if Rationals are equal, false if not equal
     */
    public boolean equals(Object other) {
        if (!(other instanceof Rational)) // explicit param not a rational...
            return false; // ...so can't be equal

        Rational that = (Rational) other; // safe downcast to Rational

        // since Rationals are always stored reduced to lowest terms, here's
        // the test for equality
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    /**
     * Overridden compareTo method orders Rational objects by their decimal values.
     * 
     * @param otherObject explicit parameter to which the implicit parameter is
     *                    being compared.
     * @return -1 if implicit param < explicit 0 if implicit param == explicit 1 if
     *         implicit param > explicit
     */
    public int compareTo(Object otherObject) {
        Rational other = (Rational) otherObject;
        if (this.toDecimal() < other.toDecimal())
            return -1;
        else if (this.toDecimal() > other.toDecimal())
            return 1;
        else // otherwise, they are equal
            return 0;
    }

    // "Utility" method (i.e., called only by other methods of the class and
    // not by clients) to reduce a Rational to lowest terms.
    // Not part of public interface to the class, so declared private and no
    // "javadoc" comments
    // Precondition: denominator > 0 (always true for all Rational objects)
    // Postcondition: Rational object is reduced to lowest terms
    private void reduce() {
        if (numerator == 0) // e.g. 0/7 "reduced" to 0/1
        {
            denominator = 1;
            return;
        }

        // find the greatest common divisor (GCD) of numerator and denominator

        int tryDiv = Math.min(Math.abs(numerator), denominator);

        while (numerator % tryDiv != 0 || denominator % tryDiv != 0)
            tryDiv--;
        // Loop postcondition: tryDiv is GCD of numerator and denominator

        // divide numerator and denominator by their GCD
        numerator /= tryDiv;
        denominator /= tryDiv;
    }
}