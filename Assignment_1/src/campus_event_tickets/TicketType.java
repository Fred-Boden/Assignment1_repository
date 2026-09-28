package campus_event_tickets;

public class TicketType {
	
	private String name;
	private double price;

	public TicketType(String name, double price) {
		if (name == null || name.isBlank()) { throw new IllegalArgumentException("NAME ERROR: Name cannot be null nor blank!"); }
		if (price < 0) { throw new IllegalArgumentException("PRICE ERROR: Price cannot be negative!"); }
		
		this.name = name;
		this.price = price;
	}
	
	// GETTERS
	public String getName() { return name; }
	public double getPrice() { return price; }
	
	@Override
	public String toString() {
		return name + " : $" + String.format("%.2f", price);
	}
}