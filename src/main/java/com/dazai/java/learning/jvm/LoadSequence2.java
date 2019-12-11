package com.dazai.java.learning.jvm;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/30
 * @Since JDK 1.8
 * @Title: LoadSequence2
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class LoadSequence2 extends LoadSequence{

    LoadSequence2(){
        System.out.println("Constructor!");
    }


    {
        System.out.println("block code!");
    }
    public Test test = new Test();




    public static void main(String[] args) {

        new LoadSequence2();


    }

}
