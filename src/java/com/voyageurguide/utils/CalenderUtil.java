/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author libin
 */
public class CalenderUtil {

    public static class Calander {
        private String year;
        private String month;
        private String day;
        
        public Calander(String year, String month, String day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String getYear() {
            return year;
        }

        public String getMonth() {
            return month;
        }

        public String getDay() {
            return day;
        }
        
        
    }

    public static Calander getCalender(String date) {
        String[] split = date.split("/");
        
        String day = split[0];
        String month = split[1];
        String year = split[2];
        
        List<Month> collect = Arrays.asList(Month.values()).stream().filter(mon -> mon.value == Integer.parseInt(month)).collect(Collectors.toList());
        
        String mnt = "JAN";
        if (!collect.isEmpty()) {
            mnt = collect.get(0).name();
        }
        return new Calander(year, mnt, day);
    }

    enum Month {
        JAN(1),
        FEB(2),
        MAR(3),
        APR(4),
        MAY(5),
        JUN(6),
        JUL(7),
        AUG(8),
        SEP(9),
        OCT(10),
        NOV(11),
        DEC(12);
        
        private int value;
        private Month(int val){
            this.value = val;
        }
        
    }
}
