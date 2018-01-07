package lab8;


import java.util.Scanner;
import java.util.concurrent.Semaphore;
 
/**
 * @author Sheraz Ahmed
 * 
 */
 
public class SemaphoreLab {
	Scanner s=new Scanner(System.in);
    public static int max = 1;
    public int shared_resource=0;
    public Semaphore sem= new Semaphore(max,true);
    
    public void Start() {
    	System.out.println("Enter no of threads : ");
    	int no_of_threads=s.nextInt();
        for (int i = 1; i <= no_of_threads; i++) {
            Process thread_object= new Process();
            thread_object.start();
        }
    }
    
    public class Process extends Thread {
    	
        
        public void run() {
            try {
                
                // Acquire Lock
                sem.acquire();
            } catch (InterruptedException e) {
                System.out.println("\t*** InterruptedException occured in the code ***");
                return;
            }
           shared_resource++; 
            System.out.println("Thread " + this.getId() + " is using shared resource and new value is "+shared_resource);
            try {
                sleep(1000);
            } catch (Exception e) {
                
            } finally {
                
                // Release Lock
                sem.release();
            }
            System.out.println("Thread " + this.getId() + " have stopped using shared resource\n");
        }
    }
    
    public static void main(String[] args) {
        SemaphoreLab test = new SemaphoreLab();
        test.Start();
        
    }
}