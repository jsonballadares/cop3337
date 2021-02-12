// File: ArrayAsList.java

// Uses Arrays method asList() to create a "list view" of an array,
// Then uses List methods get() to return a value stored in a list
// and set() to store a new value in a specified position in a list.

// Shows that any changes made to the list view affect the original array
// and vice-versa.

import java.util.*; // for List interface

class ArrayAsList {
    static void printBoth(String[] music, List theList) {
        System.out.println("printing the array...");
        for (int i = 0; i < music.length; i++)
            System.out.print(music[i] + "   ");

        System.out.println("\n\nprinting the List...");
        for (int i = 0; i < theList.size(); i++)
            System.out.print(theList.get(i) + "   ");

        System.out.println();
    }

    public static void main(String args[]) {
        String[] music = { "jazz", "blues", "rock", "reggae" };
        List theList;

        // create "list view" of the array
        theList = Arrays.asList(music);

        // change a list item
        theList.set(3, "rap");

        // The following would throw an UnsupportedOperationException! Although
        // we have a "list view" of an array, it's still a fixed-size array!

        // theList.add("folk") ;

        // change an array element
        music[0] = "classical";

        printBoth(music, theList);
    }
}

/*
 * program output:
 * 
 * printing the array... classical blues rock rap
 * 
 * printing the List... classical blues rock rap
 * 
 */