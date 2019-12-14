package com.dazai.java.learning.thread.waitnotifyall;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: NumDecrease
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class NumDecrease extends Thread {

    private Sample sample;

    public NumDecrease (Sample sample) {
        this.sample = sample;
    }

    public void run(){

        for(int i=1; i<20; i++){

            try {
                Thread.sleep((long)(Math.random() * 1000));
                sample.numDecrease();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
