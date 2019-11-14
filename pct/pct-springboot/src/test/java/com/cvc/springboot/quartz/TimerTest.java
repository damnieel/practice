package com.cvc.springboot.quartz;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// task to run goes here
				// 执行的输出的内容
				System.out.println("Hello, stranger" + new Date());
			}
		};
		Timer timer = new Timer();
		// 定义开始等待时间 --- 等待 5 秒
		// 1000ms = 1s
		long delay = 2000;
		// 定义每次执行的间隔时间
		long intevalPeriod = 5 * 1000;
		// schedules the task to be run in an interval
		// 安排任务在一段时间内运行
		System.out.println("now" + new Date());
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}
}
