package callable_package;

public class RunnableTask implements Runnable {
	
	Thread thrd;
	int num;
	public RunnableTask(int num) {
		this.num=num;
		thrd=new Thread(this);
		thrd.start();
	}
	@Override
	public void run() {
		System.out.println("Thread "+num+" has started");
		for (int i = num*100; i < num*100+100; i++ ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
