package com.dazai.java.learning.Generic;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/16
 * @Since JDK 1.8
 * @Title: GenericTest
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class GenericTest<T> {

    private T key;

    public GenericTest(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
