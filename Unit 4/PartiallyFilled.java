//  File:  PartiallyFilled.java

//  The instance vars of the class are an array and a counter.  The counter
//  keeps track of the number of array elements actually used (i.e. number of
//  data values stored).  This is the best way to manage an array when it may
//  be only partially filled.  I.e., when you do not know the exact number of 
//  data values to be stored beforehand

//  This is EXACTLY what is done in Java's ArrayList class.  The size()
//  method simply returns the value of the counter

//  Note how the counter is used in the class:  
//  1. it tells you how many values have been stored in the array
//  2. it tells you the index of the next element that will receive a value
//  3. all methods process only the first "count" elements, studiously 
//     avoiding any unused elements (which contain garbage)

//  Also shows how to use Scanner to read any number of data values from the 
//  keyboard until a "sentinel" value signalling end of data is read, how to
//  use Arrays class method copyOf to "resize" an array, and a linear search

import java.util.Arrays; // for copyOf()
import java.util.Scanner;

public class PartiallyFilled {
    // instance variables
    private int[] list; // array with LIMIT elements
    private int count; // number of elements used
    private static final int LIMIT = 3; // initial array size

    /**
     * Create a new PartiallyFilled object with an empty array
     */
    public PartiallyFilled() {
        System.out.println("Creating an array object with " + LIMIT + " elements...\n");
        list = new int[LIMIT];
        count = 0;
    }

    /**
     * Populate the list with ints read from the keyboard until a "sentinel" value
     * of "Q" signals end of data. If the array becomes full, it is resized
     */
    public void readData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any number of ints on any number of lines," + " terminated by \"Q\"");

        while (scan.hasNextInt()) // while not sentinel value...
        {
            int num = scan.nextInt(); // ...extract next int
            list[count++] = num; // ...store in list

            if (count == list.length) // if list is full, resize
            {
                list = Arrays.copyOf(list, count + LIMIT);
            }
        }
        // exactly "count" elements have been used
    }

    /**
     * Do a linear search on the first "count" elements of the array, ignoring any
     * and all unused elements
     * 
     * @param key the value to search for
     * @return the index of the element containing the key or -1 if the key is not
     *         in the array
     */
    public int linearSearch(int key) {
        // search only elements 0..count-1
        for (int i = 0; i < count; i++) {
            if (list[i] == key) // if key found...
            {
                return i; // return index where found
            }
        }
        // here only if key not found
        return -1;
    }

    /**
     * Get the contents of the array as a multi-line string
     */
    public String toString() {
        String out = "";
        for (int i = 0; i < count; i++) {
            out += list[i] + " ";
        }
        return out;
    }

    public static void main(String args[]) {
        PartiallyFilled demo = new PartiallyFilled();
        Scanner input = new Scanner(System.in);

        // populate the array...
        demo.readData();

        // print it...
        System.out.println("\nThe list: " + demo); // calls demo.toString()

        // do 2 searches
        for (int i = 1; i <= 2; i++) {
            System.out.print("\nValue to search for? ");
            int target = input.nextInt();
            int index = demo.linearSearch(target);

            if (index != -1) {
                System.out.println(target + " found in element #" + index);
            } else {
                System.out.println(target + " is not on the list");
            }
        }
    }
}

/*
 * sample output:
 * 
 * Creating an array object with 3 elements...
 * 
 * Enter any number of ints on any number of lines, terminated by "Q" 1 2 3 4 5
 * Q
 * 
 * The list: 1 2 3 4 5
 * 
 * Value to search for? 1 1 found in element #0
 * 
 * Value to search for? 9 9 is not on the list
 * 
 */