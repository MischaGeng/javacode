package com.dazai.java.learning.thread.BankTransfer;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: Account
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class Account {

    private Allocator allocator = Allocator.getInstance();

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void transaction(Account target, int number) throws InterruptedException {

        while (!allocator.apply(this, target)) {
            wait();
        }

        try {
            synchronized (this) {
                synchronized (target) {
                    if (0 < this.balance - number) {
                        this.balance -= number;
                        target.balance += number;
                    }
                    System.out.println(this.balance);
                    System.out.println(target.balance);
                    System.out.println("------------------");
                }
            }

        } finally {
            allocator.release(this, target);
            notifyAll();
        }

    }

    public int getBalance() {
        return this.balance;
    }

}
