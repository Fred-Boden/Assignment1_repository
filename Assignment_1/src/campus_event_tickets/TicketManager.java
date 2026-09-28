package campus_event_tickets;

public class TicketManager {
	private TicketBook ticketBook;
	private int idCounter;

	public TicketManager(int ticketCount) {
		this.ticketBook = new TicketBook(ticketCount);
		idCounter = 1;
	}

	public boolean createTicket(Event event, TicketType type, String studentName) {
		try {
			ticketBook.createTicket(idCounter, event, type, studentName);

			idCounter++;
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	// Add try/catch for ticket.cancel and admit in case try to admit canceled and
	// vice versa
	public boolean cancelTicket(int id) {
		Ticket targetTicket = ticketBook.findById(id);
		if (targetTicket == null) {
			return false;
		}

		return targetTicket.cancel();
	}

	public boolean admitTicket(int id) {
		Ticket targetTicket = ticketBook.findById(id);
		if (targetTicket == null) {
			return false;
		}

		return targetTicket.admit();
	}

	public void printAll() {
		ticketBook.printAll();
	}

	public void printForEvent(Event event) {
		ticketBook.printForEvent(event);
	}
}
