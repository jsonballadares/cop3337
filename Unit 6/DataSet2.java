
// New version of ths DataSet class depends on the Measurer interface.

/**
 * Computes the average and maximum of a set of data values.
 */
public class DataSet2 {
    private double sum; // sum of a set of objects
    private Object maximum; // points to largest object
    private int count; // number of objects measured
    private Measurer measurer; // used to measure objects of any class

    /**
     * Creates an empty data set with a given Measurer object
     * 
     * @param aMeasurer the Measurer that will be used to measure objects
     */
    public DataSet2(Measurer aMeasurer) {
        sum = 0;
        count = 0;
        maximum = null;
        measurer = aMeasurer;
    }

    /**
     * Adds the measure of an object to the set
     * 
     * @param x object to be added
     */
    public void add(Object x) {
        sum = sum + measurer.measure(x);
        if (count == 0 || measurer.measure(maximum) < measurer.measure(x))
            maximum = x;
        count++;
    }

    /**
     * Gets the average of the added data
     * 
     * @return the average or 0 if no data has been added
     */
    public double getAverage() {
        if (count == 0)
            return 0;
        else
            return sum / count;
    }

    /**
     * Return the object with the largest measure
     * 
     * @return a pointer to the object with the largest measure or null if the
     *         DataSet is empty
     */
    public Object getMaximum() {
        return maximum;
    }
}