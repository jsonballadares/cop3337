/*
 * File:  DataList.java
 *
 * A class with an instance variable that is an ArrayList 
 */

import java.util.ArrayList;

/**
 * Computes the average, maximum, and standard deviation of any number of scores
 */
public class DataList {
    // instance var
    private ArrayList<Integer> scores; // list of scores

    /**
     * Creates an empty data set
     */
    public DataList() {
        scores = new ArrayList<Integer>();
    }

    /**
     * Adds a score to the DataSet
     * 
     * @param next the score to be added
     */
    public void addScore(int next) {
        scores.add(next); // calls add method of ArrayList class
    }

    /**
     * Returns a string containing all the scores in the DataSet
     * 
     * @return all the scores
     */
    public String toString() {
        String scoreString = ""; // create empty string

        // for each score in the set
        for (int i = 0; i < scores.size(); i++) {
            int current = scores.get(i); // get next score
            scoreString += current + "  "; // concatenate to string
        }
        return scoreString;
    }

    /**
     * Returns the average of the scores in the DataSet
     * 
     * @return the average score
     */
    public double getAverage() {
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            int current = scores.get(i);
            sum = sum + current;
        }
        return (double) sum / scores.size();
    }

    /**
     * Returns the largest score in the DataSet
     * 
     * @return the largest score
     */
    public int getMaximum() {
        int max = scores.get(0); // assume first score is largest

        // check all other scores
        for (int i = 1; i < scores.size(); i++) {
            int nextScore = scores.get(i); // get next score
            if (nextScore > max) // if greater than current max...
            {
                max = nextScore; // ...save as new max
            }
        }
        return max;
    }

    /**
     * Computes and returns the population standard deviation
     * 
     * @return the population standard deviation
     */
    public double getStanDev() {
        // 1. get the average of all the scores
        double average = this.getAverage();

        // 2. compute the sum of the squares of the differences between
        // each score and the average

        double sumOfSquares = 0.0;

        // for each score on list
        for (int i = 0; i < scores.size(); i++) {
            int current = scores.get(i); // gets next score
            double diff = current - average; // difference from average
            sumOfSquares += Math.pow(diff, 2); // add square of difference
        } // to accumulator

        // 3. divide by number of scores
        double variance = sumOfSquares / scores.size();

        // 4. standard deviation is square root of the variance
        return Math.sqrt(variance);
    }

    public boolean isEmpty() {
        return scores.size() == 0;
    }
}