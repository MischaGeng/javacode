package com.dazai.java.learning.thread.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/08/21
 * @Since JDK 1.8
 * @Title: SynchBank
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class SynchBank {
    private final double[] accounts;

    public SynchBank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {

            if (accounts[from] < amount) wait();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            notifyAll();
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) sum += a;
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
