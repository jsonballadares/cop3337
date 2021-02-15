// File:  MyLinkedListTester.java

// A simple test class for the MyLinkedList class (i.e, version 2 of 
// the BogusList class)  
// This test class is the same as used with the BogusList class
import java.util.Random;

public class MyLinkedListTester {
    // copies all positive ints from oldList to newList
    public static void listPositives(MyLinkedList<Integer> newList, MyLinkedList<Integer> oldList) {
        oldList.setIterator(); // point iterator to head of oldList
        while (oldList.more()) // while more nodes on oldList...
        {
            // advance iterator to next node and return object stored
            int currentItem = oldList.next();

            if (currentItem > 0) // if positive int...
            {
                newList.append(currentItem); // ...append it to newList
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> aList = new MyLinkedList<Integer>();
        MyLinkedList<Integer> bList = new MyLinkedList<Integer>();

        Random r = new Random();

        // append 10 random single-digit or 2-digit ints to aList
        for (int i = 1; i <= 25; i++) {
            aList.append(r.nextInt() % 100);
        }

        System.out.println("Printing the \"A\" list:\n" + aList);

        // copy positive ints on aList to bList
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
 * Printing the "A" list: 26 -8 -71 73 58 34 73 -78 -62 33
 * 
 * Printing the "B" list: 26 73 58 34 73 33
 * 
 * 37 is NOT on the "B" list
 * 
 */