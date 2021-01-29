
/*
 * File: Magic8BallTester.java
 *
 * This is a simple test class for the Magic8Ball class.
 *
 * It reads the answers from a file and adds them to the Magic8Ball object.
 *
 * Note: At line 23, no path is specified for the input file.  So, the
 * file must reside in your NetBeans project folder, and not in the src
 * folder or any other sub-folders of the project folder
 *  
 * @author Greg
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Magic8BallTester {
    public static void main(String[] args) throws IOException {
        Magic8Ball ochoMagico = new Magic8Ball();
        Scanner fileScan = new Scanner(new File("8BallAnswers.txt"));

        while (fileScan.hasNext()) // while not eof
        {
            String nextAnswer = fileScan.nextLine();
            ochoMagico.addAnswer(nextAnswer);
        }
        // here at eof - all answers have been add to the Magic8Ball

        ochoMagico.answerQuestions();
        fileScan.close();
    }
}