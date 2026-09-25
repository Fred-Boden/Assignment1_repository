package one.assignment;

public class Main {

	public static void main(String[] args) {
		TicketManager ticketManager = new TicketManager(5);
		Event cyberLecture = new Event("Cybersecurity Guest Lecture", "Engineering Building");
		Event oopLecture = new Event("Object Oriented Programming Lecture", "Swallow Hall");
		TicketType studentType = new TicketType("Student", 2.50);
		TicketType generalType = new TicketType("General", 4.25);
		
		ticketManager.createTicket(oopLecture, studentType, "Jeff");
		ticketManager.createTicket(cyberLecture, generalType, "Bob");
		ticketManager.createTicket(oopLecture, generalType, "Mary");
		ticketManager.createTicket(cyberLecture, studentType, "Michael");
		ticketManager.createTicket(oopLecture, generalType, "James");
		
		ticketManager.cancelTicket(3);
		ticketManager.admitTicket(2);
		
		ticketManager.admitTicket(3);
		
		ticketManager.printAll();
		ticketManager.printForEvent(cyberLecture);

	}

}
