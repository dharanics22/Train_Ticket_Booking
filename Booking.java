package Ticket_Booking;
import java.util.*;
public class Booking {
        private static int total=1;
        private static int rac=1;
        private static int waiting=1;
        private static int ac=1;
        private static int non_ac=3;
        private static int seater=5;
        static ArrayList<Passenger>confirmed_list=new ArrayList<>();
        static ArrayList<Passenger>ac_list=new ArrayList<>();
        static ArrayList<Passenger>non_ac_list=new ArrayList<>();
        static ArrayList<Passenger>seater_list=new ArrayList<>();
        static Queue<Passenger>rac_list=new LinkedList<>();
        static Queue<Passenger>waiting_list=new LinkedList<>();
        public static void ticketbooking(Passenger p) {
        	if(ac_list.size()==total && non_ac_list.size()==total && seater_list.size()==total) {
        		if(rac_list.size()<rac) {
        			update_rac(p);
        			System.out.println("Booked in RAC Successfully");
        		}
        		else if(waiting_list.size()<waiting) {
        			update_waiting(p);
        			System.out.println("Booked in Waiting");
        		}
        		else{
        			p.setId(p.getId()-1);
        			System.out.println("No seats are available");
        		}
        	}
        	else if(check_confirmed(p)) {
        		p.setTickettype("berth");
        		confirmed_list.add(p);
        		System.out.println("Your Ticket is confirmed and booked successfully");
        	}
        	else {
        		System.out.println("No prefered Choices");
        		checkavailability();
        	}
        }
        public static void update_rac(Passenger p) {
        	p.setTickettype("rac");
        	rac_list.add(p);
        }
        public static void update_waiting(Passenger p) {
        	p.setTickettype("waiting");
        	waiting_list.add(p);
        }
        public static void checkavailability()
        {
        	System.out.println("Available seats:");
        	System.out.println("AC seats: " + (total - ac_list.size()));
        	System.out.println("Non-AC seats: " + (total - non_ac_list.size()));
        	System.out.println("Seater seats: " + (total - seater_list.size()));

        }
        public static boolean check_confirmed(Passenger p) {
        	Map<Integer,String>seats_from_cancelled=Cancelling.getmap();
        	if(p.getChoice().equalsIgnoreCase("ac")&& ac_list.size()<total) {
        		if(seats_from_cancelled.size()>0 ) {
        			check_seats_from_cancelled(p,seats_from_cancelled);
        		}
        		else {
        			p.setSeat_number(ac);
        			ac++;
        		}
        		ac_list.add(p);
        		return true;
        	}
        	else if(p.getChoice().equalsIgnoreCase("non-ac")&& non_ac_list.size()<total) {
        		if(seats_from_cancelled.size()>0 ) {
        			check_seats_from_cancelled(p,seats_from_cancelled);
        		}
        		else {
        			p.setSeat_number(non_ac);
        			non_ac++;
        		}
        		non_ac_list.add(p);
        		return true;
        	}
        	else if(p.getChoice().equalsIgnoreCase("seater") && seater_list.size()<total) {
        		if(seats_from_cancelled.size()>0 ) {
        			check_seats_from_cancelled(p,seats_from_cancelled);
        		}
        		else {
        			p.setSeat_number(seater);
        			seater++;
        		}
        		seater_list.add(p);
        		return true;
        	}
        	return false;
        }
        public static void check_seats_from_cancelled(Passenger p,Map<Integer,String>seats_from_cancelled) {
        	int seat_number=-1;
        	for(Map.Entry<Integer,String>entry:seats_from_cancelled.entrySet()) {
        		if(entry.getValue().equalsIgnoreCase(p.getChoice())) {
        			seat_number=entry.getKey();
        			p.setSeat_number(seat_number);
        			return ;
        		}
        	}
        	if(seat_number==-1) {
        		if(p.getChoice().equalsIgnoreCase("ac")){
        			p.setSeat_number(ac);
        			ac++;
        		}
        		else if(p.getChoice().equalsIgnoreCase("non-ac")){
        			p.setSeat_number(non_ac);
        			non_ac++;
        		}
        		else if(p.getChoice().equalsIgnoreCase("seater")){
        			p.setSeat_number(seater);
        			seater++;
        		}
        	}
        	
        	
        }
        public static void displayall() {
        	System.out.println("------------------------------------------------------------");
        	for(Passenger p:confirmed_list) {
        		System.out.println(p);
        		System.out.println("------------------------------------------------------------");
        	}
        	
        	for(Passenger p:rac_list) {
        		System.out.println(p);
        		System.out.println("------------------------------------------------------------");
        	}
        	for(Passenger p:waiting_list) {
        		System.out.println(p);
        		System.out.println("------------------------------------------------------------");
        	}

        }
}
