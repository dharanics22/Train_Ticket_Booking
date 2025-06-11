package Ticket_Booking;

public class Passenger {
      private static int id_provider=0;
      private int id;
      private String name;
      private int age;
      private String choice;
      private int seat_number;
      private String ticket_type;
      Passenger(String name,int age,String choice){
    	  this.id=++id_provider;
    	  this.name=name;
    	  this.age=age;
    	  this.choice=choice;
      }
      public int  getId() {
    	  return id;
      }
      public int  setId(int id) {
    	  return Passenger.id_provider=id;
      }
      public String getName() {
     	 return name;
      }
      public String  setName(String name) {
     	 return this.name=name;
      }
      public int getAge() {
     	 return age;
      }
      public int setAge(int age) {
     	 return this.age=age;
      }
      public String getChoice() {
    	  return choice;
      }
      public void setChoice(String choice) {
    	   this.choice=choice;
      }
      public int getSeat_number() {
    	  return seat_number;
      }
      public void setSeat_number(int seat_number) {
    	  this.seat_number=seat_number;
      }
      public String getTickettype() {
    	  return ticket_type;
      }
      public void setTickettype(String ticket_type) {
    	  this.ticket_type=ticket_type;
      }
      public String toString() {
    	  return "\nID:"+id+"\nName:"+name+"\nAge:"+age+"\nChoice:"+choice+"\nSeat-Number:"+seat_number+"\nTicket_type:"+ticket_type;
      }
} 
