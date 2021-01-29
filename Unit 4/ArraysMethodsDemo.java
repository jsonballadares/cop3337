// File: ArraysMethodsDemo.java

// Arrays class methods fill(), sort(), binarySearch(), and equals(),
// and System method arraycopy()
import java.util.Arrays;

public class ArraysMethodsDemo {

    // print an array of Strings
    static void printArray(String[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println("\n");
    }

    // overloaded method to print array of ints
    static void printArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println("\n");
    }

    // search for String "target" in String array "list"
    static void search(String[] list, String target) {
        int position = Arrays.binarySearch(list, target);

        if (position >= 0) {
            System.out.println(target + " found in element #" + position);
        } else {
            System.out.println(target + " not found! position = " + position);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // initialize 2 arrays using special syntax

        int[] numbers = { 2, 5, 8, 10, 41 };

        String[] fruits = { "Strawberries", "Bananas", "Cherries", "Apricots", "Peaches" };

        int[] copy = Arrays.copyOf(numbers, numbers.length); // will become a copy of numbers

        System.out.print("The array \"numbers\":  ");
        printArray(numbers);
        System.out.print("The array \"copy\":  ");
        printArray(copy);

        if (Arrays.equals(numbers, copy)) // are arrays equal?
        {
            System.out.println("Arrays numbers and copy are equal!");
        } else {
            System.out.println("Arrays numbers and copy are NOT equal!");
        }

        System.arraycopy(copy, copy.length - 2, numbers, 0, 2);

        System.out.print("\n\"numbers\" after copying last 2 elements " + "of \"copy\" to the beginning:\n");
        printArray(numbers);

        if (Arrays.equals(numbers, copy)) // are arrays equal?
        {
            System.out.println("Arrays \"numbers\" and \"copy\" are equal!");
        } else {
            System.out.println("Arrays \"numbers\" and \"copy\" are NOT equal!");
        }

        System.out.print("\nThe array \"fruits\":  ");
        printArray(fruits);

        Arrays.sort(fruits); // sort the fruits

        System.out.print("After sorting:  ");
        printArray(fruits);

        search(fruits, "Cherries");
        search(fruits, "Apricots");
        search(fruits, "Cantelope");
        search(fruits, "grapes"); // greater than last element of array
        search(fruits, "Apples"); // less than first element of array
    }
}

/*
 * program output:
 * 
 * The array "numbers": 2 5 8 10 41
 * 
 * The array "copy": 2 5 8 10 41
 * 
 * Arrays numbers and copy are equal!
 * 
 * "numbers" after copying last 2 elements of "copy" to the beginning: 10 41 8
 * 10 41
 * 
 * Arrays "numbers" and "copy" are NOT equal!
 * 
 * The array "fruits": Strawberries Bananas Cherries Apricots Peaches
 * 
 * After sorting: Apricots Bananas Cherries Peaches Strawberries
 * 
 * Cherries found in element #2
 * 
 * Apricots found in element #0
 * 
 * Cantelope not found! position = -3
 * 
 * grapes not found! position = -6
 * 
 * Apples not found! position = -1
 * 
 */