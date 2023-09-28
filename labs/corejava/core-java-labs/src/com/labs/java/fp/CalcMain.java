package com.labs.java.fp;

public class CalcMain {
    public static void main(String[] args) {
//        CalcOPP calcOOP= new CalcOPP();
//
//        calcOOP.a = 50;
//        calcOOP.b = 25;
//
//
//
//        System.out.println(calcOOP.add());
//
//        calcOOP.a= 10;
//        calcOOP.b=5;
//        System.out.println(calcOOP.sub());
//
//        System.out.println(calcOOP.mul());
//
//        System.out.println(calcOOP.div());
//
      // CalcFp ca = new CalcFp();
//        int resultAdd = ca.add(10, 20);
//        int resultSub = ca.sub(20, 50);
//        int resultDiv = ca.div(10, 2);
//
//        System.out.println("Addition result: " + resultAdd);
//        System.out.println("Subtraction result: " + resultSub);
//        System.out.println("Division result: " + resultDiv);
//        CalcFp ca = new CalcFp();

//        int sum = ca.compute("add", 10, 20);
//        System.out.println(sum);
//
//    }
   // }
//    class add implements MathOperation {
//    @Override
//    public int compute(int a, int b) {
//        return a+b;
//    }
        CalcFp ca = new CalcFp();
         MathOperation addOperation = (a, b) -> a + b;
         MathOperation subOperation = (a, b) -> a - b;
         MathOperation divOperation = (a, b) -> a / b;

        int result = ca.compute(addOperation,10,20);
    System.out.println(result);
    }}




