package com.cvc.springboot.thread;

public class DeadLockSolveBySort {
	public int flag = 1;
    //静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();

    public void money(int flag) {
        this.flag = flag;
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("当前的线程是" +
                            Thread.currentThread().getName() + " " + "flag 的值" + "1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("当前的线程是" +
                            Thread.currentThread().getName() + " " + "flag 的值" + "0");
                }
            }
        }
    }

    public static void main(String[] args) {
        final DeadLockSolveBySort td1 = new DeadLockSolveBySort();
        final DeadLockSolveBySort td2 = new DeadLockSolveBySort();
        td1.flag = 1;
        td2.flag = 0;
        //td1，td2 都处于可执行状态，但 JVM 线程调度先执行哪个线程是不确定的。
        //td2 的 run()可能在 td1 的 run()之前运行
        final Thread t1 = new Thread(new Runnable() {
            public void run() {
                td1.flag = 1;
                td1.money(1);
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                // TODO Auto-generated method stub
                try {
                    //让 t2 等待 t1 执行完
                    t1.join();//核心代码，让 t1 执行完后 t2 才会执行
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                td2.flag = 0;
                td1.money(0);
            }
        });
        t2.start();
    }
}
