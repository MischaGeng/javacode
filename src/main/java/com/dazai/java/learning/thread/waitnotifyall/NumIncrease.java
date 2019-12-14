package com.dazai.java.learning.thread.waitnotifyall;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: NumIncrease
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class NumIncrease extends Thread {


    private Sample sample;

    public NumIncrease (Sample sample) {
        this.sample = sample;
    }

    public void run(){
        for(int i=1; i<20; i++){

            try {
                Thread.sleep((long)(Math.random() * 1000));
                sample.numIncrease();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
