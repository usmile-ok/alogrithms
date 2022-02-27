package com.usmile.alogrithms.learn.bt;

@SuppressWarnings("all")
public class BSTreeR<T extends Comparable<T>> {
    private Node<T> root;

    private int size;

    public BSTreeR() {
        this.root = null;
        this.size = 0;
    }

    private static class Node<T> {
        T data;

        Node<T> left;

        Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 插入
     * 不平衡
     */
    public void add(T data) {
        if (null == this.root) {
            this.root = new Node<>(data);
        }
        Node<T> current = this.root;

        while (true) {
            if (data.compareTo(current.data) == 0) {
                return;
            } else if (data.compareTo(current.data) < 0) {
                if (null == current.left) {
                    current.left = new Node<>(data);
                    size++;

                    return;
                } else {
                    current = current.left;
                }
            } else {
                if (null == current.right) {
                    current.right = new Node<>(data);
                    size++;

                    return;
                } else {
                    current = current.right;
                }
            }
        }
    }

    /**
     * 查询操作
     */
    public boolean contains(T target) {
        if (null == this.root) {
            return false;
        }

        Node<T> current = root;

        while (null != current) {
            if (target.compareTo(current.data) == 0) {
                return true;
            } else if (target.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // 删除最小值
    public T removeMin() {
        if (null == root) {
            throw new RuntimeException("Tree is null");
        }

        Node<T> min = root;
        Node<T> parent = null;
        while (null != min.left) {
            parent = min;
            min = min.left;
        }
        if (null == parent) { // 删除头节点
            this.root = this.root.right;
        } else {
            parent.left = min.right;
            min.right = null;
        }
        size--;

        return min.data;
    }

    // 删除最大值
    public T removeMax() {
        if (null == root) {
            throw new RuntimeException("Tree is null");
        }

        Node<T> max = root;
        Node<T> parent = null;
        while (null != max.right) {
            parent = max;
            max = max.right;
        }
        if (null == parent) { // 删除头节点
            this.root = this.root.left;
        } else {
            parent.right = max.left;
            max.left = null;
        }
        size--;

        return max.data;
    }

    // 删除任意节点
    public void remove(T elem) {
        if (null == root) {
            return;
        }

        Node<T> curr = root;
        Node<T> parent = null;
        while (null != curr && (elem.compareTo(curr.data) != 0)) {
            parent = curr;
            if (elem.compareTo(curr.data) < 0) {
                curr = curr.left;
            }
            if (elem.compareTo(curr.data) > 0) {
                curr = curr.right;
            }
        }

        if (null == curr) { // 没有需要删除的节点
            return;
        }

        if (null == parent) { // 删除节点为根节点

        }

        if (null == curr.left && null == curr.right) { // 删除节点为叶子节点
            if (null == parent) {
                this.root = null;
            } else if (curr == parent.left) {
                parent.left = null;
            } else if (curr == parent.right) {
                parent.right = null;
            }
        } else if (null != curr.left && null == curr.right) { // 删除节点只包含左子树
            if (null == parent) {
                this.root = this.root.left;
            } else if (curr == parent.left) {
                parent.left = curr.left;
                curr.left = null;
            } else if (curr == parent.right) {
                parent.right = curr.left;
                curr.left = null;
            }
        } else if (null == curr.left && null != curr.right) { // 删除节点包只含右子树
            if (null == parent) {
                this.root = this.root.right;
            } else if (curr == parent.left) {
                parent.left = curr.right;
                curr.right = null;
            } else if (curr == parent.right) {
                parent.right = curr.right;
                curr.right = null;
            }
        } else if (null != curr.left && curr != curr.right) { // 删除节点包含左右子树
            Node<T> min = curr.right;
            Node<T> minParent = curr;
            while (null != min.left) {
                minParent = min;
                min = min.left;
            }

            curr.data = min.data;
            minParent.left = null;
        }
    }
}
