
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// File: CollectionDemo.java

// Shows  Collection method iterator(), Collection Iterator methods hasNext(),
// next(), and remove(), and List methods add(), size(), and get()

/* Note:

  1. the ArrayList object created at line 56 is not a generic ArrayList
     (e.g. ArrayList<Integer>, ArrayList<BankAccount>, etc) but the "legacy"
     ArrayList, which stores only objects of the ultimate superclass, Object 

  2. objects of any class as well as primitives may be added to such a List

  3. if you add an object, it is implicitly "upcasted" to superclass Object

  4. if you add a primitive, "autoboxing" creates an object of the associated 
     wrapper class which is then implicitly "upcasted" to superclass Object

  5. when you call Collection iterator method "next" (or List method "get") 
     what is returned is an Object object, which may then be explicity 
     "downcast" to its native class (see lines 42-45)
*/
public class CollectionDemo {
    public static double addAndDeleteDoubles(Collection c) {
        // return sum of all doubles in a collection and remove them

        double sum = 0;

        Iterator i = c.iterator(); // get iterator for collection c

        while (i.hasNext()) // more items in the collection...
        {
            Object temp = i.next(); // ... get next Object
            if (temp instanceof Double) // ... if it's a Double...
            {
                sum += (Double) temp; // ...downcast and add to sum
                i.remove(); // ...and delete it
            }
        }

        return sum;
    }

    public static void main(String args[]) {
        String colors[] = { "yellow", "cyan", "magenta" };

        // create an empty ArrayList-of-Object
        ArrayList aList = new ArrayList();

        // add a Double to end of aList
        aList.add(1.23);

        // add contents of array colors[] to end of aList
        for (int k = 0; k < colors.length; k++)
            aList.add(colors[k]);

        // add another double as new fourth item
        aList.add(3, 2.34);

        System.out.println("\nprinting aList:\n");
        for (int k = 0; k < aList.size(); k++)
            System.out.print(aList.get(k) + " ");

        double sum = addAndDeleteDoubles(aList);

        System.out.println("\n\nThe sum of all doubles in aList = " + sum);

        System.out.println("\nprinting aList after addAndDelete:\n");
        for (int k = 0; k < aList.size(); k++)
            System.out.print(aList.get(k) + " ");
        System.out.println();
    }
}

/*
 * program output:
 * 
 * printing aList:
 * 
 * 1.23 yellow cyan 2.34 magenta
 * 
 * The sum of all doubles in aList = 3.57
 * 
 * printing aList after addAndDelete:
 * 
 * yellow cyan magenta
 * 
 */