//  File:  ArrayDemo.java

//  Creates an int array of exactly "size" elements, where size is a
//  random int between 25 and 50, inclusive.  Fills the array with 
//  random ints between 10 and 99, inclusive, and prints it.  Then sorts
//  the array and prints it again.
//
//  Shows a class with an array instance variable, declaring an array
//  object variable and creating an array object, traversing an array
//  using a "for" statement, the "length" instance variable, and using
//  random ints.
//
//  Note: To get a random int between two positive ints, a and b, inclusive,
//  using a Random object, r, use:  r.nextInt(b - a + 1) + a
import java.util.Random;

class BogusList {
    // instance variable - an int array object variable
    private int[] list;

    public BogusList(int size) // constructor
    {
        System.out.println("Creating an array object with " + size + " elements...\n");
        list = new int[size];
    }

    public void fill() // fill array w/ random ints
    {
        Random r = new Random();
        System.out.println("Filling array with " + list.length + " random ints between 10 and 99, inclusive...\n");
        for (int i = 0; i < list.length; i++) {
            list[i] = r.nextInt(90) + 10;
        }
    }

    public void sort() // ascending selection sort
    {
        // for each element, i, from 0 to next-to-last...
        for (int i = 0; i < list.length - 1; i++) {
            // ...find smallest value in elements i+1 through last...
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minPos]) {
                    minPos = j;
                }
            }
            // ...and swap it with element i
            int temp = list[i];
            list[i] = list[minPos];
            list[minPos] = temp;
        }
    }

    public void print() // print array 10 elements per line
    {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "   ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

public class ArrayDemo {

    public static void main(String args[]) {
        // create random number generator object, called r...
        Random r = new Random();

        // get random number between 25 and 50, inclusive, for size of array
        int listSize = r.nextInt(26) + 25;

        // pass array size to BogusList constructor...
        BogusList numbers = new BogusList(listSize);

        // fill the array...
        numbers.fill();

        // print it...
        System.out.println("The original list:\n");
        numbers.print();

        // sort it...
        numbers.sort();

        // print sorted array...
        System.out.println("\nThe sorted list:\n");
        numbers.print();

        System.out.println();
    }
}

/*
 * Sample output:
 * 
 * Creating an array object with 37 elements...
 * 
 * Filling array with 37 random ints between 10 and 99, inclusive...
 * 
 * The original list:
 * 
 * 95 87 84 28 50 40 93 86 67 32 33 67 96 94 89 66 44 62 28 92 33 70 43 76 68 53
 * 44 74 23 29 49 70 36 46 77 46 79
 * 
 * The sorted list:
 * 
 * 23 28 28 29 32 33 33 36 40 43 44 44 46 46 49 50 53 62 66 67 67 68 70 70 74 76
 * 77 79 84 86 87 89 92 93 94 95 96
 * 
 */