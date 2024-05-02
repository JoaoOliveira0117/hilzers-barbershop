public class Chair {
  public Customer currentCustomer;
  public Barber currentBarber;

  public Chair(Customer cust, Barber barber){
    this.currentBarber = barber;
    this.currentCustomer = cust;
  }
}