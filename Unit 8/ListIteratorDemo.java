import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

// File: ListIteratorDemo.java

// Shows List method listIterator(), and listIterator methods hasNext(), 
// next(), hasPrevious(), previous(), and remove()

public class ListIteratorDemo {
    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) // for each item on list...
        {
            System.out.print(list.get(i) + "  "); // ...print item
        }
        System.out.println('\n');
    }

    // uses a listIterator object to remove all odd ints from a List
    public static void removeOdds(List<Integer> list) {
        // get iterator pointing just before start of list
        ListIterator<Integer> it = list.listIterator();

        System.out.println("removing odd integers...");

        // iterate through list...
        while (it.hasNext()) // while more ints on list...
        {
            int number = it.next(); // get next int
            if (number % 2 == 1) // if it's odd...
            {
                it.remove(); // ...delete it
            }
        }
    }

    // uses a listIterator object to print a List in reverse order
    public static void printReversed(List list) {
        // get iterator pointing just past the end of the list
        ListIterator it = list.listIterator(list.size());

        System.out.println("printing list in reverse order...");

        // move backwards to start of list
        while (it.hasPrevious()) // while more ints on list
        {
            System.out.print(it.previous() + "  ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Random r = new Random();

        // add 10 positive 2-digit random ints to list
        for (int i = 1; i <= 10; i++) {
            int num = r.nextInt(90) + 10;
            list.add(num);
        }

        System.out.println("printing original list...");
        printList(list);

        // use Iterator to remove all odd ints
        removeOdds(list);

        System.out.println("\nprinting updated list...");
        printList(list);

        // use Iterator to print list in reverse order
        printReversed(list);
    }
}

/*
 * program output
 * 
 * printing original list... 59 33 98 34 82 75 35 96 69 15
 * 
 * removing odd integers...
 * 
 * printing updated list... 98 34 82 96
 * 
 * printing list in reverse order... 96 82 34 98
 * 
 */