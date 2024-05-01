import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop();
        Random random = new Random();
        System.out.println("Bem vindo a barbearia!");
        

        for(int i = 1; i<=barbershop.MAX_BARBERS; i++){
            Barber barber = new Barber(""+ i, barbershop);
            barber.start();
        }

        int delayMs = 0;
        for(int i = 1; i <= 40; i++){
            Double randomTime = random.nextGaussian() * 1000 + 2000;
            delayMs = Math.abs((int)Math.round(randomTime));
            Customer customer = new Customer("" + i);
            barbershop.enteringCustomer(customer);
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
