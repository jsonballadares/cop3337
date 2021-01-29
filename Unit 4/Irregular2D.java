
import javax.swing.JOptionPane;

//  File:  Irregular2D.java

//  Since a 2D array is just a 1D array of 1D arrays, each "row" can have a
//  different number of "columns."  That is, the elements of a 1D array can
//  point to 1D arrays of different sizes.
//  This class implements a 2D array of 13 rows (row 0 will not be used) - one
//  for each month.  The number of columns in each row is the number of days
//  in that month, plus one (column 0 will not be used).  So array of [10][15]
//  represents October 15th.
public class Irregular2D {
    public static final String[] MONTH_NAMES = { "", "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December" };
    // MONTH_NAMES[0] has null string

    public static void main(String[] args) {
        String yearString = JOptionPane.showInputDialog("What Year?");
        int year = Integer.parseInt(yearString);
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400) == 0;

        String[][] calendar = new String[13][];
        // this is a 13 element array of pointers to String array. Each
        // pointer is currently null (see picture on board)

        // for each row (except the 0th) ...
        for (int month = 1; month <= 12; month++) {
            // 30 days hath September, April, June, and November...
            if (month == 9 || month == 4 || month == 6 || month == 11) {
                calendar[month] = new String[31];
            }
            // if leap year February gets 30; otherwise 29
            else if (month == 2) {
                if (isLeapYear) {
                    calendar[month] = new String[30]; // 29 days
                } else {
                    calendar[month] = new String[29]; // 29 days
                }
            }
            // other months have 31 days, so set to 32
            else {
                calendar[month] = new String[32];
            }
        }

        // print number of columns in each row (except the 0th)

        for (int month = 1; month < calendar.length; month++) {
            System.out.println(MONTH_NAMES[month] + " has " + (calendar[month].length - 1) + " days.");
        }
    }
}

/*
 * program output
 * 
 * January has 31 days. February has 29 days. March has 31 days. April has 30
 * days. May has 31 days. June has 30 days. July has 31 days. August has 31
 * days. September has 30 days. October has 31 days. November has 30 days.
 * December has 31 days.
 * 
 */