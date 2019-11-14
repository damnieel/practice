package com.cvc.springboot.thread;

public class ThreadCommunication {
	private static int num;// 定义一个变量作为数据8.

	public static void main(String[] args) throws InterruptedException {

		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// 模拟耗时操作之后初始化变量 num
					Thread.sleep(1000);
					num = 1;

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "获取到 num 的值为：" + num);
			}
		});
		Thread threadC = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "获取到 num 的值为：" + num);
			}
		});
		// 同时开启 3 个线程
		threadA.start();
		threadA.join();
		threadB.start();
		threadC.start();
		
	}
}
