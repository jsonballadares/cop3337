public class ArrayList {
    private Object[] elements;
    private int currentSize;

    public ArrayList() {
        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    private void checkBounds(int n) {
        if (n < 0 || n >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object get(int pos) {
        checkBounds(pos);
        return elements[pos];
    }

    public void set(int pos, Object element) {
        checkBounds(pos);
        elements[pos] = element;
    }

    public Object remove(int pos) {

        checkBounds(pos);

        Object removedObject = elements[pos];

        // pos = 2
        // [1,2,4,5,5]
        for (int i = pos + 1; i < currentSize; i++) {
            elements[i - 1] = elements[i];
        }
        currentSize--;
        return removedObject;

    }

    public boolean addLast(Object newElement) {
        growIfNecessary();
        currentSize++;
        elements[currentSize - 1] = newElement;
        return true;
    }

    private void growIfNecessary() {
        if (currentSize == elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    public static void main(String[] args) {

    }
}
