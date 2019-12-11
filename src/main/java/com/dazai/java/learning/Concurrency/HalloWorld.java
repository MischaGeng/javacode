package com.dazai.java.learning.Concurrency;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/10/10
 * @Since JDK 1.8
 * @Title: HalloWorld
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class HalloWorld {

    public static void main(String[] args) {
        HalloWorld halloWorld = new HalloWorld();
//        halloWorld.testPrint("Hallo World!");

        Test test = new Test();
        int c = test.Increase(1, 3);
        System.out.println(c);
    }





    public void testPrint(String s){

        System.out.println(s);

    }



}
