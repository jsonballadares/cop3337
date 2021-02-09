 /*
 Note to students: make sure you understand the Measurable interface before
 tackling the Measurer, which is a textbook example (literally) of a 
 "strategy interface."  

 Suppose we wish to measure objects of classes that are beyond our control 
 (e.g. classes from the Java library or any other classes where we do not 
 have access to the code).  Since we can't make those classes implement
 Measurable, what's a mother to do?
 	
 Solution: use a "strategy interface" and create classes that implement it. 
 Those classes implement the interface methods, instead of the classes being 
 measured. (See UML diagram for Measurer vs UML for Measurable)  
 
 The Measurer has one abstract method - measure. Its parameter is of ultimate
 superclass Object.  Since objects of every class are also objects of class
 Object, this makes the method universal (i.e. it will accept parameters of
 any class). 

 In the DataSetTest2 class, we create two classes that implement Measurer - 
 RectangleMeasurer and a RationalMeasurer.  The former implements the measure
 method to measure Rectangle objects by area, and the latter to measure 
 Rational objects by their decimal values. In each, note how the Object 
 parameter in the measure method is "downcast" to the actual class of the 
 objects being measured.  
*/

/**
   Describes any class whose objects can measure other objects.
 */
public interface Measurer 
{
    /**
     * Computes the measure of an object.
     *
     * @param anObject the object to be measured
     * @return the measure of anObject
     */
    double measure(Object anObject);
}