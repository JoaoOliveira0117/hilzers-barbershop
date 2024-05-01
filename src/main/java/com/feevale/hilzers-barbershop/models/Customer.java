

public class Customer extends Thread{
	  Barbershop barbershop;

	  public Customer(String nomeThread){
	    super(nomeThread);
	  }

	  public void run(Barbershop barbershop){
	    hairCut();
	  }

	  public synchronized void hairCut(){
	    barbershop.couch.add(this);
	  }
	}



