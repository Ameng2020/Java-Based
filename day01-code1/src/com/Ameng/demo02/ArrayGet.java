package com.Ameng.demo02;

/**
 * @program: Java-Basic
 * @description: 数组作为方法的返回值，返回的是数组的内存地址
 * @author: Ameng
 * @create: 2020-11-05
 **/
public class ArrayGet {
    public static void main(String[] args) {
        //调用方法，接收数组的返回值
        // 接收到的是数组的内存地址
        int[] arr = getArray();
        System.out.println(arr);  //结果为[I@1b6d3586
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    /*
     *创建方法，
     * 返回值是数组类型 return返回数组的地址
     * */

    public static int[] getArray() {
        int[] arr = {1, 3, 5, 7, 9};
        //返回数组的地址，返回到调用者
        return arr;
    }

}
