package com.dazai.java.learning.thread.waitnotifyall;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: Sample
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class Sample {

    int number = 0;

    public synchronized void numIncrease() throws InterruptedException {
        while (0 != number){
            wait();
        }

        number++;
        System.out.println(number);
        notifyAll();

    }

    public synchronized void numDecrease() throws InterruptedException {
        while (0 == number){
            wait();
        }

        number--;
        System.out.println(number);
        notifyAll();
    }

}
