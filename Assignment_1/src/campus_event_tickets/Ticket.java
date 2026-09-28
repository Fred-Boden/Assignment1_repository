package campus_event_tickets;

public class Ticket {

	private int id;
	private Event event;
	private TicketType ticketType;
	private String studentName;
	private boolean canceled;
	private boolean admitted;
	
	public Ticket(int id, Event event, TicketType ticketType, String studentName) {
		if (id <= 0) { throw new IllegalArgumentException("ID ERROR: Id cannot be 0 nor negative!"); }
		if (event == null) { throw new IllegalArgumentException("EVENT ERROR: Event cannot be null!"); }
		if (ticketType == null) { throw new IllegalArgumentException("TICKET_TYPE ERROR: Ticket type cannot be null!"); }
		if (studentName == null || studentName.isBlank()) { throw new IllegalArgumentException("STUDENT_NAME ERROR: studentName cannot be null nor blank!"); }
		
		this.id = id;
		this.event = event;
		this.ticketType = ticketType;
		this.studentName = studentName;
		this.canceled = false;
		this.admitted = false;
	}
		
	// GETTERS
	public int getId() { return id; }
	public Event getEvent() { return event; }
	public TicketType getTicketType() { return ticketType; }
	public String getStudentName() { return studentName; }
	
	public boolean isCanceled() { return canceled; }
	public boolean isAdmitted() { return admitted; }
	public boolean isActive() { return !canceled && !admitted; }
	
	// CANCEL & ADMISSION methods
	public boolean cancel() {
		if (canceled || admitted) { return false; }
		
		canceled = true;
		return true;
	}
	
	public boolean admit() {
		if (canceled || admitted) { return false; }
		
		admitted = true;
		return true;
	}
	
	@Override
	public String toString() {
		return "Ticket ID: " + id + "\nStudent: " + studentName + "\nEvent: " + event + "\nType: " + ticketType + "\nActive Status: " + isActive();
	}
}
