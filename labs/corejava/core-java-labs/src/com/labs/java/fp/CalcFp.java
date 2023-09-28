package com.labs.java.fp;

public class CalcFp {

    //    public int add(int a, int b) {
//        return a + b;
//
//
//    }
//
//    public int sub(int a, int b) {
//        return a - b;
//
//    }
//
//    public int div(int a, int b) {
//        return a / b;
//
//
//    }
//
//    public int compute(String operation, int a, int b) {
//        switch (operation) {
//            case "add":
//                return a + b;
//            case "sub":
//                return a - b;
//            case "div":
//                return a / b;
//            default:
//                System.out.println("invalid operator");
//
//        }
//        return 0;
//    }

    public int compute(MathOperation operation, int a, int b) {
        return operation.compute(a, b);
    }
}
