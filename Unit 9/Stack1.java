//  file: Stack1.java		

//  A generic Stack class.  The stack is implemented as a generic array which
//  is resized if it becomes full.

//  WARNING: an attempt to pop or to peek an empty stack will throw an 
//           ArrayIndexOutOfBoundsException.

/**
 * A generic stack class
 */
public class Stack1<E> {
    private final static int MAX_SIZE = 10; // initial capacity of stack
    private E[] stack; // stack implemented as generic array
    private int top; // points to top item on the stack

    /**
     * Create an empty stack.
     */
    public Stack1() {
        stack = (E[]) new Object[MAX_SIZE];
        top = -1;
    }

    /**
     * Is the stack empty?
     * 
     * @return true if stack is empty, false if non-empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Place an item on top of the stack.
     * 
     * @param x the object to be pushed
     */
    public void push(E x) {
        if (this.isFull()) // if stack is full, make it bigger
            this.resize();

        stack[++top] = x;
    }

    /**
     * Pop (i.e., remove) the item at the top of the stack and return it.
     * 
     * @return a reference to the object on top of the stack. Precondition: the
     *         stack is NOT empty.
     */
    public E pop() {
        return stack[top--];
    }

    /**
     * Return the item on top of the stack but do not pop it.
     * 
     * @return a reference to the object on top of the stack. Precondition: the
     *         stack is NOT empty.
     */
    public E peek() {
        return stack[top];
    }

    // Is the list full? (a private "utility" method, called by method push())
    private boolean isFull() {
        return top == stack.length - 1;
    }

    // Resize the array when it becomes full. Called by method push().
    private void resize() {
        // create new array "temp" with MAX_SIZE additional elements
        E[] temp = (E[]) new Object[stack.length + MAX_SIZE];
        // copy all Objects from "stack" to "temp"
        System.arraycopy(stack, 0, temp, 0, stack.length);
        // point "stack" at "temp"
        stack = temp;
    }
}