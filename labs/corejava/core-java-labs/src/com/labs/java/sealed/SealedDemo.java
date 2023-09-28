package com.labs.java.sealed;

public class SealedDemo {
    public static void main(String[] args) {
        vehicle v = new car();
        System.out.println(v);

    }

    abstract sealed class vehicle permits car, car.Truck, truck {
        protected String color;
        void showdetails() {
            System.out.println("vechile");

        }
    }

    class car extends vehicle{
        void showdetails(){
            System.out.println("car");
        }
     final class  Truck extends vehicle {
         void showdetails() {
             System.out.println("truck");
         }
     }}
}
