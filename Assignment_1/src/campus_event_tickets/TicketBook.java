package campus_event_tickets;

public class TicketBook {
	private Ticket[] tickets;
    private int count;

    // The capacity is passed into the constructor here:
    public TicketBook(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.tickets = new Ticket[maxCapacity];
        this.count = 0;
    }
    
    public boolean createTicket(int id, Event event, TicketType type, String studentName) {
    	 if(tickets.length <= count) {
    		 throw new IllegalArgumentException("Ticket Book is Full!");
    	 }
    	 
    	 Ticket newTicket = new Ticket(id, event, type, studentName);
    	 tickets[count] = newTicket;
    	 count++;
    	 return true;
    }
    
    public Ticket findById(int id) {
    	for(int i = 0; i < count; i++) {
    		if(tickets[i].getID() == id)
    			return tickets[i];
    	}
    	
    	return null;
    }
    
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(tickets[i]);
        }
    }
    
    public void printForEvent(Event event) {
    	for(int i = 0; i < count; i++) {
    		// Used reference comparison since equals is not an option. It is fast and simple.
    		if(tickets[i].getEvent() == event)
    			System.out.println(tickets[i]); 
    	}
    }
}
