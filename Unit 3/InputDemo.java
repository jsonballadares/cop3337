//  File: InputDemo.java

//  A Purchase class object has the number of items purchased, a one-word 
//  description of the item, and the price of the item. 

//  Test class InputDemo uses the Scanner class to read data for a Purchase.

import java.util.Scanner;

/**
 * A class to represent a purchase - number of items, description, and price per
 * item
 */
class Purchase {
    // instance vars
    private int quantity; // number of each item purchased
    private String item; // one-word description of the item
    private double unitPrice; // price per item
    private double cost; // total cost: quantity * unitPrice
    private static final double TAX_RATE = 0.065; // 6.5% (a constant)

    /**
     * Creates a purchase object
     * 
     * @param quantity  number of items bought
     * @param item      one-word description of item
     * @param unitPrice price per item
     */
    public Purchase(int quantity, String item, double unitPrice) {
        this.quantity = quantity;
        this.item = item;
        this.unitPrice = unitPrice;
        // compute cost of purchase
        cost = quantity * unitPrice;
    }

    /**
     * Return the cost of a purchase.
     * 
     * @return the cost of a purchase
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns a String containing the input data for a purchase
     * 
     * @return the quantity, description, and price per item as a String Example: "5
     *         widget(s) @ $1.23
     */
    public String toString() {
        return quantity + " " + item + "(s) @ $" + unitPrice;
        // example: "5 widget(s) @ $1.23
    }

    /**
     * Compute and return the tax on a purchase.
     * 
     * @return the tax on a purchase
     */
    public double getTax() {
        double tax = cost * TAX_RATE; // tax on purchase

        return tax;
    }

    /**
     * Compute and return total cost of a purchase, including tax
     * 
     * @return the total cost of a purchase, tax included
     */
    public double getTotal() {
        // call getTax() to compute the tax, and add to cost
        return getTax() + cost;
    }
} // end of Purchase class definition ========================================

/**
 * Test class for Purchase class
 */
public class InputDemo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter quantity, description, and price of item " + "(separated by spaces):");

        int quantity = input.nextInt(); // first token is an int

        String item = input.next(); // next is a String

        double price = input.nextDouble(); // last is a double

        // construct a Purchase object, using input data
        Purchase current = new Purchase(quantity, item, price);

        // print purchase, tax, and total cost
        System.out.println("\nYour purchase:\n");
        System.out.println(current.toString() + " = $" + current.getCost());
        System.out.println("Tax = $" + current.getTax());
        System.out.println("Total cost = " + current.getTotal());
    }
}

/*
 * sample output:
 * 
 * Enter quantity, description, and price of item (separated by spaces): 8
 * hockeypuck 4.37
 * 
 * Your purchase:
 * 
 * 8 hockey puck(s) @ $4.37 = $34.96 Tax = $2.2724 Total cost = 37.2324
 * 
 */