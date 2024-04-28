package Main;

import java.util.Date;

public class Customer extends Thread{
  private Date waitTime;

  Barbershop barbershop;

  public Customer(String nomeThread, Date waitTime){
    super(nomeThread);
    this.waitTime = waitTime;
  }

  public void run(Barbershop barbershop, Couch couch){
    hairCut();
  }

  public synchronized void hairCut(){
    barbershop.couch.customersInCouch.add(this);
  }
}