

public class Barber extends Thread {
    private Barbershop barbershop;
    private PaymentOperationalSystem paymentSystem;

    public Barber(String nomeThread, Barbershop barbershop, PaymentOperationalSystem paymentSystem) {
        super(nomeThread);
        this.barbershop = barbershop;
        this.paymentSystem = paymentSystem;
    }

    public Barbershop getBarbershop() {
        return this.barbershop;
    }

    @Override
    public void run() {
        // Loop infinito para manter o barbeiro trabalhando continuamente
        while (true) {
            // Obtém o índice da cadeira atual em que o barbeiro está cortando o cabelo de um cliente
            int indexCurrentChair = barbershop.hairCutting(this);
            
            if (paymentSystem.getCurrentBarber() == null) {
                // Define o barbeiro atual no sistema de pagamento
                paymentSystem.setCurrentBarber(this);
                
                // Define o cliente atual no sistema de pagamento, obtido da cadeira atual
                paymentSystem.setCurrentCustomer(barbershop.chairs.get(indexCurrentChair).currentCustomer);
                
                // Realiza o pagamento utilizando o sistema de pagamento
                paymentSystem.processPayment();
            }
            
            // Adiciona um pequeno intervalo entre os atendimentos para simular o tempo de espera do barbeiro
            try {
                Thread.sleep(1000); // Espera 1 segundo antes de atender o próximo cliente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




