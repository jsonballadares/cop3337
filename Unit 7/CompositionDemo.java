// File:	CompositionDemo.java

// Demonstrates composition of classes, i.e., one class has a data member
// that is an object of another class (aka: a "member object").

// This is known as a "has-a" relationship.

// In this example the Class class has two member objects - startTime and 
// finishTime - which are objects of the Time class. 
 
class Time 
{
  // data members store time in military format
  private int hour ;		// 0..23
  private int minute ;		// 0..59
  private int second ;		// 0..59
  
  public Time(int hr, int min, int sec)	// constructor
  {
  	System.out.println("\nTime constructor called for hour = " + hr +
  	                    "  minute = " + min + "  second = " + sec) ;
  	// check for invalid args, use 0's instead
  	hour = (hr >= 0 && hr <= 23) ? hr : 0 ;
  	minute = (min >= 0 && min <= 59) ? min : 0 ;
  	second = (sec >= 0 && sec <= 59) ? sec : 0 ;
  }

  public String toString()	// returns time as am/pm
  { 
  	String out = "" ; 
   	if (hour == 0)
  	  out += "12" ;
  	else if (hour <= 12)
  	  out+= hour ;
  	else
  	  out += (hour % 12) ;
  	
  	if (minute <= 9)
  	  out += (":0" + minute) ;
  	else 
  	  out += (":" + minute) ;
  	
  	if (second <= 9)
  	  out += (":0" + second) ;
  	else 
  	  out += (":" + second) ;
  	  
  	if (hour <= 11)
  	  out += " A.M." ;
  	else 
  	  out += " P.M." ;
  	  
  	return out ;
  }
}
  	
class Class
{
	private String name ;				// name of class offered
	private int numStudents ;			// enrollment in class
	private Time startTime ;
	private Time finishTime ;

	// class constructor...
	
	public Class (String id, int students, 
	              int startHr, int startMin, int startSec,
	              int finishHr, int finishMin, int finishSec)
	{
		System.out.println("Class Constructor called for " + id) ;
		// initialize new object
		name = id ;
		numStudents = ( students >= 0 && students <= 65 ) ? students : 0 ;
		
		// call Time constructor to initialize Time portions of Class object
		startTime  = new Time(startHr, startMin, startSec) ;
		finishTime = new Time(finishHr, finishMin, finishSec) ;
	}
	
	public String toString()			
	{
		String out = "Class: " + name + "   Enrollment: " + numStudents 
		             + "   Time: " ;
		
		// call Time class toString() implicitly
		 
		out = out + startTime + " - " + finishTime  ;
		return out ;
	}
}

public class CompositionDemo
{
	public static void main(String args[])
	{
		Class c1 = new Class("COP 2210", 30, 14, 0, 0, 15, 15, 0) ;
		System.out.println() ;
 		Class c2 = new Class("COP 3337", 30, 18, 25, 0, 19, 40, 0) ; 
		System.out.println("\n" + c1) ;
		System.out.println("\n" + c2) ;
	}
}

/* Program output:

Class Constructor called for COP 2210

Time constructor called for hour = 14  minute = 0  second = 0

Time constructor called for hour = 15  minute = 15  second = 0

Class Constructor called for COP 3337

Time constructor called for hour = 18  minute = 25  second = 0

Time constructor called for hour = 19  minute = 40  second = 0

Class: COP 2210   Enrollment: 30   Time: 2:00:00 P.M. - 3:15:00 P.M.

Class: COP 3337   Enrollment: 30   Time: 6:25:00 P.M. - 7:40:00 P.M.

*/
		