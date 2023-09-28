package com.labs.java.datatime;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) {
        Date currentdatetime = new Date();
        System.out.println(currentdatetime);

        Date lastmonthdate = new Date("2023/08/25 19:10:10");
        System.out.println(lastmonthdate);

        Calendar now = Calendar.getInstance();
        System.out.println(now.getTime());

        System.out.println(now.getTimeInMillis());

        System.out.println(System.currentTimeMillis());
    }
}
