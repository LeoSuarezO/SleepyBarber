package models;

import java.util.concurrent.Semaphore;

import views.Window;

public class SleepingBarber extends Thread {
    // Shared objects
    // Number of customers waiting for service
    public Semaphore customers = new Semaphore(0);

    // Number of barbers waiting for customers
    public Semaphore barbers = new Semaphore(0);

    // For mutual exclusion
    public Semaphore mutex = new Semaphore(1);

    public int waiting = 0;

    // Chairs for waiting customers
    public final int CHAIRS = 5;

    public static void main(String args[]) {
        SleepingBarber holder = new SleepingBarber();
        Window window = new Window();
        window.setVisible(true);
        holder.start();

    }

    // This thread spins off a number of customers
    public void run() {
        final int BARBERS = 3;

        Barber aBarber;
        Client aCustomer;

        for (int i = 0; i < BARBERS; i++) {
            // Create the barbers
            aBarber = new Barber(i);

            // Start the threads running
            aBarber.start();
        }

        int customerNumber = 0;
        while (true) {
            aCustomer = new Client(customerNumber++);
            // Start the customer running
            System.out.println("Cliente Creado - " + aCustomer.myNumber);
            aCustomer.start();
            // Wait a bit and make another customer
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
            }
            ;
        }
    }

    private class Client extends Thread {
        private int myNumber; // Id for the Customer

        public Client(int i) { // Constructor for the Customer
            myNumber = i;
        }

        public void run() { // What a customer does
            try {
                mutex.acquire(); // Acquire access to waiting
                if (waiting < CHAIRS) {
                    waiting = waiting + 1; // Increment count of waiting
                    // customers
                    customers.release(); // Wake up barber if needed
                    mutex.release(); // Release waiting
                    barbers.acquire(); // Go to sleep if number of free
                    // barbers is 0
                    get_haircut(); // Noncritical region
                } else {
                    mutex.release(); // Shop is full do not wait
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        public void get_haircut() {
            System.out.println("Customer " + myNumber
                    + " is getting his hair cut");
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
            }
        }
    }

    class Barber extends Thread {
        private int myNumber; // Id for the Barber

        public Barber(int i) { // Constructor for the Barber
            myNumber = i;
        }

        public void run() { // What a barber does
            while (true) {
                try {
                    customers.release(); // Go to sleep if no customers
                    mutex.acquire(); // Acquire access to waiting
                    waiting = waiting - 1; // Decrement count of waiting
                    // customers
                    barbers.release(); // One barber is now ready to cut
                    // hair
                    mutex.release(); // Release waiting
                    cut_hair(); // Noncritical region
                } catch (Exception e) {

                }
            }
        }

        public void cut_hair() {
            System.out.println("Barber " + myNumber + " is cutting hair");
            try {
                sleep(7500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
