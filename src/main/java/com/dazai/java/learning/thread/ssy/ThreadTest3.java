package com.dazai.java.learning.thread.ssy;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/08/21
 * @Since JDK 1.8
 * @Title: ThreadTest3
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class ThreadTest3
{
    public static void main(String[] args)
    {
        Runnable r = new HelloThread();

        Thread t1 = new Thread(r);

//        r = new HelloThread();

        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class HelloThread implements Runnable
{
    int i;


    public void run()
    {
//        int i = 0;

        while(true)
        {
            System.out.println(Thread.currentThread() +" : "+"number: " + this.i++);

            try
            {
                Thread.sleep((long)(Math.random() * 1000));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if(50 == this.i)
            {
                break;
            }
        }
    }
}

