// File:  TimeTester.java

// Shows uses of "this" - the invisible "implicit parameter"
// passed to all "instance" methods (i.e. non-static methods).  
// this is a reference to the object for which the method was called.

// 1. explicit (but unnecessary) use of this to access instance
//    variables of an object and call methods for it 
// 2. to prevent "shadowing" (i.e., where a local variable or
//    method parameter has the same name as an instance variable
//    and would otherwise "hide" the instance variable)
// 3. to enable a method to return a reference to the object for which
//    it was called, which allows "chaining" of method calls
// 4. the convenience of enabling one constructor of a class
//    to call other constructors of the same class (saves code)

class Time {
    // instance vars store time in military format
    private int hour; // 0..23
    private int minute; // 0..59
    private int second; // 0..59

    public Time(int hr, int min, int sec) // 3-argument constructor
    {
        // eliminate duplicate code by passing param's to "set" methods
        this.setHour(hr);
        this.setMinute(min);
        this.setSecond(sec);
    }

    public Time(int hr, int min) // 2-argument constructor
    {
        // call 3-arg constructor, passing param's hr and min, and 0
        this(hr, min, 0);
    }

    public Time(int hr) // 1-argument constructor
    {
        // call 3-arg constructor, passing param hr, and two 0's
        this(hr, 0, 0);
    }

    public Time() // "default" (i.e., no-argument) constructor
    {
        // call 3 arg constructor with all 0's
        this(0, 0, 0);
    }

    // return time as String hh:mm:ss A.M./P.M.
    public String toString() {
        String out = ""; // the "null" string

        if (hour == 0)
            out += "12";
        else if (hour <= 12)
            out += hour;
        else
            out += hour % 12;

        // assure two-digit minute
        if (minute <= 9)
            out += ":0" + minute;
        else
            out += ":" + minute;

        // assure two-digit minute
        if (second <= 9)
            out += ":0" + second;
        else
            out += ":" + second;

        if (hour <= 11)
            out += " A.M.";
        else
            out += " P.M.";

        return out;
    }

    /**
     * Set a Time object to hr:min:sec and return a reference to that object
     * 
     * @return a reference to the object for which the method was called
     */
    public Time setTime(int hr, int min, int sec) {
        // pass parameters to "set" methods to save code
        // shows explicit (but unnecessary) use of this to call other methods

        this.setHour(hr); // same as: setHour(hr)
        this.setMinute(min);
        this.setSecond(sec);
        return this; // returns reference
    }

    /**
     * Reset the hour part of a Time obj and return a reference to that obj
     * 
     * @return a reference to the object for which the method was called
     */
    public Time setHour(int hour) {
        // uses this to avoid "shadowing" of instance var "hour" by
        // parameter "hour"
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
        return this; // returns reference
    }

    /**
     * Reset the minute part of a Time obj and return a reference to that obj
     * 
     * @return a reference to the object for which the method was called
     */
    public Time setMinute(int minute) {
        // uses this to avoid "shadowing" of instance var minute
        this.minute = (minute >= 0 && minute <= 59) ? minute : 0;
        return this; // returns reference
    }

    /**
     * Reset the second part of a Time obj and return a reference to that obj
     * 
     * @return a reference to the object for which the method was called
     */
    public Time setSecond(int second) {
        // uses this to avoid "shadowing" of instance var second
        this.second = (second >= 0 && second <= 59) ? second : 0;
        return this; // returns reference
    }

}

public class TimeTester {
    public static void main(String[] args) {
        Time a = new Time(10, 11, 12); // 10:11:12 am
        Time b = new Time(13, 14); // 1:14:00 pm
        Time c = new Time(12); // 12:00:00 pm (noon)
        final Time MIDNIGHT = new Time(); // a constant, set to 00:00:00

        System.out.println("Initial times (a,b,c, and MIDNIGHT) are:\n");
        System.out.println(a + "\n" + b + "\n" + c + "\n" + MIDNIGHT);

        // reset "a" to 5:00:00 PM and print via "chaining" of method calls
        System.out.println("\nExecuting:   a.setHour(17).setMinute(0).setSecond(0) ;");
        a.setHour(17).setMinute(0).setSecond(0);
        System.out.println("Time is now " + a);

        // reset "a" to 6:25:00 PM and printing via "chaining"
        System.out.println("\nExecuting:  System.out.println( a.setTime(18,25,0) ) ;");

        System.out.println("Time is now " + a.setTime(18, 25, 0));
    }
}

/*
 * program output:
 * 
 * Initial times (a,b,c, and MIDNIGHT) are:
 * 
 * 10:11:12 A.M. 1:14:00 P.M. 12:00:00 P.M. 12:00:00 A.M.
 * 
 * Executing: a.setHour(17).setMinute(0).setSecond(0) ; Time is now 5:00:00 P.M.
 * 
 * Executing: System.out.println( a.setTime(18,25,0) ) ; Time is now 6:25:00
 * P.M.
 * 
 */