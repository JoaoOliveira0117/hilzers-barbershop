package Main;

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
  Couch couch = new Couch();

  public int hairCutting(Barber barber){
	    Customer customer;
	    synchronized(couch){
	        while(couch.customersInCouch.size() == 0){
	            System.out.println("Barbeiro " + barber.getName() + " dormindo esperando por cliente");
	            try {
	                couch.wait();
	            } catch (InterruptedException err) {
	                err.printStackTrace();
	            }
	        }
	        customer = (Customer)((LinkedList<?>)couch.customersInCouch).poll();
	        System.out.println("Cliente " + customer.getName() + " acordou o barbeiro " + barber.getName());

	        // Notifica o barbeiro após adicionar um cliente à lista
	        couch.notify();
	    }

	    synchronized(customersInBarbershop){
	        if(customersInBarbershop.size() > 1){
	            Customer customerToCouch = ((LinkedList<Customer>)customersInBarbershop).poll();
	            ((LinkedList<Customer>)couch.customersInCouch).offer(customerToCouch);
	            System.out.println("Cliente " + customerToCouch.getName() + " sentou no sofá");
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
	        System.out.println("Barbeiro " + chairs.get(indexCurrentChair).currentBarber.getName() + " está cortando o cabelo do cliente " 
	            + chairs.get(indexCurrentChair).currentCustomer.getName());

	        Thread.sleep((int)Math.random() * 10);
	        System.out.println("Barbeiro " + chairs.get(indexCurrentChair).currentBarber.getName() + " terminou de cortar o cabelo do cliente "
	            + chairs.get(indexCurrentChair).currentCustomer.getName());

	    } catch (InterruptedException err) {
	        err.printStackTrace();
	    }

	    return indexCurrentChair;
	}

  public void enteringCustomer(Customer customer) {
	    synchronized (customersInBarbershop) {
	        synchronized (couch.customersInCouch) {
	            if (customersInBarbershop.size() + couch.customersInCouch.size() == 20) {
	                System.out.println("Cliente " + customer.getName() + " não entrou na barbearia por estar cheia!");
	            } else if (freeBarbers > 0) {
	                System.out.println("Cliente " + customer.getName() + " entrou na barbearia");
	                ((LinkedList<Customer>) couch.customersInCouch).offer(customer);
	                couch.customersInCouch.notify();
	            } else if (couch.customersInCouch.size() < 4) {
	                System.out.println("Cliente " + customer.getName() + " entrou na barbearia");
	                ((LinkedList<Customer>) couch.customersInCouch).offer(customer);
	                System.out.println("Cliente " + customer.getName() + " sentou no sofá");
	            } else {
	                System.out.println("Cliente " + customer.getName() + " entrou na barbearia");
	                ((LinkedList<Customer>) customersInBarbershop).offer(customer);
	                System.out.println("Cliente " + customer.getName() + " espera um lugar no sofá");
	            }
	        }
	    }
	}
}
