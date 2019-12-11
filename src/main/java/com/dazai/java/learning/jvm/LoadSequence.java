package com.dazai.java.learning.jvm;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/30
 * @Since JDK 1.8
 * @Title: LoadSequence
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class LoadSequence {


    private int x = 1;
//    static int y = 2;
//
//    private LoadSequence loadSequence;
//
//    static{
//        System.out.println("Static block code!");
//        System.out.println(y);
//
//    }



    LoadSequence(){
        System.out.println(x);
        System.out.println("Constructor!");
    }

    {
        System.out.println("Instance block code!");
    }

    Test test = new Test();

}
