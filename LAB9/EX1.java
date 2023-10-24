import java.util.Scanner;
import java.util.Vector;

public class EX1 {

    public static void StopThread(Vector<MyThread> threads, long threadIdToStop) {
        for (MyThread myThread : threads) {
            if (myThread.getId() == threadIdToStop) {
                myThread.interrupt();
            }
        }
    }
    
    


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        Vector<MyThread> threads = new Vector<>();
        
        for(int i=0;i<number;i++)
        {
            MyThread thread = new MyThread();
            
            threads.add(thread);
            thread.start();
        }
        long threadToStop = scn.nextInt();
        EX1.StopThread(threads,threadToStop);
    }
}
