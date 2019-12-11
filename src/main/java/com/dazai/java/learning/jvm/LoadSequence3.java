package com.dazai.java.learning.jvm;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/30
 * @Since JDK 1.8
 * @Title: LoadSequence3
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class LoadSequence3 {

    LoadSequence3(String name){
        System.out.println(name);
    }

    LoadSequence3(){
        System.out.println("Constructor!");
    }

    static LoadSequence3 loadSequence3 = new LoadSequence3("Hello!");

    static{
        System.out.println("Static block code!");
    }

    public Test test = new Test();

    {
        System.out.println("Instance block code!");
    }


    public static void main(String[] args) {
        new LoadSequence3();
    }


}
