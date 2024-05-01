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
        System.out.println("Barbeiro " + this.currentBarber.getName() + " fez o pagamento do cliente " + this.currentCustomer.getName());
        // Aumenta o n�mero de barbeiros livres ap�s o pagamento
        this.currentBarber.getBarbershop().freeBarbers++;
    }
}
