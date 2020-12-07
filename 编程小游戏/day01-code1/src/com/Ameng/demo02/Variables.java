package com.Ameng.demo02;

public class Variables {

    public static void main(String[] args) {
        variables();
    }
    /**
     * 变量：程序运行期间，内容可以发生改变的量。
     *
     * 创建一个变量并且使用的格式：
     *
     * 数据类型 变量名称; // 创建了一个变量
     * 变量名称 = 数据值; // 赋值，将右边的数据值，赋值交给左边的变量
     *
     * 一步到位的格式：
     *
     * 数据类型 变量名称 = 数据值; // 在创建一个变量的同时，立刻放入指定的数据值
     */

    public static void variables(){
        //定义字节型变量
        byte b = 100;
        System.out.println(b);
        //定义短整型变量
        short s =1000;
        System.out.println(s);
        //定义整型变量
        int i = 123456;
        System.out.println(i);
        //定义长整型变量
        long l = 123456789L;
        System.out.println(l);
        //定义单精度浮点型变量
        float f = 5.5F;
        System.out.println(f);
        //定义双精度浮点型变量
        double d = 8.5;
        System.out.println();
        //定义布尔型变量
        boolean bool = false;
        System.out.println(bool);
        //定义字符型常量
        char c = 'A';
        System.out.println(c);
    }

    /**
     * 使用变量的时候，有一些注意事项：
     *
     * 1. 如果创建多个变量，那么变量之间的名称不可以重复。
     * 2. 对于float和long类型来说，字母后缀F和L不要丢掉。
     * 3. 如果使用byte或者short类型的变量，那么右侧的数据值不能超过左侧类型的范围。
     * 4. 没有进行赋值的变量，不能直接使用；一定要赋值之后，才能使用。
     * 5. 变量使用不能超过作用域的范围。
     *    【作用域】：从定义变量的一行开始，一直到直接所属的大括号结束为止。
     * 6. 可以通过一个语句来创建多个变量，但是一般情况不推荐这么写。
     */
}
