package campus_event_tickets;

public class TicketManager {
	public TicketBook ticketBook;
	private int idCounter;
	
	boolean createTicket(Event event, TicketType type, String studentName)
	{
		try
		{
			ticketBook.createTicket(idCounter, event, type, studentName);
			
			idCounter++;
			return true;
		} catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
	//Add try/catch for ticket.cancel and admit in case try to admit canceled and vice versa
	boolean cancelTicket(int id)
	{
		Ticket targetTicket = ticketBook.findById(id);
		if(targetTicket == null)
		{
			return false;
		}
		try
		{
			targetTicket.cancel();
			
			return true;
			
		} catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
	
	boolean admitTicket(int id)
	{
		Ticket targetTicket = ticketBook.findById(id);
		if(targetTicket == null)
		{
			return false;
		}
		
		try
		{
			targetTicket.admit();
			return true;
		} catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
	
	void printAll()
	{
		ticketBook.printAll();
	}
	
	void printForEvent(Event event)
	{
		ticketBook.printForEvent(event);
	}
	
	public TicketManager(int ticketCount)
	{
		this.ticketBook = new TicketBook(ticketCount);
		idCounter = 1;
	}

}
