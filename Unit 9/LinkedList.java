import java.util.NoSuchElementException;

import javax.lang.model.element.Element;

/**
 * LinkedList
 */
public class LinkedList<T> {
    class Node<T> {
        public T data;
        public Node<T> next;
    }

    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    public T getHead() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public void addFirst(T element) {
        Node newNode = new Node<T>();
        newNode.data = element;
        newNode.next = head;
        head = newNode;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            T data = head.data;
            head = head.next;
            return data;
        }
    }

    public void print() {
        Node temp = new Node<T>();
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        LinkedList list = new LinkedList<String>();
        list.addFirst("Jason");
        list.addFirst("Jackson");
        list.addFirst("Jeryy");
        list.print();
        list.removeFirst();
        list.print();

    }
}