


public class PaymentOperationalSystem extends Thread {
    private Barber currentBarber;
    private Customer currentCustomer;

    // Define o barbeiro atual
    public void setCurrentBarber(Barber barber) {
        this.currentBarber = barber;
    }

    // Define o cliente atual
    public void setCurrentCustomer(Customer customer) {
        this.currentCustomer = customer;
    }

    public void processPayment() {
        // Logica de pagamento aqui
    	System.out.println("Cliente " + this.currentCustomer.getName() + " efetuou o pagamento ao Barbeiro " + "Barbeiro " + this.currentBarber.getName());
        // Aumenta o numero de barbeiros livres apos pagamento
        this.currentBarber.getBarbershop().freeBarbers++;
    }
}



