package com.Ameng.demo01;

import java.util.ArrayList;
import java.util.Map;

public class MainRedPacket {

    public static void main(String[] args) {
        Manager manager = new Manager("群主", 200);

        Member one = new Member("A", 0);
        Member two = new Member("B", 0);
        Member three = new Member("C", 0);

        one.show();
        two.show();
        three.show();
        manager.show();

        System.out.println("============");

        //发红包
        ArrayList<Integer> redlist = manager.send(100, 3);
        //收红包
        one.receive(redlist);
        two.receive(redlist);
        three.receive(redlist);

        one.show();
        two.show();
        three.show();
        manager.show();


    }
}
