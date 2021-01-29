/*
   File: BankTester.java
   
   This class creates a Bank object and uses the Scanner class and method 
   hasNext() to read account data from input file BankData.txt until eof
   
   After reading the data for each account, a BankAccount object is created
   and added to the bank
   
   Note: At line 31, no path is specified for the file. In that case, the 
   file must reside in your NetBeans project folder - not in the src folder
   or any other subfolder
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * A test class for the Bank2 class.
 */
public class BankTester2 {
    public static void main(String[] args) throws IOException {
        // create Bank object
        Bank firstBankOfJava = new Bank();

        // create Scanner object associated with input file
        Scanner fileScan = new Scanner(new File("BankData.txt"));

        // read BankAccount data from file, create objects, and add to list

        while (fileScan.hasNext()) // while not eof
        {
            String accountNumber = fileScan.next();
            double balance = fileScan.nextDouble();
            // create BankAccount object
            BankAccount next = new BankAccount(accountNumber, balance);
            // add to list
            firstBankOfJava.addAccount(next);
        }
        // here at eof - list has been populated

        // print the list of accounts
        firstBankOfJava.printList();

        // get total on deposit, all accounts
        System.out.println("\nTotal on deposit in all accounts is $" + +firstBankOfJava.getTotalBalance());

        // find number of accounts with balance of at least specified amount

        String input = JOptionPane.showInputDialog("Find number of accounts with what minimum balance?");
        double threshold = Double.parseDouble(input);
        int count = firstBankOfJava.count(threshold);
        System.out.println("\nFound " + count + " accounts with balance of " + "at least $" + threshold);

        // find account with greatest balance

        BankAccount max = firstBankOfJava.getMaximum();
        if (max != null)
            System.out.println("\nAccount with number " + max.getAccountNumber() + " has the largest balance ($"
                    + +max.getBalance() + ")");
        else
            System.out.println("\nSorry, no accounts!");

        // search the list for some specific accounts

        String accountNumber = JOptionPane.showInputDialog("Enter account number to search for (or Cancel to quit)");
        while (accountNumber != null) // while not eof
        {
            BankAccount target = firstBankOfJava.find(accountNumber);
            if (target == null)
                System.out.println("\nNo account with number " + accountNumber);
            else
                System.out
                        .println("\nAccount with number " + accountNumber + " has balance of $" + target.getBalance());
            accountNumber = JOptionPane.showInputDialog("Enter next account number to search for (or Cancel to quit)");
        }
    }
}

/*
 * sample output
 * 
 * Account Number Account Balance ============== =============== 1111111 $
 * 15,000.00 2222222 $ 20,000.00 3333333 $ 12,500.00 4444444 $ 37,000.00
 * 
 * Total on deposit in all accounts is $84500.0
 * 
 * Found 3 accounts with balance of at least $15000.0
 * 
 * Account with number 4444444 has the largest balance ($37000.0)
 * 
 * Account with number 2222222 has balance of $20000.0
 * 
 * No account with number 9999999
 * 
 */