/**
 * This program tests the DataSet class.
 */
public class DataSetTest {
    public static void main(String[] args) {

        DataSet bankData = new DataSet();

        bankData.add(new BankAccount2(0));
        bankData.add(new BankAccount2(10000));
        bankData.add(new BankAccount2(2000));

        System.out.println("Average balance = " + bankData.getAverage());
        Measurable max = bankData.getMaximum();
        System.out.println("Highest balance = " + max.getMeasure());

        DataSet coinData = new DataSet();

        coinData.add(new Coin(0.25, "quarter"));
        coinData.add(new Coin(0.1, "dime"));
        coinData.add(new Coin(0.05, "nickel"));

        System.out.println("Average coin value = " + coinData.getAverage());
        max = coinData.getMaximum();
        System.out.println("Highest coin value = " + max.getMeasure());
    }
}

/*
 * program output:
 * 
 * Average balance = 4000.0 Highest balance = 10000.0 Average coin value =
 * 0.13333333333333333 Highest coin value = 0.25
 * 
 */