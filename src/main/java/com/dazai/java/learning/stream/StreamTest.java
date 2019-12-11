package com.dazai.java.learning.stream;

import java.math.BigInteger;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/15
 * @Since JDK 1.8
 * @Title: StreamTest
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class StreamTest {

    public static void main(String[] args) {

        Stream<String> echos = Stream.generate(() -> "echo");
        show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        show("Integers", integerStream);

    }

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else System.out.print("...");
        }
        System.out.println();

    }
}
