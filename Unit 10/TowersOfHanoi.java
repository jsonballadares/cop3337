// File:  TowersOfHanoi.java

// Recursive solution to the "Towers of Hanoi" problem for any number of disks

import javax.swing.JOptionPane;

class DiskMover {
    private int height; // number of disks to be moved

    public DiskMover(int height) {
        this.height = height;
    }

    public void moveDisks(char fromPeg, char toPeg, char usingPeg) {
        // recursive method for determining moves

        // MOVES height DISKS FROM fromPeg TO toPeg, USING usingPeg AS AN
        // AUXILLIARY OR "HELPER" PEG

        if (height == 1) // trivial case

            System.out.println("Move a disk from " + fromPeg + " to " + toPeg);

        else {
            // create new DiskMover object with height of current height - 1

            DiskMover start = new DiskMover(height - 1);

            // do a height-1 move from starting peg to the auxilliary peg

            start.moveDisks(fromPeg, usingPeg, toPeg);

            // move last disk to destination peg from starting peg

            System.out.println("Move a disk from " + fromPeg + " to " + toPeg);

            // do a height-1 move to destination peg from the auxilliary peg

            start.moveDisks(usingPeg, toPeg, fromPeg);
        }
    }
}

public class TowersOfHanoi {
    public static void main(String args[]) {
        String input = JOptionPane.showInputDialog("How many disks? ");

        int height = Integer.parseInt(input);

        System.out.println();

        DiskMover monk = new DiskMover(height);

        monk.moveDisks('A', 'B', 'C');

        System.out.println();
    }
}

/*
 * sample output
 * 
 * How many disks? 3
 * 
 * Move a disk from A to C Move a disk from A to B Move a disk from C to B Move
 * a disk from A to C Move a disk from B to A Move a disk from B to C Move a
 * disk from A to C
 * 
 * 
 * How many disks? 4
 * 
 * Move a disk from A to B Move a disk from A to C Move a disk from B to C Move
 * a disk from A to B Move a disk from C to A Move a disk from C to B Move a
 * disk from A to B Move a disk from A to C Move a disk from B to C Move a disk
 * from B to A Move a disk from C to A Move a disk from B to C Move a disk from
 * A to B Move a disk from A to C Move a disk from B to C
 * 
 */