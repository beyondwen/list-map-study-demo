package com.wenhao.liststudydemo.v4linkedlist;

import com.wenhao.liststudydemo.OprahList;

public class OprahLinkedList<E> implements OprahList<E> {

    transient OprahLinkedList.Node<E> last;

    transient OprahLinkedList.Node<E> first;

    transient int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    OprahLinkedList.Node<E> node(int index) {
        // 通过二分查找法进行查询 如果 index 小于 链表长度的一半的数值 则从 first 节点 往last节点遍历
        if (index < (size >> 1)) {
            OprahLinkedList.Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            //如果 index 大于 链表长度的一半的数值 则从 last 节点往 first 节点方向遍历
            OprahLinkedList.Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    void linkLast(E e) {
        //获取链表中最后的节点 并将其置为临时变量
        final OprahLinkedList.Node<E> l = last;
        /*if (l!=null){
            System.out.println("l////节点信息：" +
                    "" + "上一节点为" + l.prev + "》》》元素为" + l.item
                    + "》》》下一节点为" + l.next);
        }*/
        //添加新元素进入链表中 传入 链表的最后一个节点 作为该节点中的上一节点 下一节点设置为空
        final OprahLinkedList.Node<E> newNode = new OprahLinkedList.Node<>(l, e, null);
        /*System.out.println("newNode////节点信息：" +
                "" + "上一节点为" + newNode.prev + "》》》元素为" + newNode.item
                + "》》》下一节点为" + newNode.next);*/
        //将 链表中的 最后一个节点设置为 newNode
        last = newNode;
        /*System.out.println("last////节点信息：" +
                "" + "上一节点为" + last.prev + "》》》元素为" + last.item
                + "》》》下一节点为" + last.next);*/
        // 临时变量 为空 说明 newNode 的上一节点 为空 当前newNode 为第一节点
        if (l == null) {
            // 设置链表中的第一个节点为 newNode
            first = newNode;
            /*System.out.println("first////节点信息：" +
                    "" + "上一节点为" + first.prev + "》》》元素为" + first.item
                    + "》》》下一节点为" + first.next);*/
        } else {
            //否则 给临时变量 设置 下一节点的 信息为  newNode
            l.next = newNode;
            /*System.out.println("l////节点信息：" +
                    "" + "上一节点为" + l.prev + "》》》元素为" + l.item
                    + "》》》下一节点为" + l.next);*/
        }
        size++;
    }

    private static class Node<E> {
        E item;
        OprahLinkedList.Node<E> next;
        OprahLinkedList.Node<E> prev;

        Node(OprahLinkedList.Node<E> prev, E element, OprahLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
