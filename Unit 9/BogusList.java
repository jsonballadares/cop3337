// File:  BogusList.java
// Creates a simple "generic" list - a list that can store objects of any class.
// The "genericity" is implemented via "type variables" (added in Java 1.5), as 
// used in the Java API

// (Prior to Java 1.5, genericity was achieved by having the container classes
// store objects of class Object.  This required clients to explicity downcast
// the Object objects back to their native class type)
// The list has limited functionality. Clients can only:
//   1. append objects to the list 
//   2. clear the list
//   3. print the list, and
//   4. search the list for a particular item
// The class also provides an "iterator" so that clients may access the 
// individual items on the list without having to know how the list is 
// implemented (it's an array).

// This is an example of the OOP principal of "information hiding."  Since the 
// list implementation is hidden from clients, the author of the class could 
// change the implementation (say, to an ArrayList), and all existing client 
// code that works with the old implementation will also work with the new, as 
// long as the user interface (the set of public methods) remains the same.
// NOTE:  This class is not "safe!"  BogusList users must heed these warnings:
//   1. Do not ask if there are more items unless you have set the iterator!
//   2. Do not try to retrieve the next item unless you have set the iterator!
//   3. Do not try to retrieve the next item unless you are sure there IS one!
//   4. Do not go swimming within a half-hour after eating!
import java.util.Arrays;

/**
 * Implements a simple generic list with limited functionality
 */
public class BogusList<E> {

    private E[] items; // list implemented as generic array
    private int size; // number of array elements used
    private int iterator; // list iterator
    private static final int MAX_SIZE = 100; // initial array size

    /**
     * Create an empty list
     */
    public BogusList() {
        // Note: to create generic array, must create array of Objects and
        // "type cast" to array of the type variable
        items = (E[]) new Object[MAX_SIZE];
        size = 0;
    }

    /**
     * Append an item to the end of the list
     *
     * @param newItem the object to be appended
     */
    public void append(E newItem) {
        // if the list is full, resize it
        if (size == items.length) {
            E[] temp = (E[]) new Object[size + MAX_SIZE];
            System.arraycopy(items, 0, temp, 0, size);
            items = temp;
        }
        items[size++] = newItem;
    }

    /**
     * Make the list empty.
     */
    public void clear() {
        size = 0;
    }

    /**
     * Is a particular object on the list?
     *
     * Precondition: The equals() method must be overridden in whatever class of
     * objects is stored on the list
     *
     * @param target the object to search for
     * @return true if target is on the list, false if not.
     */
    public boolean contains(E target) // linear search
    {
        for (int i = 0; i < size; i++) {
            /*
             * Note that the "enhanced for" cannot be used here because it will always visit
             * ALL the elements of the array. If the array has any unused elements, those
             * elements will contain null references and - if the target is not found - a
             * nullPointerException will be thrown when the "equals" method is called for
             * the first null reference encountered
             */
            E current = items[i];
            if (current.equals(target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return a String containing all the objects on the list
     *
     * Precondition: The toString() method must be overridden in whatever class of
     * objects is stored on the list
     *
     * @return the list as a String
     */
    public String toString() {
        String out = "";
        for (int i = 0; i < size; i++) {
            out += items[i] + "  ";
        }
        return out + "\n";
    }

    // ************* iterator methods *************
    /**
     * Set the iterator to position just before the start of the list
     */
    public void setIterator() {
        iterator = -1;
    }

    /**
     * Are there more items on the list?
     *
     * Precondition: The iterator must be set
     *
     * @return true if at least one more item on the list, false if not
     */
    public boolean more() {
        return iterator < size - 1;
    }

    /**
     * Advance iterator to the next item on the list and return it
     *
     * Precondition: The iterator must be set and must not be pointing to the last
     * object on the list
     *
     * @return the object to which the iterator is pointing after advancing
     */
    public E next() {
        return items[++iterator];
    }
} // =========================================================================