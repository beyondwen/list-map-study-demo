package com.wenhao.liststudydemo.test.v1;

import com.wenhao.liststudydemo.OprahList;
import com.wenhao.liststudydemo.v1arraylist.OprahArrayList;

public class V1Test {

    public static void main(String[] args) {
        OprahList<String> strings = new OprahArrayList();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
        strings.add("10");
        strings.add("11");
        strings.add("12");

        System.out.println(strings.get(1));





    }
}
