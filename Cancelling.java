package Ticket_Booking;
import java.util.*;
public class Cancelling extends Booking{
      static Map<Integer,String>canceled_seats=new HashMap<>();
      static private int prefered_seat_number=0;
      static private String prefered_choice=null;
      public static void cancel(int id) {
    	  for(Passenger p:confirmed_list) {
    		  if(p.getId()==id) {
    			  remove_ticket(p);
    			  System.out.println("Successfully Cancelled");
    			  return;
    		  }
    	  }
    	  for(Passenger p:rac_list) {
    		  if(p.getId()==id) {
    			  remove_ticket(p);
    			  System.out.println("Successfully Cancelled");
    			  return ;
    		  }
    	  }
    	  for(Passenger p:waiting_list) {
    		  if(p.getId()==id) {
    			  remove_ticket(p);
    			  System.out.println("Successfully Cancelled");
    			  return ;
    		  }
    	  } 
    	  System.out.println("Invalid Id");
      }
      public static void remove_ticket(Passenger p) {
    	  if(p.getTickettype().equals("berth")) {
    		  prefered_seat_number=p.getSeat_number();
    		  prefered_choice=p.getChoice();
    		  canceled_seats.put( prefered_seat_number, prefered_choice);
    		  deletefromall(p);
    		  move_from_rac_to_confirm(rac_list.poll());
    		  move_from_waiting_to_rac(waiting_list.poll());
    	  }
    	  else if(p.getTickettype().equals("rac")) {
    		  deletefromall(p);
    		  move_from_waiting_to_rac(waiting_list.poll());
    	  }
    	  else {
    		  deletefromall(p);
    	}
      }
      public static void  move_from_rac_to_confirm(Passenger p) {
    	  if(p!=null) {
    		  p.setSeat_number(prefered_seat_number);
    		  p.setChoice(prefered_choice);
        	  p.setTickettype("berth");
        	  if(prefered_choice.equalsIgnoreCase("ac")) {
        		  ac_list.add(p);
        	  }
        	  else if(prefered_choice.equalsIgnoreCase("non-ac")) {
        		  non_ac_list.add(p);
        	  }
        	  else if(prefered_choice.equalsIgnoreCase("seater")) {
        		  seater_list.add(p);
        	  }
        	  confirmed_list.add(p);
        	  canceled_seats.remove(prefered_seat_number);
        	  prefered_seat_number=0;
        	  prefered_choice=null;
    	  }
    	      	  
      }
      public static void  move_from_waiting_to_rac(Passenger p) {
    	  if(p!=null) {
    		  p.setTickettype("rac");
        	  rac_list.add(p);
    	  }
      }
      public static void deletefromall(Passenger p) {
    	  confirmed_list.remove(p);
    	  ac_list.remove(p);
    	  non_ac_list.remove(p);
    	  seater_list.remove(p);
    	  rac_list.remove(p);
    	  waiting_list.remove(p);

      }
      public static Map<Integer,String> getmap(){
    	  return canceled_seats;
      }
}
