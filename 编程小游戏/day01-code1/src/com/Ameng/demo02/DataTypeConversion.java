package com.Ameng.demo02;

public class DataTypeConversion {


    public static void datatype(){
        /**
         * 当数据类型不一样时，会发生数据类型的转换
         *

         * 自动类型转换（隐式）
         * 	1. 特点：代码不需要进行特殊处理，自动完成。
         * 	2. 规则：数据范围从小到大（与类型字节数不一定相关）
         *
         *
         */
        System.out.println(1024);//默认是int
        System.out.println(3.14);  //默认是double类型

        // 左边是long,右边是int类型，会发生自动转换
        long num1 = 100;
        System.out.println(num1); //100

        // 左边是double类型，右边是float类型，左右不一样
        // float --> double，符合从小到大的规则
        // 也发生了自动类型转换
        double num2 = 2.5F;
        System.out.println(num2); // 2.5

        // 左边是float类型，右边是long类型，左右不一样
        // long --> float，范围是float更大一些，符合从小到大的规则
        // 也发生了自动类型转换
        float num3 = 30L;
        System.out.println(num3); // 30.0
    }
    public static void demo02(){
        /**
         * 强制类型转换(显示)
         *
         *  	1. 特点：代码需要进行特殊的格式处理，不能自动完成。
         *      2. 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
         *
         * 注意事项：
         * 	1. 强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出。
         * 	2. byte/short/char这三种类型都可以发生数学运算，例如加法“+”.
         * 	3. byte/short/char这三种类型在运算的时候，都会被首先提升成为int类型，然后再计算。
         * 	4. boolean类型不能发生数据类型转换
         */
        // 左边是int类型，右边是long类型，不一样
        // long --> int，不是从小到大
        // 不能发生自动类型转换！
        // 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
        int num = (int) 100L;
        System.out.println(num);

        //int num2 = 60000000000; //输出会发生报错，值超出int范围

        // long强制转换成为int类型
        int num2 = (int) 6000000000L;   //int只能表示1705032704，而6000000000大于int能表示的范围就会出现数据溢出。
        System.out.println(num2); // 结果为1705032704

        // double --> int，强制类型转换
        int num3 = (int) 3.99;
        System.out.println(num3); // 3，这并不是四舍五入，所有的小数位都会被舍弃掉

        char zifu1 = 'A'; // 这是一个字符型变量，里面是大写字母A
        System.out.println(zifu1 + 1); // 66，也就是大写字母A被当做65进行处理
        // 计算机的底层会用一个数字（二进制）来代表字符A，就是65
        // 一旦char类型进行了数学运算，那么字符就会按照一定的规则翻译成为一个数字

        byte num4 = 40; // 注意！右侧的数值大小不能超过左侧的类型范围
        byte num5 = 50;
        // byte + byte --> int + int --> int  byte运算会提升为int,所以结果要是int类型
        int result1 = num4 + num5;
        System.out.println(result1); // 90

        short num6 = 60;
        // byte + short --> int + int --> int
        // int强制转换为short：注意必须保证逻辑上真实大小本来就没有超过short范围，否则会发生数据溢出
        short result2 = (short) (num4 + num6);
        System.out.println(result2); // 100
    }

}
