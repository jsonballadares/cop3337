import java.util.Random;

// A NumberTile is a square tile with a number from 1 to 9 on each side
public class NumberTile {
    private int[] tile; // the 4-sided tile

    // Create a NumberTile object with 4 random ints in the range 1 to 9
    public NumberTile() {
        Random gen = new Random(); // DO NOT ERASE THIS DECLARATION
        // TO DO: Code the body of this method
    }

    // Rotate this NumberTile 90 degrees
    public void rotate() {
        // TO DO: Code the body of this method
    }

    // Return the number on the left side of this NumberTile
    public int getLeft() {
        // Do NOT modify this method
        return tile[0];
    }

    // Return the number on the right side of this NumberTile
    public int getRight() {
        // Do NOT modify this method
        return tile[2];
    }

    // Return this NumberTile as a multiline string in the form:
    // 9
    // 3 7
    // 6
    //
    public String toString() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        return null;
    }
} // end of NumberTile class