package Ticket_Booking;
import java.util.*;
public class Main {
       public static void main(String[] args) {
    	   System.out.println("--------Welcome to Railway Booking--------");
    	   while(true) {
    		   System.out.println("\n1.Book Ticket\n2.Check Availability \n3.Cancel Ticket \n4.Preperation Chart\n5.Logut");
        	   Scanner sc=new Scanner(System.in);
        	   int n=sc.nextInt();
    		   switch(n) {
    		        case 1:
    		        	System.out.println("Enter your name:");
    		        	String name=sc.next();
    		        	System.out.println("Enter your age:");
    		        	int age=sc.nextInt();
    		        	System.out.println("Enter your choice ac/non-ac/seater");
    		        	String choice=sc.next();
    		        	Booking.ticketbooking(new Passenger(name,age,choice));
    		        	break;
    		        case 2:
    		        	Booking.checkavailability();
    		        	break;
    		        case 3:
    		        	System.out.println("Enter your id");
    		        	int id=sc.nextInt();
    		        	Cancelling.cancel(id);
    		        	break;
    		        case 4:
    		        	Booking.displayall();
    		        	break;
    		        case 5:
    		        	System.out.println("Thanks for visiting!!!!");
    		        	sc.close();
    		        	return;
    		   }
    		   
    			   
    	   }
       }
}
