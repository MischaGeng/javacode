package com.dazai.java.learning.thread.ssy;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: FetchMoney
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class FetchMoney {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread t1 = new Terminate(bank);
        Thread t2 = new ATM(bank);

        t1.start();
        t2.start();
    }

}

class Bank {

    private int money = 1000;

    public synchronized void getMoney(int number) {

        if(0 > number) {
            System.out.println(-1);
        }

        if( number > money){
            System.out.println(-2);
        }

        if(0>money) {
            System.out.println(-3);
        }

        money -= number;

        System.out.println(money);

    }

}

class ATM extends Thread {

    private Bank bank;

    ATM(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.getMoney(800);
    }
}



class Terminate extends Thread {

    private Bank bank;

    Terminate(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.getMoney(800);
    }
}
