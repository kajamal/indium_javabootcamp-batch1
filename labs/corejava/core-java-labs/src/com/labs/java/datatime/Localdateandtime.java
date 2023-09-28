package com.labs.java.datatime;

import java.time.LocalDateTime;

public class Localdateandtime {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime aftertendays = now.plusDays(10);
        LocalDateTime afterfiveyears = aftertendays.plusYears(5);
        System.out.println(aftertendays);
        System.out.println(afterfiveyears);


        LocalDateTime newyear = LocalDateTime.of(1999,07,25,00,00);
        System.out.println(newyear);
    }
}
