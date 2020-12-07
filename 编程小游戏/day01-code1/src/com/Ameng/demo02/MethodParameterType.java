package com.Ameng.demo02;

/**
 * @program: Java-Basic
 * @description: 方法的参数类型区别
 * 方法的参数为基本类型时,传递的是数据值. 方法的参数为引用类型时,传递的是地址值.
 * @author: Ameng
 * @create: 2020-11-05
 **/
public class MethodParameterType {

  /*  public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a);
        System.out.println(b);
        change(a, b);  //没有发生改变
        System.out.println(a);
        System.out.println(b);
    }

    public static void change(int a, int b) {
        a = a + b;
        b = b + a;
    }*/

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(arr[0]);
        change(arr);  //传递回来数组的地址
        System.out.println(arr[0]);
    }

    public static void change(int[] arr) {
        arr[0] = 200;
    }
}
