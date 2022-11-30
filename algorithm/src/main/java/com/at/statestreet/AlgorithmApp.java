package com.at.statestreet;

import com.google.common.base.Stopwatch;

import java.time.Duration;
import java.util.ArrayList;

public class AlgorithmApp {
    public static void main(String[] args) {
        Stopwatch started = Stopwatch.createStarted();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <1000000; i++) {
            list.add(i+"123");
        }
        Duration elapsed = started.elapsed();
        started = Stopwatch.createStarted();

        System.out.println(elapsed.getNano()+" s");
         list = new ArrayList<>(1000000);
        for (int i = 0; i <1000000; i++) {
            list.add(i+"123");
        }
        Duration elapsed1 = started.elapsed();
        System.out.println(elapsed1.getNano()+" s");

    }
}
