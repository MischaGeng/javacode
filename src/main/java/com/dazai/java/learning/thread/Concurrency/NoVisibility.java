package com.dazai.java.learning.thread.Concurrency;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/10/04
 * @Since JDK 1.8
 * @Title: NoVisibility
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            System.out.println("start!");
            while (!ready) {
                System.out.println("yield!");
                Thread.yield();
            }
            System.out.println(number);

        }
    }

    public static void main(String[] args) {

        new ReaderThread().start();
        number = 42;
        ready = true;
    }

}
