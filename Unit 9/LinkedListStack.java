import java.util.NoSuchElementException;

public class LinkedListStack<T> {
    class Node<T> {
        public T data;
        public Node<T> next;
    }

    private Node<T> head;
    private int size;

    public LinkedListStack() {
        head = null;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>();
        newNode.data = element;
        newNode.next = head;
        size++;
        head = newNode;
    }

    public T pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T element = head.data;
        head = head.next;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> temp = head;
        System.out.print("[");
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.data);
            } else {
                System.out.print(temp.data + ", ");
            }

            temp = temp.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        LinkedListStack<String> list = new LinkedListStack<>();
        System.out.println("Is the list empty?: " + list.isEmpty());
        list.push("Jason Balladares");
        System.out.println("Is the list empty?: " + list.isEmpty());
        list.push("William Guerrero");
        list.push("Ernesto Chacon");
        list.push("Jean Pachon");
        list.push("Kevin Trampos");
        System.out.println(list.size());
        list.print();
    }
}
