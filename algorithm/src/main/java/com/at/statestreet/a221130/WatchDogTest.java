package com.at.statestreet.a221130;

import com.google.common.base.Stopwatch;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class WatchDogTest {
    /**
     * 哨兵对代码性能的影响
     *19405100
     *18242099
     */
    public static void main(String[] args) {
        String[] strings = new String[1000000];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = UUID.randomUUID().toString();
        }
        String s = UUID.randomUUID().toString();
        findIndex(s,strings);
        findIndexWithWatchDog(s,strings);
    }


    public static int findIndex(String value, String[] col){
        Stopwatch started = Stopwatch.createStarted();

        int length = col.length;
        for (int i = 0; i < length; i++) {
            if(Objects.equals(col[i], value))return i;
        }
         System.out.println(started.elapsed().getNano());
        return -1;
    }

    public static int findIndexWithWatchDog(String value, String[] col){
        Stopwatch started = Stopwatch.createStarted();

        int endIndex = col.length-1;
        String end = col[endIndex];
        if(end == value)return endIndex;
        col[endIndex] = value;
        int i = 0;
        for (; !Objects.equals(col[i], value); i++) {

        }
        System.out.println(started.elapsed().getNano());
        return i == endIndex  ? -1 : i;
    }

}
