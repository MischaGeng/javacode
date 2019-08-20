package com.dazai.java.learning.thread.ssy;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/08/20
 * @Since JDK 1.8
 * @Title: ThreadTest
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class ThreadTest {

    public static void main(String[] args)
    {
        Thread t1 = new Thread1("first thread");
        Thread t2 = new Thread2("second thread");

//        System.out.println(t1.getName());
//        System.out.println(t2.getName());

        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread
{
    public Thread1(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println(Thread.currentThread() + " : " + " hello world: " + i);
        }
    }
}

class Thread2 extends Thread
{
    public Thread2(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println(Thread.currentThread() + " : " +" welcome: " + i);
        }
    }
}
