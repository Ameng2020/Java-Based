package com.Ameng.demo02;

public class Sum100 {
    public static void main(String[] args) {
        System.out.println(getSum());
        printHelloWorld(9);
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;

        }
        return sum;
    }

    /*定义打印HelloWorld方法 返回值类型，计算没有结果 void 参数：不确定打印几次 */
    public static void printHelloWorld(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("HelloWorld");
        }
    }
}
