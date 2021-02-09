//  File:  AssignmentDemo.java

//  Shows the effect of the assignment operator "=" when applied to object
//  variables.  Remember that an object variable stores a "reference to" an
//  object (i.e. the address of the object).

/**
 * A class to represent a car of a specific make and color.
 */
class Ride {
    // instance variables
    private String make; // the make of the car
    private String color; // the color

    /**
     * Creates a Ride object.
     * 
     * @param theMake  the make of the ride
     * @param theColor the color of the ride
     */
    public Ride(String theMake, String theColor) {
        make = theMake;
        color = theColor;
    }

    /**
     * Paint Ride object a new color.
     * 
     * @param newColor the new color
     */
    public void paint(String newColor) {
        color = newColor;
    }

    /**
     * Converts a Ride object to a String.
     * 
     * @return a String containing the make and color of the ride
     */
    public String toString() {
        return color + " " + make;
    }
}

/**
 * Test class shows effect of assignment statement with objects
 */
public class AssignmentDemo {
    public static void main(String args[]) {
        Ride myRide = new Ride("Tesla", "Teal");

        Ride yourRide = new Ride("Ferrari", "Fuchsia");

        System.out.println("myRide is a " + myRide.toString());

        System.out.println("yourRide is a " + yourRide.toString());

        yourRide = myRide;
        // Note: now both obj var's point to same car object

        System.out.println("\nAfter assigning \"yourRide = myRide\"...\n");

        System.out.println("myRide is a " + myRide.toString());

        System.out.println("yourRide is a " + yourRide.toString());

        // paint my car purple
        myRide.paint("Tangerine");

        System.out.println("\nAfter painting ONLY myRide Tangerine...\n");

        System.out.println("myRide is a " + myRide.toString());

        System.out.println("yourRide is a " + yourRide);
        // Note: toString() called implicitly ^^^^^^^
    }
}

/*
 * program output:
 * 
 * myRide is a Teal Tesla yourRide is a Fuchsia Ferrari
 * 
 * After assigning "yourRide = myRide"...
 * 
 * myRide is a Teal Tesla yourRide is a Teal Tesla
 * 
 * After painting ONLY myRide Tangerine...
 * 
 * myRide is a Tangerine Tesla yourRide is a Tangerine Tesla
 * 
 */
