// File: ComparatorTest.java

// Inner class RectangleComparator implements the Comparator strategy interface,
// to provide an ordering for objects of Java's Rectangle class.  In this 
// example, method compare() is implemented so as to order Rectangle objects 
// by their areas.  However, if the areas are equal the rectangles are equal
// only if all 4 instance var's are equal, since the test for equality must
// be the same as in the overridden equals() method. Otherwise, if areas are
// equal but other instance var's are not, the ordering is based on the 
// perimeter, ascending

// Shows how to call the compare() method, and overloaded methods sort()
// and binarySearch() of the Arrays class. The overloaded versions of these
// methods take one additional parameter, which is a Comparator object.
import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;
import java.awt.Rectangle;

public class ComparatorTest {
    // static method to print an array of Rectangles

    public static void print(Rectangle[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(" [" + i + "] " + list[i] + "    area = " + list[i].getWidth() * list[i].getHeight());
        }
    }

    // static method to call binarySearch and print results
    public static void search(Rectangle[] list, Rectangle target, Comparator comp) {
        // 3rd arg to binarySearch is Comparator object variable
        int position = Arrays.binarySearch(list, target, comp);

        if (position >= 0) {
            System.out.println("\n" + target + " found in element #" + position);
        } else {
            System.out.println("\n" + target + " is not in the array");
        }
    }

    public static void main(String[] args) {
        // inner class implements Comparator for Rectangle class
        class RectangleComparator implements Comparator {
            public int compare(Object firstObject, Object secondObject) {
                // order based on area, ascending
                Rectangle r1 = (Rectangle) firstObject;
                double area1 = r1.getWidth() * r1.getHeight();
                Rectangle r2 = (Rectangle) secondObject;
                double area2 = r2.getWidth() * r2.getHeight();

                if (area1 < area2) {
                    return -1; // first param < second
                }
                if (area1 > area2) {
                    return 1; // first param > second
                } else // the two areas are equal
                // BUT, test for equality must be the same as in the equals()
                // method of Rectangle class - i.e. all 4 instance var's - x, y,
                // width, and height - are equal
                {
                    if (r1.equals(r2)) // passes test for equality
                    {
                        return 0; // the two rectangles are equal
                    } else // not all instance var's are equal
                    // here only if equal areas but not all instance var's equal.
                    // So, the two Rectangles cannot be equal. So we still have to
                    // order them. Here's an easy way: base order on perimeter
                    {
                        // compute perimeter of first Rectangle
                        double r1Perim = 2 * (r1.getWidth() + r1.getHeight());
                        // compute perimeter of second Rectangle
                        double r2Perim = 2 * (r2.getWidth() + r2.getHeight());
                        if (r1Perim <= r2Perim) // perim of first is lesser
                        {
                            return -1; // r1 comes before r2 (although equal areas)
                        } else // perimeter of first Rectangle is greater
                        {
                            return 1; // r1 comes after r2
                        }
                    }
                }
            }
        }

        Random r = new Random();

        RectangleComparator comp = new RectangleComparator();

        Rectangle[] list = new Rectangle[8];

        // fill array with randomly-generated Rectangle objects where x, y,
        // width, and height are random ints in the range 1..9, inclusive

        for (int i = 0; i < list.length; i++) {
            int x = r.nextInt(9) + 1;
            int y = r.nextInt(9) + 1;
            int width = r.nextInt(9) + 1;
            int height = r.nextInt(9) + 1;
            list[i] = new Rectangle(x, y, width, height);
        }

        System.out.println("The array before sorting:");
        print(list);

        // 2nd arg to overloaded sort is Comparator object variable
        Arrays.sort(list, comp);

        System.out.println("\nThe array after sorting:");
        print(list);

        // search for whatever Rectangle is in a "middle" element!
        Rectangle r1 = list[list.length / 2];
        search(list, r1, comp);

        // search for a randomly-generated Rectangle
        Rectangle r2 = new Rectangle(r.nextInt(9) + 1, r.nextInt(9) + 1, r.nextInt(9) + 1, r.nextInt(9) + 1);
        search(list, r2, comp);

        // show how compare() works
        if (comp.compare(r1, r2) < 0) {
            System.out.println("\n" + r1 + " is less than\n" + r2);
        } else if (comp.compare(r1, r2) > 0) {
            System.out.println("\n" + r1 + " is greater than\n" + r2);
        } else {
            System.out.println("\n" + r1 + " and " + r2 + " are equal");
        }
    }
}
