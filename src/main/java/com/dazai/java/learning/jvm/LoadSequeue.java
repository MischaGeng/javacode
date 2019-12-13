package com.dazai.java.learning.jvm;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/29
 * @Since JDK 1.8
 * @Title: LoadSequeue
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class LoadSequeue {
    //类实例
    public static LoadSequeue t1 = new LoadSequeue("constructorA");
    //静态语句块,在类初始化时,仅仅执行一次.

    //实例化代码块.每次生成类实例,都会执行.并且,实例化代码块的执行 优先于 构造器.
    {
        System.out.println("blockA");
    }

    static{
        System.out.println("blockB");
    }


    //构造器方法
    LoadSequeue(){
        System.out.println("constructorB");
    }

    LoadSequeue(String input) {
        System.out.println(input);
    }

    public static void main(String[] args)
    {
        //类实例
        LoadSequeue t2 = new LoadSequeue();
    }

}
