package de.kulturbremen.kulturapi;

import java.time.ZonedDateTime;

public class Temp {

    public static void main(String[] args){
        String dateString = "2020-09-30T12:29:29Z";
        ZonedDateTime date = ZonedDateTime.parse(dateString);
        System.out.println(date);
    }
}
