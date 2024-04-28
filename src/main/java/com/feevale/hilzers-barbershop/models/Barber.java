public class Barber extends Thread{
  private Customer currentCustomer;
  private boolean isBusy = false;
  private boolean hasPOS = false;

  Barbershop barbershop;

  public Barber(String nomeThread, Barbershop barbershop){
    super(nomeThread);
    this.barbershop = barbershop;
  }

  public void run(Customer cust){
    try{
      Thread.sleep(10000);
    }
    catch(InterruptedException err){
      err.printStackTrace();
    }
    System.out.println(this.getName() +" está trabalhando");
    while(true){
      barbershop.hairCutting(this);
    }
  }
}
