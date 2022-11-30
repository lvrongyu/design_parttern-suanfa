package com.at.statestreet.a221123;

import java.util.*;

public class ArrayTest {

    /**
     *
     * 一维数组寻址公式：
     *
     * a[i]_address = base_address + i * type_size
     *
     * 二维数组寻址公式:
     *
     * a[i][j]_address(n * m) = base_address + (i * m + j) * type_size
     *
     *
     *
     */

    /**
     * 基于数组 实现LRU
     * 1 如果数据已存在，放在数组头部,其他元素右移
     * 2 如果不存在：
     * 如果数组已满，放在数组头部,其他元素右移
     * 如果数组未满，则放到数组尾部
     */

    public static void main(String[] args) {
        ArrayLru arrayLru = new ArrayLru();
        arrayLru.fetchValue("123456+aaa");
        arrayLru.fetchValue("123456+aaa");
        arrayLru.fetchValue("123456+bbb");
        arrayLru.fetchValue("123456+bbb");
        arrayLru.fetchValue("123456+ccc");
        arrayLru.fetchValue("123456+ccc");
        arrayLru.fetchValue("123456+ddd");
        arrayLru.fetchValue("123456+ddd");
        arrayLru.fetchValue("123456+aaa");

        System.out.println(arrayLru.toString());
    }
}
    class ArrayLru{
        int currentIndex = 0;
        Map<String,Integer> valueIndexMap = new HashMap<>();
        int size = 3;
        String[] elementData = new String[3];

        public String fetchValue(String element){
            Integer elementIndex = valueIndexMap.get(element);
            if(elementIndex != null){
                //存在这个元素，放在头部，其他元素右移动
                move(elementIndex-1);
                elementData[0] = element;
                valueIndexMap.put(element,0);
            }else{
                if(currentIndex >= size-1){
                    valueIndexMap.remove(elementData[currentIndex--]);
                    move(currentIndex);
                    elementData[0] = element;
                    valueIndexMap.put(element,0);
                    currentIndex++;
                }else{
                   move(currentIndex);
                    elementData[0] = element;
                    valueIndexMap.put(element,0);
                    currentIndex++;
                }
            }
            return element;
        }

        public void move( int end){
            for(int i = end ; i >= 0; i--){
                elementData[i+1] = elementData[i];
                valueIndexMap.put(elementData[i+1],i+1);
            }
        }

        @Override
        public String toString() {
            return "ArrayLru{" +
                    "elementData=" + Arrays.toString(elementData) +
                    '}';
        }
    }
