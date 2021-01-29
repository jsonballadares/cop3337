import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTester {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("8BallAnswers.txt"));
        while (fileScan.hasNext()) {
            System.out.println(fileScan.nextLine());
        }
        fileScan.close();
    }
}
