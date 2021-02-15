
/* File: TrailingPointerDemo.java
 *
 * Recall that to delete a node from a linked list, we need a pointer to the 
 * previous node, so that we can do a "deleteAfter."  A traditional way to
 * do this is to have two pointers - a "leader," and a "trailer" which is 
 * always one node behind the leader.  Then, when the leader finds the node 
 * to be deleted, we do a deleteAfter using the trailer.
 *
 * Note that deleting the "head" node is a special case (as shown).
 *
 * The TrailingPointerDemo class implements a very limited linked list of ints.
 * All clients can do is append ints and print the list. The class exists only
 * to demonstrate the "trailing pointer" technique, as shown in method 
 * removeNegatives()
 */

public class TrailingPointerDemo {
    private Node head = null; // pointer to first node of list

    // append a new node containing parameter x to the end of the list
    public void append(int x) {
        // create new Node with "info" portion pointing to x
        Node temp = new Node(x);

        if (head == null) // if list is empty...
        {
            head = temp; // ...put new Node at head of list.
        } else // else, append new node to end of list
        {
            lastNode().next = temp; // method returns pointer to last node
        }
    }

    // remove all nodes that contain a negative int
    public void removeNegatives() {
        if (head == null) {
            return; // if empty list, we're done
        }
        Node leader = head; // point leader to 1st node
        Node trailer = head; // point trailer to 1st node
        while (leader != null) // repeat until all nodes visited...
        {
            // if node pointed to by leader has a negative, delete it...
            if (leader.info < 0) {
                if (leader == head) // Special Case: deleting head node
                {
                    head = head.next; // ...remove it and update head
                    leader = head; // ...point leader to new head
                } else // it's not the head node
                {
                    leader = leader.next; // ...advance leader to next node
                    deleteAfter(trailer); // ...remove the node
                }
            } else // otherwise, advance to next node
            {
                trailer = leader;
                leader = leader.next;
            }
        }
    }

    // delete the node AFTER the one pointed to by p
    private void deleteAfter(Node p) {
        Node temp = p.next; // temp points to node to be removed
        p.next = temp.next; // cut node out of the list
    }

    // return a pointer to the last node on the list or null if list is empty
    private Node lastNode() {
        if (head == null) {
            return null;
        }

        // here if list is not empty

        Node current = head; // point "current" to first node
        while (current.next != null) // while current is not at last node...
        {
            current = current.next; // ...move to next node
        }
        return current; // return pointer to last node
    }

    // return a String containing the list
    public String toString() {
        if (head == null) {
            return "The list is empty!";
        }

        String out = "";
        Node temp = head; // start at head of list
        while (temp != null) // while more nodes on list...
        {
            out += temp.info + "  "; // ...concatenate current node info
            temp = temp.next; // ...and move to next node
        }
        return out + "\n";
    }

    // ************* Definition of inner class Node *************
    class Node {
        // instance var's

        private int info; // the data-bearing portion stores an int
        private Node next; // pointer to next Node on the list

        /*
         * Create a new Node with parameter x in the info portion
         */
        Node(int x) {
            info = x;
            next = null; // not necessary since default is null)
        }
    } // end of Node class definition ======================================
}

/*
 * Sample output from 2 runs:
 * 
 * Original list: 97 -70 39 0 18 -35 -53 -23 30 -51
 * 
 * Updated list: 97 39 0 18 30
 * 
 * 
 * Original list: -87 -71 -52 -2 23 93 57 -47 97 59
 * 
 * Updated list: 23 93 57 97 59
 * 
 */