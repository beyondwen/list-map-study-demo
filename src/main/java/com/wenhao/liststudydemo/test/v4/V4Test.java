package com.wenhao.liststudydemo.test.v4;

import com.wenhao.liststudydemo.OprahList;
import com.wenhao.liststudydemo.v4linkedlist.OprahLinkedList;

public class V4Test {

    public static void main(String[] args) {
        OprahList<Object> objects = new OprahLinkedList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(i);
        }
        System.out.println(objects.size());
        System.out.println(objects.get(51));
    }
}
