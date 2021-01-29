
// File: OrderedList.java
/*
 Maintains a list of ints in ascending order.  New ints are inserted at the
 proper index so there is never a need to sort the list. User-specified ints
 may also be removed from the list

 Shows exactly what happens "automatically" (LOL!) in ArrayList class methods
 add(index,object), remove(index), and remove(object)
*/
import java.util.Arrays; // for method copyOf
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Maintains a list of ints sorted in ascending order. New ints may be inserted
 * into the list, and ints may be removed from the list
 */
public class OrderedList {
    // instance variables
    private int[] sorted; // ascending list of ints
    private int count; // number of array elements used
    private static final int SIZE = 3; // initial capacity of list

    /**
     * Create an empty list with "SIZE" elements
     */
    public OrderedList() {
        sorted = new int[SIZE];
        count = 0;
    }

    /**
     * Inserts an int in its proper place in the ordered list
     * 
     * @param arg the int to be inserted
     */
    public void insert(int arg) {
        // if array is full, resize it
        if (count == sorted.length) {
            // create copy of sorted with SIZE additional elements and point
            // sorted at it
            sorted = Arrays.copyOf(sorted, count + SIZE);
        }

        // Find index of the first value > arg (if there is one)
        // and insert arg at that index. If there is no greater
        // value in the array, arg is inserted as the new last
        // element.
        // If the array is empty, arg is stored at index 0

        boolean found = false; // is there a larger value in the array?

        // while more elements and larger value not yet found
        for (int i = 0; i < count && !found; i++) {
            if (sorted[i] > arg) // found it!
            {
                found = true; // set flag to exit loop

                /**************************************************
                 * Note to students: lines 67-76 are the guts of * ArrayList method
                 * "add(i,object)" after first * resizing the array if it was full (lines 41-46)
                 * *
                 **************************************************/

                // for each element from last to element i (where
                // the new value will go)...
                for (int j = count; j > i; j--) {
                    // ... move current value "down" one element
                    sorted[j] = sorted[j - 1];
                }
                // insert new value at index i and update size of list
                sorted[i] = arg;
                count++;
            }
        }
        // if no greater value was found or the list is empty insert
        // arg as new last element
        if (!found) {
            sorted[count++] = arg;
        }
    }

    /*****************************************************
     * Note to students: this next method is exactly what * happens in ArrayList
     * method "remove(object)" *
     *****************************************************/

    /**
     * Searches the list for an int to be removed. If found, removes it and returns
     * true; if not found, returns false. If the list has duplicates, only the first
     * is removed
     * 
     * @param seeYa the number to be removed
     * @return true if seeYa was on the list; else false
     */
    public boolean remove(int seeYa) {
        boolean found = false; // is seeYa on the list?
        int index = 0; // start with first valus
        while (index < count && !found) // while more values and not yet found
        {
            if (sorted[index] == seeYa) // if found...
            {
                found = true; // ...set flag to stop search
            } else // not found yet...
            {
                index++; // ...check next element
            }
        }
        // was seeYa found on the list?
        if (!found) // no, it wasn't
        {
            return false;
        }

        // here only if seeYa was found (in element "index") - remove it

        /***************************************************
         * Note to students: lines 127-132 are exactly what * happens in ArrayList
         * method "remove(index)" *
         ***************************************************/

        // for each element from position index+1 to last element...
        for (int i = index; i < count - 1; i++) {
            sorted[i] = sorted[i + 1]; // ...move "up" one element
        }
        count--; // update size of list
        return true; // found and removed
    }

    /**
     * Returns the list as a String
     * 
     * @return the ints on the list as a String
     */
    public String toString() {
        String out = "";
        for (int i = 0; i < count; i++) {
            out += sorted[i] + " ";
        }
        return out;
    }

    public static void main(String args[]) {
        OrderedList list = new OrderedList();

        Random generator = new Random();

        // insert 10 random positive 2-digit ints into the list
        for (int i = 1; i <= 10; i++) {
            int num = generator.nextInt(90) + 10;
            System.out.println("Inserting " + num);
            list.insert(num);
        }

        // print the list
        System.out.println("\nThe list: " + list); // calls list.toString

        // user enters ints to be removed from the list
        String remove = JOptionPane.showInputDialog("Enter number to remove" + "\n(or Cancel to quit)");
        while (remove != null) {
            int num = Integer.parseInt(remove);
            if (list.remove(num)) // num was on the list and has been deleted
            {
                System.out.println("\n" + num + " has been deleted");
                System.out.println("\nThe updated list: " + list);
            } else {
                System.out.println("\nLo siento, " + num + " is not on the list");
            }
            remove = JOptionPane.showInputDialog("Next number to remove?" + "\n(Cancel to quit)");
        }
    }
}