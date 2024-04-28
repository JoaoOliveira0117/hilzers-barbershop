package Main;

import java.util.LinkedList;
import java.util.List;

public class Couch {
  private final int MAX_CUSTOMERS = 4;
  public List<Customer> customersInCouch = new LinkedList<Customer>();

  public void customerSitting(Customer cust){
    customersInCouch.add(cust);
  }
}
