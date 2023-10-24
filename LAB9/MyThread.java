public class MyThread extends Thread {

    public void afiseazaConsola() {
        System.out.println("Thread " + threadId() + " started.");
    }

    @Override
    public void run() {
        try {
            afiseazaConsola();
            Thread.sleep(10000);
            System.out.println("Thread " + threadId() + " completed after sleeping for 10 seconds.");
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadId() + " was canceled.");
        }
    }
}
