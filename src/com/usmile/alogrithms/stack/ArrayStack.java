package com.usmile.alogrithms.stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private final Object[] data;

    private int size;

    private final int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    @Override
    public int getSize() {
        return data.length;
    }

    @Override
    public void push(E elem) {
        if (size == capacity) {
            throw new IllegalArgumentException("Stack is full !");
        }

        data[size] = elem;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (0 == size) {
            throw new NoSuchElementException("Stack is Empty");
        }
        E elem = (E) data[size - 1];
        size--;

        return elem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (0 == size) {
            throw new NoSuchElementException("Stack is Empty");
        }

        return (E) data[size - 1];
    }
}
