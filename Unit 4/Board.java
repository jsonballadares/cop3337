
// The board for the NumberTile game  
public class Board {
    private NumberTile[] board; // the board for the game
    private int boardSize; // current number of tiles on the board
    private static final int MAX_BOARD = 100; // maximum number of tiles

    // Creates a new Board that can hold up to MAX_BOARD tiles
    // that contains a single NumberTile
    public Board() {
        // TO DO: Code the body of this method
    }

    // Return the NumberTile at the specified index on this Board
    public NumberTile getTile(int index) {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        return null;
    }

    // Return the current number of tiles on this Board
    public int getSize() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        return -999;
    }

    // Insert a new tile into this Board at the specified index
    public void addTile(int index, NumberTile tile) {
        // TO DO: Code the body of this method
    }

    // Return a multiline string containing all the tiles on this Board
    public String toString() {
        // TO DO: Code the body of this method

        // temporary return statement so program skeleton will compile and run
        return "The board";
    }
}