package com.dazai.java.learning.thread.BankTransfer;

import java.util.ArrayList;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/12/14
 * @Since JDK 1.8
 * @Title: Allocator
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class Allocator {

    public ArrayList<Account> list = new ArrayList<>();

    private Allocator() {
    }

    public static Allocator getInstance() {
        return SigleAllocator.instance;
    }

    static class SigleAllocator {
        public static Allocator instance = new Allocator();
    }

    public synchronized boolean apply(Account src, Account target) {
        if(list.contains(src) || list.contains(target)){
            return false;
        }

        list.add(src);
        list.add(target);

        return true;
    }

    public synchronized void release(Account src, Account target) {

        list.remove(src);
        list.remove(target);

    }


}
