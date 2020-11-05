package com.Ameng.demo02;

/**
 * @program: Java-Basic
 * @description: 数组翻转
 * @author: Ameng
 * @create: 2020-11-05
 **/
public class ArrayFlip {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayFlip(arr);
    }
/*
* 数组作为方法参数传递，传递的参数是数组内存的地址。
* */
    public static void arrayFlip(int[] arr) {
        /*循环中定义变量min=0最小索引
         max=arr.length‐1最大索引
          min++,max‐‐
          */
        for (int min = 0, max = arr.length - 1; min <= max; min++, max--) {
            //利用第三方变量完成数组中的元素交换
            int temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
        // 反转后，遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
