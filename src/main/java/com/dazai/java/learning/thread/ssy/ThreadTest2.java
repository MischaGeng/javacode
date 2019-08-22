package com.dazai.java.learning.thread.ssy;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/08/21
 * @Since JDK 1.8
 * @Title: ThreadTest2
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class ThreadTest2 {

    public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for(int i = 0; i < 100; i++)
				{
					System.out.println("hello :" + i);
				}
			}
		});

		t1.start();

//        Thread t1 = new Thread(new MyThread());
//        t1.start();
//        Thread t2 = new Thread(new MyThread2());
//        t2.start();

    }
}

class MyThread implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hello :" + i);
        }
    }
}

class MyThread2 implements Runnable {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("welcome: " + i);
        }

    }
}

