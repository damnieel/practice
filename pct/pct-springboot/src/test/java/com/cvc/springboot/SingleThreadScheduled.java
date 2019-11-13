package com.cvc.springboot;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduled {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();

		es.schedule(new Runnable() {

			public void run() {

				System.out.println("now " + new Date());
			}

		}, 1, TimeUnit.SECONDS);
		es.scheduleWithFixedDelay(new Runnable(){public void run() {System.out.println("now " + new Date());}} ,0, 1 , TimeUnit.SECONDS);
	}
}
