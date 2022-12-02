package com.at.statestreet.a221202;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.Map;

public class RecursionTest {
    public static void main(String[] args) {
        Stopwatch started = Stopwatch.createStarted();
        getTotal(1000,new HashMap<Integer, Integer>());
        System.out.println(started.elapsed().getNano());
        getTotalByWhile(1000,new HashMap<Integer, Integer>());
        System.out.println(started.elapsed().getNano());
    }

    /**
     * 递归求n阶台阶有多少种走法，每次只能走一阶或者两阶
     *
     *  调试递归:
     * 1.打印日志发现，递归值。
     * 2.结合条件断点进行调试。
     */
    public static int getTotal(int n, Map<Integer,Integer> cache){
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        if(n == 1)return 1;
        if(n == 2) return 2;
        int tmm = getTotal(n-1,cache) + getTotal(n-2,cache);
        cache.put(n,tmm);
       return tmm;
    }

    public static  int getTotalByWhile(int n,Map<Integer,Integer> cache){
        if(n == 1)return 1;
        if(n == 2) return 2;
        int former = 1;
        int later = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            if(cache.containsKey(i)){
                res = cache.get(i);
                continue;
            }
            res = former + later;
            cache.put(3,res);
            later = former;
            former =res;
        }
        return res;
    }

}
