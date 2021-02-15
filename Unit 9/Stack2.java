//  File: Stack2.java		

//  Version 2 of the generic Stack class.  Implementation has been changed
//  to a linked list. The Node class is defined in Node.java
//  WARNING: an attempt to pop or to peek an empty stack will throw a 
//           NullPointerException.
//package DataStructures ;
/**
 * A generic stack class
 */
public class Stack2<E> {
    private Node top; // points to Node on top of stack

    /**
     * Create an empty stack (not really necessary)
     */
    public Stack2() {
        top = null;
    }

    /**
     * Is the stack empty?
     *
     * @return true if stack is empty, false if non-empty
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Place an item on top of the stack.
     *
     * @param x the object to be pushed
     */
    public void push(E x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    /**
     * Pop (i.e., remove) the item at the top of the stack and return it.
     *
     * @return a reference to the object on top of the stack. Precondition: the
     *         stack is NOT empty.
     */
    public E pop() {
        E saved = top.info;
        top = top.next;
        return saved;
    }

    /**
     * Return the item on top of the stack but do not pop it.
     *
     * @return a reference to the object on top of the stack. Precondition: the
     *         stack is NOT empty.
     */
    public E peek() {
        return top.info;
    }

    class Node {
        // instance vars
        private E info; // an object of the "type variable" class
        private Node next; // pointer to next node

        // Create a Node object
        Node(E x) // constructor takes one param of class E
        {
            info = x; // set info portion to parameter passed
            next = null;
        }
    } // end of Node class definition
} // end of Stack2 class definition