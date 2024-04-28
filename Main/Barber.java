package Main;
public class Barber extends Thread {
    private Barbershop barbershop;

    public Barber(String nomeThread, Barbershop barbershop) {
        super(nomeThread);
        this.barbershop = barbershop;
    }

    public Barbershop getBarbershop() {
        return this.barbershop;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // Tempo de espera inicial do barbeiro
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        System.out.println(this.getName() + " está trabalhando");

        while (true) {
            int indexCurrentChair = barbershop.hairCutting(this);
            PaymentOperationalSystem paymentSystem = new PaymentOperationalSystem();
            paymentSystem.setCurrentBarber(this);
            paymentSystem.setCurrentCustomer(barbershop.chairs.get(indexCurrentChair).currentCustomer);
            // Realiza o pagamento utilizando o PaymentOperationalSystem
            paymentSystem.processPayment();
            // Adiciona um pequeno intervalo entre os atendimentos para simular o tempo de espera do barbeiro
            try {
                Thread.sleep(1000); // Espera 1 segundo antes de atender o próximo cliente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




//package Main;
//
//public class Barber extends Thread {
//  private Barbershop barbershop;
//
//  public Barber(String nomeThread, Barbershop barbershop) {
//      super(nomeThread);
//      this.barbershop = barbershop;
//  }
//
//  @Override
//  public void run() {
//      try {
//          Thread.sleep(1000); // Tempo de espera inicial do barbeiro
//      } catch (InterruptedException err) {
//          err.printStackTrace();
//      }
//      System.out.println(this.getName() + " está trabalhando");
//
//      while (true) {
//          int indexCurrentChair = barbershop.hairCutting(this);
//          // Realiza o pagamento após o corte de cabelo
//         // barbershop.payment(barbershop.chairs.get(indexCurrentChair).currentCustomer, this);
//
//          // Adiciona um pequeno intervalo entre os atendimentos para simular o tempo de espera do barbeiro
//          try {
//              Thread.sleep(1000); // Espera 1 segundo antes de atender o próximo cliente
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }
//      }
//  }
//}
//
//

