package threaderer;

public class ExtendThread {
	public static void main(String[] args) {
		System.out.println("Main thread starting.");
		
		MyThread mt = new MyThread("Child #1");
		mt.start();
		for (int i = 0; i < 50; i++) {
			System.out.print(".");
			try { 
				Thread.sleep(100);
			}
			catch(InterruptedException exc) { 
				System.out.println("Main Thread Interrupted.");
			}
		}
		System.out.println("Main thread ending.");
	}
}

class MyThread extends Thread {
	MyThread(String name) {
		super(name);
	}
	public void run() {
		System.out.println(getName()+" starting.");
		try {
			for (int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + getName() + ", count is " + count+".");;
			}
		}
		catch(InterruptedException e ) {
			System.out.println(getName() + " interrupted.");
		}
		System.out.println(getName()+ " terminating.");
	}
}