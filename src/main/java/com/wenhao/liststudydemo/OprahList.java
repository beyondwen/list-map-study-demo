package com.wenhao.liststudydemo;

public interface OprahList<E> {

    /**
     * list长度
     *
     * @return int
     */
    int size();

    /**
     * 获取list中的元素
     *
     * @param index 索引
     * @return 返回索引对应元素
     */
    E get(int index);

    /**
     * 添加元素
     *
     * @param e 元素
     * @return 布尔值 是否添加成功
     */
    boolean add(E e);
}
