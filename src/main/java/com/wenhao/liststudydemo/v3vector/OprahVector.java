package com.wenhao.liststudydemo.v3vector;

import com.wenhao.liststudydemo.OprahList;

import java.util.Arrays;

public class OprahVector implements OprahList {


    //数组
    protected Object[] elementData;

    // 需要扩充的数值
    protected int capacityIncrement;

    // 数组长度
    protected int elementCount;

    //构造函数 初始化
    public OprahVector() {
        //传入 初始容量
        this(10);
    }

    //设置初始容量
    public OprahVector(int initialCapacity) {
        //初始容量 和 容量扩充数
        this(initialCapacity, 0);
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public synchronized Object get(int index) {
        if (index > elementData.length) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        return elementData[index];
    }

    @Override
    public synchronized boolean add(Object e) {
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = e;
        return true;
    }

    private void ensureCapacityHelper(int minCapacity) {
        System.out.println(elementData.length);
        System.out.println(elementData);
        //如果最小容量 大于 数组长度 便进行扩容
        if (minCapacity - elementData.length > 0)
            // 扩容操作
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        //原有容量 等于数组长度
        int oldCapacity = elementData.length;
        // 如果 扩展容量大于0 就取扩展容量  否则取oldCapacity
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                capacityIncrement : oldCapacity);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 进行具体初始化操作
     *
     * @param initialCapacity   初始容量
     * @param capacityIncrement 需要扩充的容量值
     */
    public OprahVector(int initialCapacity, int capacityIncrement) {
        //初始容量 小于0 抛出非法参数异常
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        //为初始 数组 设置容量
        this.elementData = new Object[initialCapacity];
        // 设置 需要扩充的数量
        this.capacityIncrement = capacityIncrement;
    }
}
