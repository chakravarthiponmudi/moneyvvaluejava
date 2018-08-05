package com.learning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Runnable runnableTask = () -> {
		    int i=0;
			while(i < Integer.MAX_VALUE-10) {
				i++;
				i=0;
//				System.out.println("runing");
			}
		};
		
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		executorService.execute(runnableTask);
		
		

	}

}
