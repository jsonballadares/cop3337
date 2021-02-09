// File:  Animal.java

// The Animal interface and some classes that implement it.
/**
 * An interface to represent an animal in the popular children's song.
 */
public interface Animal {
    // classes that implement the interface must provide implementations for
    // all the interface's methods

    String getPlural(); // returns the plural of the animal name

    String getSound(); // returns what the animal says
}

class Cow implements Animal {
    public String getPlural() {
        return "cows";
    }

    public String getSound() {
        return "moo";
    }
}

class Pig implements Animal {
    public String getPlural() {
        return "pigs";
    }

    public String getSound() {
        return "oink";
    }
}

class Giraffe implements Animal {
    public String getPlural() {
        return "giraffes";
    }

    public String getSound() {
        return "[silence]";
    }
}

class Snake implements Animal {

    public String getPlural() {
        return "snakes";
    }

    public String getSound() {
        return "hiss!";
    }
}
