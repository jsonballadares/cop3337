//  File: Bank.java

//  The Bank class uses an ArrayList to store a collection of BankAccount 
//  objects, and demonstrates the basics of list processing - creating a list,
//  adding objects to it, and traversing a list (i.e. "visiting" each object
//  on the list in turn and doing something with it)

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * This bank contains a collection of bank accounts.
 */
public class Bank {
    private ArrayList<BankAccount> accounts; // a list of BankAccount objects

    /**
     * Constructs a bank with no bank accounts.
     */
    public Bank() {
        accounts = new ArrayList<BankAccount>();
    }

    /**
     * Adds an account to this bank.
     * 
     * @param newAccount the account to add
     */
    public void addAccount(BankAccount newAccount) {
        accounts.add(newAccount); // calls "add" method of ArrayList class
    }

    /**
     * Print data for all accounts
     */
    public void printList() {
        // print headings
        System.out.printf("%15s%20s%n", "Account Number", "Account Balance");

        System.out.printf("%15s%20s%n", "==============", "===============");

        // for each account in this bank
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount current = accounts.get(i); // get next account

            // print account number and balamce to screen
            System.out.printf("%15s     $%14.2f%n", current.getAccountNumber(), current.getBalance());
        }
    }

    /**
     * Gets the sum of the balances of all accounts in this bank.
     * 
     * @return the sum of the balances
     */
    public double getTotalBalance() {
        double total = 0;

        // for each account in this bank
        for (int index = 0; index < accounts.size(); index++) {
            BankAccount current = accounts.get(index); // get the account
            total = total + current.getBalance(); // add its balance to accum
        }
        return total;
    }

    /**
     * Counts the number of bank accounts whose balance is at least a given value.
     * 
     * @param atLeast the balance required to count an account
     * @return the number of accounts having at least the given balance
     */
    public int count(double atLeast) {
        int matches = 0;
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount current = accounts.get(i); // get the account
            if (current.getBalance() >= atLeast) // found one...
                matches++; // ...increment counter
        }
        return matches;
    }

    /**
     * Linear search to find a bank account with a given account number.
     * 
     * @param target the account number we are searching for
     * @return the account with the given number, or null if there is no such
     *         account
     */
    public BankAccount find(String target) {
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount current = accounts.get(i); // get the account
            String accountNum = current.getAccountNumber(); // get account number
            if (accountNum.equals(target)) // found a match
                return current;
        }
        return null; // No match in the entire array list
    }

    /**
     * Gets the bank account with the largest balance.
     * 
     * @return the account with the largest balance, or null if the bank has no
     *         accounts
     */
    public BankAccount getMaximum() {
        if (accounts.size() == 0) // if no accounts, return null
            return null;

        // assume first account is the largest
        BankAccount largestYet = accounts.get(0);

        // for all other accounts
        for (int i = 1; i < accounts.size(); i++) {
            BankAccount current = accounts.get(i); // get next account
            // is current account > highest so far?
            if (current.getBalance() > largestYet.getBalance())
                largestYet = current;
        }
        return largestYet;
    }
}