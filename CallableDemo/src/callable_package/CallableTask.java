package callable_package;

import java.util.concurrent.Callable;

public class CallableTask<V> implements Callable<V> {
	
	private V v;
	private int num;
	public CallableTask(V v, int num){
		this.num=num;
		this.v = v;
	}
	
	@Override
	public V call() throws Exception {
		System.out.println("Thread "+num+" has started");
		for (int i = num*100;i < (num*100) + 100; i++) {
			Thread.sleep(200);
			System.out.println(i);
		}
		return v;
	}
	
}
