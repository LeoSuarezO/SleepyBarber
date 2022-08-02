package models;

import java.util.concurrent.Semaphore;

import views.Window;

public class SleepingBarber extends Thread {

    Window window = new Window();

    // Shared objects
    // Number of customers waiting for service
    public Semaphore customers = new Semaphore(0);

    // Number of barbers waiting for customers
    public Semaphore barbers = new Semaphore(0);

    // For mutual exclusion
    public Semaphore mutex = new Semaphore(1);

    public int waiting = 0;
    public int losed = 0;
    public int time = 0;
    public int attended = 0;
    // Chairs for waiting customers
    public final int CHAIRS = 5;

    public static void main(String args[]) {
        SleepingBarber holder = new SleepingBarber();
        holder.window.setVisible(true);
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
            window.createBarber(aBarber.myNumber);
            // Start the threads running
            aBarber.start();
        }

        int customerNumber = 0;
        while (true) {
            window.updateTime(time++);
            aCustomer = new Client(customerNumber++);
            window.createClient(aCustomer.myNumber);
            // Start the customer running
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
                mutex.release(); // Acquire access to waiting
                if (waiting < CHAIRS) {
                    waiting = waiting + 1; // Increment count of waiting
                    window.updateWaiting(waiting);
                    customers.acquire(); // Wake up barber if needed
                    mutex.acquire(); // Release waiting
                    barbers.release(); // Go to sleep if number of free
                    // barbers is 0
                    get_haircut(); // Noncritical region
                } else {
                    window.markFullRoom(myNumber);
                    losed++;
                    window.updateLosed(losed);
                    mutex.acquire(); // Shop is full do not wait
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        public void get_haircut() {
            System.out.println("Customer " + myNumber
                    + " is getting his hair cut");
            window.checkDuringCut(myNumber);
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
                    window.sleeping(myNumber);
                    customers.release(); // Go to sleep if no customers
                    mutex.release(); // Acquire access to waiting
                    waiting = waiting - 1; // Decrement count of waiting
                    window.updateWaiting(waiting);
                    barbers.acquire(); // One barber is now ready to cut
                    // hair
                    mutex.acquire(); // Release waiting
                    cut_hair(); // Noncritical region
                } catch (Exception e) {

                }
            }
        }

        public void cut_hair() {
            System.out.println("Barber " + myNumber + " is cutting hair");
            window.showBusyStatus(myNumber);
            try {
                sleep(7500);
                attended++;
                window.showAvaliableStatus(myNumber, attended);
                sleep(250);
            } catch (InterruptedException ex) {
            }
        }
    }
}
