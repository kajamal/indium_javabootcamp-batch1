package com.labs.java.Lambda;

import java.util.List;
import java.util.function.*;

public class StdFunInterfaceDemo {

    public static void main(String[] args) {

        Predicate<Integer> condition = (a) -> a > 10;
        System.out.println(condition.test(5));

        Function<Integer, Integer> compute = (a) -> a +10;
        System.out.println(compute.apply(50));

        UnaryOperator<Integer> square = a -> a * a;
        System.out.println(square.apply(6));

        BiFunction<Integer,Double,Double> addition = (a,b) -> a+ b;
        System.out.println(addition.apply(10,20.5));

        Consumer<String> greeting = message -> System.out.println(message);
        greeting.accept("hello");

        BiConsumer<String,String> greeting1 = (ms1,ms2) -> System.out.println(ms1+""+ ms2);
        greeting1.accept("hello", "World");

        Supplier<List> skills = () -> {return List.of("java",".net");};
        System.out.println(skills.get());
        }
    }


