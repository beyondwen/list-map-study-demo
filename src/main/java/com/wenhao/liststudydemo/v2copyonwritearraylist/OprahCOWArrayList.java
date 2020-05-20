package com.wenhao.liststudydemo.v2copyonwritearraylist;

import com.wenhao.liststudydemo.OprahList;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class OprahCOWArrayList implements OprahList {

    private transient volatile Object[] array;

    final transient ReentrantLock lock = new ReentrantLock();

    final void setArray(Object[] a) {
        array = a;
    }

    final Object[] getArray() {
        return array;
    }

    /**
     * 构造函数 初始化数组 为空
     */
    public OprahCOWArrayList() {
        setArray(new Object[0]);
    }

    @Override
    public int size() {
        //获取数组的长度
        return getArray().length;
    }

    @Override
    public Object get(int index) {
        //判断数组 并放回结果
        int length = getArray().length;
        if (index >= length) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        Object[] array = getArray();
        return array[index];
    }

    @Override
    public boolean add(Object e) {
        //获取锁
        final ReentrantLock lock = this.lock;
        //加锁
        lock.lock();
        try {
            //获取数组
            Object[] elements = getArray();
            //获取数组长度
            int len = elements.length;
            //获取一个新的数组
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            // 将待添加的元素 设置到新的数组中
            newElements[len] = e;
            // 替换原有数组
            setArray(newElements);
        } finally {
            // 释放锁
            lock.unlock();
        }
        return true;
    }
}
