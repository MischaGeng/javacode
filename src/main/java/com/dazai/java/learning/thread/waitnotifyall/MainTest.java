package com.dazai.java.learning.thread.waitnotifyall;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: MainTest
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class MainTest {

    public static void main(String[] args) {

        Sample sample = new Sample();

        Thread thread1 = new NumDecrease(sample);
        Thread thread2 = new NumIncrease(sample);

        thread1.start();
        thread2.start();
    }



}
