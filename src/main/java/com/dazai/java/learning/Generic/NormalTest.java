package com.dazai.java.learning.Generic;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/16
 * @Since JDK 1.8
 * @Title: NormalTest
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class NormalTest {

    public static void main(String[] args) {

        GenericTest<Integer> test1 = new GenericTest<>(123);

        GenericTest<String> test2 = new GenericTest<>("String");


        NormalTest normalTest = new NormalTest();

        normalTest.showTheKey(test1);
        normalTest.showTheKey(test2);

        

    }


    public void showTheKey(GenericTest<?> genericTest){

        System.out.println(genericTest.getKey());
    }


}
