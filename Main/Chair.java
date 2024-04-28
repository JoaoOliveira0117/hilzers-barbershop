package Main;

public class Chair {
	  private boolean isOccupied = false;
	  public Customer currentCustomer;
	  public Barber currentBarber;

	  public Chair(Customer cust, Barber barber){
	    this.isOccupied = true;
	    this.currentBarber = barber;
	    this.currentCustomer = cust;
	  }
	}