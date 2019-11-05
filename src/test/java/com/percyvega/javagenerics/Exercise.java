package com.percyvega.javagenerics;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    public static void main(String[] args) {

        List<Number> list = new ArrayList<>();
        list.add(100);
        list.add(10.5);
        List rawList = list;            //1
        rawList.add("BasicsStrong");    //2
        list = rawList;                 //3

        for (Number element : list)
            System.out.println(element);    //4
    }

}
