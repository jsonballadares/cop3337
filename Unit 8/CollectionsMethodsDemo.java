
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// File: CollectionsMethodsDemo.java

// Shows Collections class methods sort(), reverse(), shuffle(), binarySearch(), 
// min(), and max(), and how to use the value returned by binarySearch() 
// to insert an object in its proper place in a sorted list if it is not
// already in the list
// Also, the "enhanced" for statement (aka: "for each")

public class CollectionsMethodsDemo {
    // note that parameter is type List, so accepts ArrayList or LinkedList
    // argument. If efficiency is important, can use one or the other.

    public static void printList(List<String> list) {
        for (String current : list) // for each item on list...
        {
            System.out.print(current + "  ");
        }
        System.out.println('\n');
    }

    public static void main(String args[]) {
        String collections1[] = { "stamps", "baseball cards", "coins" };
        String collections2[] = { "Barbie dolls", "autographs" };

        ArrayList<String> collectables = new ArrayList<String>(Arrays.asList(collections1));
        // could have declared: ArrayList<String> collectables = ...

        System.out.println("printing original list...");
        printList(collectables);

        collectables.addAll(Arrays.asList(collections2));

        System.out.println("printing list after concatenation...");
        printList(collectables);

        Collections.reverse(collectables);
        System.out.println("printing list after reverse...");
        printList(collectables);

        Collections.shuffle(collectables);
        System.out.println("printing list after shuffle...");
        printList(collectables);

        System.out.println("smallest value in the list is: " + Collections.min(collectables) + '\n');

        System.out.println("largest value in the list is: " + Collections.max(collectables) + '\n');

        Collections.sort(collectables);
        System.out.println("printing list after sort...");
        printList(collectables);

        // use binarySearch() and add() to insert an object at its
        // proper place in a sorted list

        int pos = Collections.binarySearch(collectables, "coupons");
        System.out.println("search for \"coupons\" returns " + pos);

        if (pos < 0) // if not found
        {
            collectables.add(-(pos + 1), "coupons");
            System.out.println("\nprinting list after inserting \"coupons\"...");
            printList(collectables);
        }
    }
}

/*
 * program output:
 * 
 * printing original list... stamps baseball cards coins
 * 
 * printing list after concatenation... stamps baseball cards coins Barbie dolls
 * butterflies
 * 
 * printing list after reverse... butterflies Barbie dolls coins baseball cards
 * stamps
 * 
 * printing list after shuffle... coins baseball cards Barbie dolls stamps
 * butterflies
 * 
 * smallest value in the list is: Barbie dolls
 * 
 * largest value in the list is: stamps
 * 
 * printing list after sort... Barbie dolls baseball cards butterflies coins
 * stamps
 * 
 * search for "coupons" returns -5
 * 
 * printing list after inserting "coupons"... Barbie dolls baseball cards
 * butterflies coins coupons stamps
 * 
 */