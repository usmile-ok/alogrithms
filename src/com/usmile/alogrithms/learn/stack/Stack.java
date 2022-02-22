package com.usmile.alogrithms.learn.stack;

/**
 * 栈基本接口
 */
public  interface Stack<E> {
    int getSize();
    void push(E elem);
    E pop();
    E peek();
}
