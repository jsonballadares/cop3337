import java.util.NoSuchElementException;

public class CircularArrayQueue {
    private Object[] elements;
    private int currentSize;
    private int head;
    private int tail;

    public CircularArrayQueue() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        currentSize = 0;
        head = 0;
        tail = 0;
    }

    public boolean IsEmpty() {
        return currentSize == 0;
    }

    public void add(Object newElement) {
        growIfNecessary();
        currentSize++;
        elements[tail] = newElement;
        tail = (tail + 1) % elements.length;
    }

    public Object remove() {
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        Object removed = elements[head];
        head = (head + 1) % elements.length;
        currentSize--;
        return removed;
    }

    private void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
            head = 0;
            tail = currentSize;
        }
    }
}
