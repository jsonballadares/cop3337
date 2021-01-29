
/*
 * File: Magic8Ball.java
 *
 * THE MAGIC 8-BALL IS A REGISTERED TRADEMARK OF THE MATTEL CORPORATION
 *
 * CopyRight:  Greg Shaw, 11/13/2010
 * 
 * Reviews ArrayLists and random numbers
 */
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * This class implements a digital version of the world-famous prognosticating
 * device. The answers must first be added to the list by calling method
 * addAnswer once for each answer
 *
 * @author Greg
 */
public class Magic8Ball {
    // instance var's
    private ArrayList<String> answers; // list of answers
    private static Random generator = new Random();

    /**
     * Create a Magic8Ball object
     */
    public Magic8Ball() {
        answers = new ArrayList<String>(); // create empty list
    }

    /**
     * Add an answer to the list
     * 
     * @param answer an answer to be added
     */
    public void addAnswer(String answer) {
        answers.add(answer); // call add method of ArrayList class
    }

    /**
     * Display a randomly-chosen answer to a "Yes or No" question
     */
    public void answerQuestions() {
        String question = JOptionPane.showInputDialog("Ask me a YES/NO question " + "(Cancel to quit)");
        while (question != null) // while more questions
        {
            // get a randon int between 0 and one less than the size of the list
            int index = generator.nextInt(answers.size());

            // get the answer at position "index" on the list
            String message = answers.get(index);

            System.out.println(message);
            JOptionPane.showMessageDialog(null, message);
            question = JOptionPane.showInputDialog("Next question? " + "(Cancel to quit)\n(You don't have to type the "
                    + "question - I can read your mind!)\nThey don't call " + "me MAGIC for nothin'!");
        }
        // here at eof - display disclaimer
        String disclaimer = "Answers given are the opinions of the Magic "
                + "8-Ball only \nand do not represent the views of your computer, "
                + "Greg, \nthe School of Computing and Information Sciences, \n"
                + "Florida International University, or any other entity, \n" + "biological or not.";
        JOptionPane.showMessageDialog(null, disclaimer);
    }
}