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
        // Lógica de pagamento aqui
        System.out.println("Cliente " + this.currentCustomer.getName() + " fez o pagamento.");
        // Reduz o número de barbeiros livres após o pagamento
        this.currentBarber.getBarbershop().freeBarbers++;
    }
}
