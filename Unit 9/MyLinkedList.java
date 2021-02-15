/*
File:  MyLinkedList.java    (Version 2 of the "BogusList" class)

Version 2 of the BogusList class provides the same limited functionality 
and has the same user interface (i.e. public methods) as the previous version

However, the implementation has been changed to a generic linked list of 
nodes.

NOTE: the class is still not "safe" and users must heed the same warnings 
as in the previous versions:

1. Do not ask if there are more items unless you have set the iterator!
2. Do not try to retrieve the next item unless you have set the iterator!
3. Do not try to retrieve the next item unless you are sure there IS one!
4. Do not run with scissors!

Some other things to note:

1. Inner class Node is hidden from the outside world because "friendly" 
access is used (aka: "package" access)

2. All members of an inner class are freely accessible to the outer class, 
even if declared private

3. Method clear() empties the list by setting "head" (the pointer to the
first node) to null. Because nodes can only be accessed sequentially,
there is no longer any way to access any of the nodes.  So all nodes 
will be scheduled (sequentially) for garbage collection

4. In contrast to the previous version, there is no longer a need for 
append() to check if list is full. Unlike the fixed-size array, dynamic data 
structures like linked lists can never be "full," unless you use up all of the
memory the system allows you for your program
 */

/**
 * Implements a simple generic list
 */
public class MyLinkedList<E>
{
    private Node head;        // pointer to first Node on the list
    private Node iterator;    // used to iterate through the list

    /**
     * Create an empty list
     */
    public MyLinkedList()
    {
        head = null;	  // initially, list is empty
    }

    // utility method returns a pointer to the last node on the list
    private Node lastNode()
    {
        if (head == null)       // if list empty...
        {
            return null;        // ...no last node
        } 
        else                    // get pointer to last node
        {
            Node temp = head;           // ...start at head of list
            while (temp.next != null)   // ...while not at last node...
            {
                temp = temp.next;   // ......move to next node
            }
            return temp;            // ...return pointer to last node
        }
    }

    /**
     * Append an object to the end of the list
     * @param x the object to be appended
     */
    public void append(E x)
    {
        // create new Node with "info" member pointing to x
        Node temp = new Node(x);

        if (head == null)           // if list is empty...
        {
            head = temp;            // ...put new Node at head of list.
        } 
        else                        // if non-empty...
        {
            lastNode().next = temp; // ...append new node to end of list
        }
    }

    /**
     * Make the list empty.
     */
    public void clear()
    {
        head = null;                // GC will take all the nodes
    }

    /**
     * Is a particular object on the list?
     *	 
     * Precondition: The equals() method must be overridden in whatever class  
     *               of objects is stored on the list
     *
     * @param x the object to search for
     * @return true if x is on the list, false if not
     */
    public boolean contains(E x)
    {
        Node temp = head;            // start at head of list
        while (temp != null)         // while more nodes...
        {
            if (temp.info.equals(x)) // if x is found...
            {
                return true;	     // ...return true
            }
            temp = temp.next;	     // else, move to next node
        }
        return false;		     // no more nodes and haven't found it
    }

    /**
     * Return a String containing all the objects on the list
     * @return the list as a String
     */
    public String toString()
    {
        String out = "";
        Node temp = head; 		// start at head of list 
        while (temp != null)            // while more nodes on list...
        {
            out += temp.info + "  ";	// ...append current obj
            temp = temp.next;		// ...and move to next node
        }
        return out + "\n";
    }

    // ************* iterator methods *************

    /*
     * Set the iterator to a position just before the head of the list
     */
    public void setIterator()
    {
        // Insert a new "utility Node" (not a data-bearing Node) just before
        // the first node (aka the "head" node), and point iterator at it

        Node preHead = new Node(null);  // info portion? Fuggedabouddit!
        preHead.next = head ;           // point next portion to head node
        iterator = preHead;             // Point ierator to the new node
    }

    /**
     * Are there more items on the list?
     *
     * Precondition: The iterator must be set 
     *
     * @return true if at least one more item on the list, false if not
     */
    public boolean more()
    {
        return iterator.next != null;
    }

    /**
     * Advance iterator to the next item on the list and return it
     *
     * Precondition: The iterator must be set and must not be pointing to 
     *               the last object on the list
     *
     * @return the object to which the iterator is pointing after advancing
     */
    public E next()
    {
        iterator = iterator.next;	// move to next node...	
        return iterator.info;		// ...return object stored there
    }
    
    //  Definition of inner class Node =====================================
    class Node               // note: "package" (aka "friendly") access 
    {
        // instance vars
        private E info;      // stores an object of the type parameter class
                            
        private Node next;   // points to next node on the list

        // Create a Node object 
        Node(E x) // constructor takes one param of class E
        {
            info = x;       // set info portion to parameter passed
            next = null;    // not yet pointing to another Node
        }
    } // end of Node class definition ======================================
} // end of MyLinkedList class definition ====================================
