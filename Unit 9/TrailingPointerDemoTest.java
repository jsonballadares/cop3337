
/* File: TrailingPointerDemoTest.java
 *
 * Test class for TrailingPointerDemo.java
 */
import java.util.Random;

public class TrailingPointerDemoTest {

    public static void main(String[] args) {
        TrailingPointerDemo list = new TrailingPointerDemo();

        Random r = new Random();

        // append 10 random ints in range [-99..99] to list
        for (int i = 1; i <= 10; i++) {
            list.append(r.nextInt() % 100);
        }

        System.out.println("Original list:   " + list);

        // remove all negative ints from list
        list.removeNegatives();

        System.out.println("Updated list:    " + list);
    }
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