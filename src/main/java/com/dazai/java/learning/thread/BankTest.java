package com.dazai.java.learning.thread;

import com.dazai.java.learning.thread.lock.LockBank;
import com.dazai.java.learning.thread.unsynch.UnSafeBank;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/08/20
 * @Since JDK 1.8
 * @Title: BankTest
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class BankTest {

    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
//        UnSafeBank unSafeBank = new UnSafeBank(NACCOUNTS, INITIAL_BALANCE);
        LockBank bank = new LockBank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
//            Runnable r = () -> {
//
//                try {
//                    while (true) {
//                        int toAccount = (int) (bank.size() * Math.random());
//                        double amount = MAX_AMOUNT * Math.random();
//                        bank.transfer(fromAccount, toAccount, amount);
//                        Thread.sleep((int) (DELAY * Math.random()));
//                    }
//                } catch (InterruptedException e) {
//
//                }
//            };

//            Thread t = new Thread(r);
//            t.start();
        }

    }

}
