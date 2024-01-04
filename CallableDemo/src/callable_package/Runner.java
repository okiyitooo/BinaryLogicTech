package callable_package;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService =  Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(new CallableTask<String>("Tim",2));
		executorService.submit(new RunnableTask(1));
		try {
//			future.
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
