package com.at.statestreet.a221123;

public class TimeComplexityAnalysis {
    /**
     * 时间复杂度为O(1),
     * 最坏时间复杂度O(N)
     * 最好时间复杂度O(1)
     * 均摊时间复杂度O(1)
     * 平均时间复杂度O(1)
     */
    // 全局变量，大小为 10 的数组 array，长度 len，下标 i。
    int array[] = new int[10];
    int len = 10;
    int i = 0;

    // 往数组中添加一个元素
    void add(int element) {
        if (i >= len) { // 数组空间不够了
            // 重新申请一个 2 倍大小的数组空间
            int new_array[] = new int[len*2];
            // 把原来 array 数组中的数据依次 copy 到 new_array
            for (int j = 0; j < len; ++j) {
                new_array[j] = array[j];
            }
            // new_array 复制给 array，array 现在大小就是 2 倍 len 了
            array = new_array;
            len = 2 * len;
        }
        // 将 element 放到下标为 i 的位置，下标 i 加一
        array[i] = element;
        ++i;
    }
}
