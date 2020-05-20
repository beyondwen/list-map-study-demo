package com.wenhao.liststudydemo.v1arraylist;

import com.wenhao.liststudydemo.OprahList;

import java.util.Arrays;

public class OprahArrayList implements OprahList {

    // list 底层 使用数组来实现
    transient Object[] elementData;

    // 初始化数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //list的大小
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 构造函数初始化list 底层为 数组 并设置 默认值
     */
    public OprahArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        //检查所传下标 是否超出数组原有范围
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public boolean add(Object o) {
        ensureCapacityInternal(size + 1);
        // 赋值操作
        elementData[size++] = o;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 计算容量
     *
     * @param elementData 数组
     * @param minCapacity 最小容量
     * @return 容量
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        //判断 数组 是否等于默认值
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            //返回 数组 默认大小
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    /**
     * 根据返回的最小容量值 进行判断是否需要扩容
     *
     * @param minCapacity 最小容量值
     */
    private void ensureExplicitCapacity(int minCapacity) {
        //如果 minCapacity 大于数组的可使用长度时 此时需要进行扩容
        if (minCapacity - elementData.length > 0)
            //扩容操作
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        //原有容量值 设置为 可使用容量值
        int oldCapacity = elementData.length;
        // 新的容量值 为 原有 容量值 加 扩容容量值
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果新的容量值 小于 现在的容量值 就把现在的容量值 设置给新的容量值
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //数组拷贝 设置 为 新的容量值
        elementData = Arrays.copyOf(elementData, newCapacity);
        System.out.println("length 长度为：" + elementData.length);
    }

    /**
     * 范围检查
     *
     * @param index 索引
     */
    private void rangeCheck(int index) {
        // 当索引超出 数组范围时 抛出异常
        if (index >= size)
            throw new IndexOutOfBoundsException("数组越界");
    }
}
