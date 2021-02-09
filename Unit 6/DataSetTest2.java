
/*
 * File: DataSetTest.java
 * 
 * A simple test class for the DataSet2 class.  In this example, the set is
 * populated with randomly-generated scores, but the scores could have been 
 * read from the keyboard or from a data file instead
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class DataSetTest2 {
    public static void main(String[] args) {
        DataSet2 set = new DataSet2();

        // add any number of ints to the DataSet

        String input = JOptionPane.showInputDialog("Enter an int\n(Cancel to quit)");
        while (input != null) {
            int num = Integer.parseInt(input);
            set.addScore(num);
            input = JOptionPane.showInputDialog("Enter another\n(Cancel to quit)");
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