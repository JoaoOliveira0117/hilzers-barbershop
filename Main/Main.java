package Main;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop();
        System.out.println("Bem vindo a barbearia!");

        // Simulação de entrada do cliente na barbearia e atendimento pelo barbeiro
        for (int i = 1; i <= 20; i++) {
            Customer customer = new Customer("" + i, new Date());
            barbershop.enteringCustomer(customer);
        }

        // Create and start multiple barber threads
        for (int i = 1; i <= 3; i++) {
            Barber barber = new Barber("Barbeiro " + i, barbershop);
            barber.start();
        }
    }
}
