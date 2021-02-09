// File: MacTest.java

// The SeniorCitizenMacDonald class depends on the Animal interface and shows 
// polymorphism. MacTest is a simple test class for S.C.Mac.
/**
 * A class to sing a popular song.
 */
class SeniorCitizenMacDonald {
    // S.C.Mac doesn't care about type - all animals are treated as interface
    // type Animal. So new classes may be added to the system with no
    // modification of S.C.Mac at all...

    private String sound; // what an Animal says
    private Animal[] animals; // array of interface type Animal

    /**
     * Create an S.C.Mac object.
     *
     * @param myAnimals array of Animal references, any of which may point to any
     *                  class that implements Animal
     */
    public SeniorCitizenMacDonald(Animal[] myAnimals) {
        animals = myAnimals;
    }

    /**
     * Prints lyrics to a popular song, using polymorphic method calls.
     */
    public void sing() {
        // for each Animal in the array...
        for (int ei = 0; ei < animals.length; ei++) {
            sound = animals[ei].getSound(); // polymorphism
            eieio();
            System.out.println("And on this farm he had some " + animals[ei].getPlural() // polymorphism
                    + ",\nE-I-E-I-O.");
            System.out.println("With a(n) " + sound + "-" + sound + " here,\n" + "and a(n) " + sound + "-" + sound
                    + " there,\n" + "here a(n) " + sound + ", there a(n) " + sound + ",\neverywhere a(n) " + sound + "-"
                    + sound + ",");
            eieio();
            System.out.println();
        }
    }

    /**
     * Utility method prints a line of the song. Saves code duplication.
     */
    private void eieio() {
        System.out.println("Senior Citizen MacDonald had a farm,\n" + "E-I-E-I-O.");
    }
}

public class MacTest {

    public static void main(String[] args) {
        Animal[] critters = { new Cow(), new Pig(), new Snake() };

        SeniorCitizenMacDonald mac = new SeniorCitizenMacDonald(critters);

        mac.sing();
    }
}

/*
 * program output :-)
 * 
 * Senior Citizen MacDonald had a farm, E-I-E-I-O. And on this farm he had some
 * cows, E-I-E-I-O. With a(n) moo-moo here, and a(n) moo-moo there, here a(n)
 * moo, there a(n) moo, everywhere a(n) moo-moo, Senior Citizen MacDonald had a
 * farm, E-I-E-I-O.
 * 
 * Senior Citizen MacDonald had a farm, E-I-E-I-O. And on this farm he had some
 * pigs, E-I-E-I-O. With a(n) oink-oink here, and a(n) oink-oink there, here
 * a(n) oink, there a(n) oink, everywhere a(n) oink-oink, Senior Citizen
 * MacDonald had a farm, E-I-E-I-O.
 * 
 * Senior Citizen MacDonald had a farm, E-I-E-I-O. And on this farm he had some
 * giraffes, E-I-E-I-O. With a(n) [silence]-[silence] here, and a(n)
 * [silence]-[silence] there, here a(n) [silence], there a(n) [silence],
 * everywhere a(n) [silence]-[silence], Senior Citizen MacDonald had a farm,
 * E-I-E-I-O.
 * 
 */