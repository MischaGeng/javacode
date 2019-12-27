package com.dazai.java.learning.thread.BankTransfer;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: TransactionThread
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class TransactionThread extends Thread {

    private Account myAccount;
    private Account targetAccount;

    public TransactionThread(Account account, Account targetAccount) {
        this.myAccount = account;
        this.targetAccount = targetAccount;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {

                Thread.sleep((long)(Math.random() * 1000));
                myAccount.transaction(targetAccount, 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
