//  File: Stacktester1.java

//  A simple test class for the Stack class.  Extracts each character of a 
//  String and pushes it onto a stack, "peeks" at the top element, and then 
//  pops each character from the stack and prints it, until the stack is empty.
//  This prints the string backwards.

import javax.swing.JOptionPane;

public class StackTester1 {
    public static void main(String[] args) {
        Stack1<String> s = new Stack1<String>();

        String message = JOptionPane.showInputDialog("Enter a string and I will reverse it");

        System.out.println("You entered: " + message + "\n");

        // extract each character of the string and push it onto the stack
        for (int i = 0; i < message.length(); i++) {
            String letter = message.substring(i, i + 1);
            s.push(letter);
        }

        // peek at top item
        System.out.println("Item on top of the stack is: " + s.peek() + "\n");

        System.out.print("\"" + message + "\" reversed is: ");

        while (!s.isEmpty()) // while stack is not empty...
        {
            String letter = s.pop(); // ...pop top item
            System.out.print(letter); // ...and print it
        }

        System.out.println();
    }
}

/*
 * sample output:
 * 
 * You entered: Abracadabra!
 * 
 * Item on top of the stack is: !
 * 
 * "Abracadabra!" reversed is: !arbadacarbA
 * 
 */