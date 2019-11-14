package com.cvc.springboot.thread;
/**
 * 线程通信的方式：共享变量
 * 线程间通信可以通过发送信号，发送信号的一个简单方式是在共享对象的变量里设置信号值。
 * 线程A在一个同步块里设置boolean型成员变量hasDataToProcess为true，
 * 线程B也在同步块里读取hasDataToProcess这个成员变量。
 * 这个简单的例子使用了一个持有信号的对象，并提供了set和get方法：
 */
public class MySignal {
	  //共享的变量
    private boolean hasDataToProcess = false;

    //取值
    public boolean getHasDataToProcess() {
        return hasDataToProcess;
    }
    //存值
    public void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }

    public static void main(String[] args) {
        //同一个对象
        final MySignal my = new MySignal();
        //线程 1 设置 hasDataToProcess 值为 true
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                my.setHasDataToProcess(true);
            }
        });
        t1.start();
        //线程 2 取这个值 hasDataToProcess
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    //等待线程 1 完成然后取值
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                my.getHasDataToProcess();
                System.out.println("t1 改变以后的值：" + my.getHasDataToProcess());
            }
        });
        t2.start();
    }
}
