package com.wenhao.liststudydemo.test.v2;

import com.wenhao.liststudydemo.OprahList;
import com.wenhao.liststudydemo.v2copyonwritearraylist.OprahCOWArrayList;

public class V2Test {

    public static void main(String[] args) {

        OprahList list = new OprahCOWArrayList();
        list.add("1233");
        list.add("1234");
        list.add("1235");
        list.add("1236");
        list.add("1237");

        System.out.println(list.get(5));

    }
}
