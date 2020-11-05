package com.Ameng.demo01;

import java.util.ArrayList;

/**
 * extends继承父类User
 */
public class Manager extends User{
    public Manager(){

    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney,int count){
        //需要一个集合，用来存放若干个红包的金额
        ArrayList<Integer> redlist = new ArrayList<>();

        int leftMoney = super.getMoney();  //群主的当前金额
        if (totalMoney > leftMoney) {
            System.out.println("余额不足" );
            return redlist;
        }

        //扣钱，就是重新设置余额
        super.setMoney(leftMoney - totalMoney);

        //发红包需要平均拆分成count份
        int avg = totalMoney / count;
        int mod = totalMoney % count;   //余数

        //把余数放入最后一个红包中
        for (int i = 0; i < count - 1; i++) {
            redlist.add(avg);

        }
        int last = avg + mod;
        redlist.add(last);

        return redlist;
    }
}
