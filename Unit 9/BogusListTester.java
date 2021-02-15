// File:  BogusListTester.java

// A simple test class for the generic BogusList class.  In this example, we
// create two BogusLists of ints.  I.e. the "type variable" passed to the 
// BogusList class is Integer.
// The listPositives() method shows how to use the BogusList iterator to
// traverse the list
import java.util.Random;

public class BogusListTester {

    public static void listPositives(BogusList<Integer> newList, BogusList<Integer> oldList) {
        // Copy all positive ints from oldList to newList

        oldList.setIterator(); // point cursor to head of oldList
        while (oldList.more()) // while more items on oldList...
        {
            // advance iterator to next item and return it
            int currentItem = oldList.next();

            if (currentItem > 0) // if positive number...
            {
                newList.append(currentItem); // ...append to newList
            }
        }
    }

    public static void main(String[] args) {
        BogusList<Integer> aList = new BogusList<Integer>();
        BogusList<Integer> bList = new BogusList<Integer>();

        Random r = new Random();

        // append 10 random ints in range -99..99 to aList
        for (int i = 1; i <= 10; i++) {
            aList.append(r.nextInt() % 100);
        }

        System.out.println("Printing the \"A\" list:\n" + aList);

        // copy positive ints to bList
        listPositives(bList, aList);

        System.out.println("Printing the \"B\" list:\n" + bList);

        // is 37 on bList?
        if (bList.contains(37)) {
            System.out.println(37 + " IS on the \"B\" list\n");
        } else {
            System.out.println(37 + " is NOT on the \"B\" list\n");
        }
    }
}

/*
 * program output:
 * 
 * Printing the "A" list: -77 -83 86 48 79 -36 -95 83 5 82
 * 
 * Printing the "B" list: 86 48 79 83 5 82
 * 
 * 37 is NOT on the "B" list
 * 
 */