package Main;


public class PaymentOperationalSystem extends Thread {
    private Barber currentBarber;
    private Customer currentCustomer;

    public void setCurrentBarber(Barber barber) {
        this.currentBarber = barber;
    }

    public void setCurrentCustomer(Customer customer) {
        this.currentCustomer = customer;
    }

    public void processPayment() {
        // L�gica de pagamento aqui
        System.out.println("Cliente " + this.currentCustomer.getName() + " fez o pagamento.");
        // Reduz o n�mero de barbeiros livres ap�s o pagamento
        this.currentBarber.getBarbershop().freeBarbers++;
    }
}
