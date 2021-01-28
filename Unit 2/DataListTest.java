
/*
 * File: DataListTest.java
 * 
 * A simple test class for the DataList class.  In this example, the set is
 * populated with randomly-generated scores, but the scores could have been 
 * read from the keyboard or from a data file instead
 */
import java.util.Random;

public class DataListTest {
    public static void main(String[] args) {
        DataList set = new DataList();
        Random r = new Random();

        // add 10 random ints in range 10..20 to the DataSet

        for (int i = 1; i <= 10; i++) {
            int num = r.nextInt(11) + 10;
            set.addScore(num);
        }
        // set has been populated

        if (set.isEmpty()) {
            System.out.println("ERROR - No data!");
        } else {
            System.out.println("The scores:     " + set.toString());
            System.out.println("The average is: " + set.getAverage());
            System.out.println("The maximum is: " + set.getMaximum());
            System.out.println("The standard deviation is: " + set.getStanDev());
        }
    }
}