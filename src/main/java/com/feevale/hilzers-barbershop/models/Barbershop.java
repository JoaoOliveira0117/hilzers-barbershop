import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Barbershop {
  public final int MAX_CUSTOMERS= 20;
  public final int MAX_CHAIRS = 3;
  public final int MAX_BARBERS = 3;
  public int freeBarbers = MAX_BARBERS;
  List<Customer> customersInBarbershop = new LinkedList<Customer>();
  ArrayList<Chair> chairs = new ArrayList<Chair>();
  List<Customer> couch = new LinkedList<Customer>();

  public int hairCutting(Barber barber){
	    Customer customer, customerToCouch;
	    synchronized(couch){
	        while(couch.size() == 0){
	            System.out.println("Barbeiro " + barber.getName() + " dormindo esperando por cliente");
	            try {
	                couch.wait();
	            } catch (InterruptedException err) {
	                err.printStackTrace();
	            }
	        }
	        customer = (Customer)((LinkedList<?>)couch).poll();
	        System.out.println("Cliente " + customer.getName() + " acordou o barbeiro " + barber.getName());

	        // Notifica o barbeiro apos adicionar um cliente a lista
	        couch.notify();
	    }

	    synchronized(customersInBarbershop){
	        if(customersInBarbershop.size() > 1){
	            customerToCouch = (Customer)((LinkedList<?>)customersInBarbershop).poll();
	            ((LinkedList<Customer>)couch).offer(customerToCouch);
	            System.out.println("Cliente " + customerToCouch.getName() + " sentou no sofa");
	        }
	    }

	    int indexCurrentChair;
	    synchronized(chairs){
	        Chair chair = new Chair(customer, barber);
	        chairs.add(chair);
	        indexCurrentChair = chairs.indexOf(chair);
	    }

	    try {
	        freeBarbers--;
	        System.out.println("Barbeiro " + chairs.get(indexCurrentChair).currentBarber.getName() + " esta cortando o cabelo do cliente " 
	            + chairs.get(indexCurrentChair).currentCustomer.getName());

	        Thread.sleep(20000);
	        System.out.println("Barbeiro " + chairs.get(indexCurrentChair).currentBarber.getName() + " terminou de cortar o cabelo do cliente "
	            + chairs.get(indexCurrentChair).currentCustomer.getName());

	    } catch (InterruptedException err) {
	        err.printStackTrace();
	    }

	    return indexCurrentChair;
	}

  public void enteringCustomer(Customer customer) {
	    synchronized (customersInBarbershop) {
	        synchronized (couch) {
	            if (customersInBarbershop.size() + couch.size() == 20) {
	                System.out.println("Cliente " + customer.getName() + " nao entrou na barbearia por estar cheia!");
	            } else if (freeBarbers > 0) {
	                System.out.println("Cliente " + customer.getName() + " entrou na barbearia");
	                ((LinkedList<Customer>) couch).offer(customer);
	                couch.notify();
	            } else if (couch.size() < 4) {
	                System.out.println("Cliente " + customer.getName() + " entrou na barbearia");
	                ((LinkedList<Customer>) couch).offer(customer);
	                System.out.println("Cliente " + customer.getName() + " sentou no sofa");
	            } else {
	                System.out.println("Cliente " + customer.getName() + " entrou na barbearia");
	                ((LinkedList<Customer>) customersInBarbershop).offer(customer);
	                System.out.println("Cliente " + customer.getName() + " espera um lugar no sofa");
	            }
	        }
		}
	}
}
