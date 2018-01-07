
package lab8;
import java.util.Scanner;

public class Assignment extends Thread{
	/*public static int semaphore=1;
	public static String shared="";*/
	
	public Assignment(String name){
		super(name);
		run();
	}
	
	
	
	private void semwait(){
		while(Shared.available_resources<=5);
		Shared.available_resources--; //decremented
		
	}

	private void signal(){
		Shared.available_resources++; //incremented
		
	}
	public void run(){
		do{
			semwait();		
			try {
				System.out.println("Entered");
				System.out.println(""+this.getName()+" is using the shared resource [Critical Section]");
				System.out.println("Exited");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			signal();
		}while(true);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of threads :");
		int input=s.nextInt();
		for(int i=1;i<=input;i++){
			new Assignment("Process "+i+"").start();
		}

	}

}



