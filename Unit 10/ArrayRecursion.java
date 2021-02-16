/*  File: ArrayRecursion.java
 *
 *  Programmer: your name
 *
 */

import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A class that performs some simple array operations recursively
 */
public class ArrayRecursion {
    // instance var's
    private int[] list; // array of ints
    private int count; // number of elements

    /**
     * Create an ArrayRecursion object. Creates an array with between 10 and 15
     * elements, and fills it with random positive 2-digit ints
     */
    public ArrayRecursion() {
        Random r = new Random();
        count = r.nextInt(6) + 10;
        list = new int[count];

        for (int i = 0; i < count; i++) {
            list[i] = r.nextInt(90) + 10;
        }
    }

    /**
     * Return the list as a string
     * 
     * @return a string containing all the ints stored in list
     */
    public String toString() {
        String out = "";
        for (int i = 0; i < count; i++) {
            out += list[i] + "  ";
        }
        return out + "\n";
    }

    /**
     * Returns the smallest value in the array.
     * 
     * @return the smallest value in the array
     */
    public int getSmallest() {
        return recursiveGetSmallest(list, count);
    }

    // recursive "helper" method returns the smallest value in list.
    // called by public method getSmallest()
    private int recursiveGetSmallest(int[] list, int count) {
        // TO DO: write body of this method
        return -999; // Bogus return value so skeleton will compile and execute
    }

    /**
     * Reverse the elements of the array
     */
    public void reverse() {
        recursiveReverse(list, 0, count);
    }

    // recursive "helper" method to reverse the array.
    // called by public method reverse()
    private void recursiveReverse(int[] list, int first, int count) {
        // TO DO: write body of this method
    }

    /**
     * Does the array contain two or more consecutive ints, ascending or descending?
     * 
     * @return true if array contains any consecutive ints; otherwise false
     */
    public boolean hasConsecutives() {
        return recursiveHasConsecutives(list, count);
    }

    // recursive "helper" method called by public method hasConsecutives()
    private boolean recursiveHasConsecutives(int[] list, int count) {
        // TO DO: write body of this method
        return false; // Bogus return value so skeleton will compile and execute
    }

    public static void main(String[] args) {
        ArrayRecursion list = new ArrayRecursion();

        System.out.println("\nOriginal:  " + list);

        System.out.println("Smallest value in the array is " + list.getSmallest());
        list.reverse();
        System.out.println("\nReversed:  " + list);

        System.out.println("The list " + (list.hasConsecutives() ? "has" : "does not have")
                + " consecutive ints in consecutive elements");
    }
}
