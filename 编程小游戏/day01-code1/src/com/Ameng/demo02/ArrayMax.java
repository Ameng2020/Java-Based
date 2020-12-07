package com.Ameng.demo02;


/**
 * 遍历获取数组最大值
 */
public class ArrayMax {
    /**
     * Main
     *
     * @param args args
     */
    public static void main(String[] args) {
        System.out.println("数组最大值是： " + getMax());

    }

    /**
     * Gets max *
     *
     * @return the max
     */
    public static int getMax() {
        int[] arr = {5, 16, 23, 100, 300, 700, 40, 400};
        //定义变量，保存数组中0索引的元素
        int max = arr[0];
        //遍历数组，取出每个元素
        for (int i = 0; i < arr.length; i++) {
           //遍历到的元素和变量max比较
            //如果数组元素大于max
            if (arr[i] > max) {
                //记录max为最大值
                max = arr[i];
            }
            
        }
        return max;
                
    }
}
