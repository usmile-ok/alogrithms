package com.usmile.alogrithms.learn.queue;

public class ArrayQueue<E> {
    private Object[] data;

    private int headIndex;

    private int tailIndex;

    private int size;

    public boolean isEmpty() {
        // return size == 0
        return headIndex == tailIndex;
    }

    public void enqueue(E e) {
        // 判断队列是否已满
        if ((tailIndex + 1) % data.length == headIndex) {
            this.resize(getCapacity() * 2);
        }


    }

    public int getCapacity() {
        // 预留一位用于判断队列是否已满
        // (tailIndex + 1) % data.length == headIndex
        return data.length - 1;
    }

    private void resize(int capacity) {
        Object[] newData = new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + headIndex) % data.length];
        }
        headIndex = 0;
        tailIndex = size;
        data = newData;
    }
}
