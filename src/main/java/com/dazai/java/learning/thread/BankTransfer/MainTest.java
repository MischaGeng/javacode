package com.dazai.java.learning.thread.BankTransfer;

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

        Account a = new Account(10000);
        Account b = new Account(5000);
        Account c = new Account(20000);


        TransactionThread t1 = new TransactionThread(a, b);
        TransactionThread t2 = new TransactionThread(b, c);

        t1.start();
        t2.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("a余额" + a.getBalance());
        System.out.println("b余额" + b.getBalance());
        System.out.println("c余额" + c.getBalance());

    }

}
