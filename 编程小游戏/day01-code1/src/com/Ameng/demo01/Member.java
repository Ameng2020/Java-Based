package com.Ameng.demo01;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {

    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list){
        //从多个红包中随机抽取一个给我自己，
        //随机获取一个集合当中的索引编号
        int index = new Random().nextInt(list.size());
//        System.out.println(index); 可能存在随机数同时取得最大红包数？？
        //根据索引，从集合当中删除，并且得到被删除的红包，给我自己
        int delta = list.remove(index);
        //成员自己本来的钱
        int money = super.getMoney();
        //加法重新设置回去
        super.setMoney(money + delta);
    }
}
