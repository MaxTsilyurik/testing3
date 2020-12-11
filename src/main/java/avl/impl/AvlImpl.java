package avl.impl;

import avl.Avl;

public class AvlImpl implements Avl {
    public Node root;

    public int height(Node x, Node y) {
        if (x == null && y == null) return 0;
        else if (x == null) return y.h;
        else if (y == null) return x.h;
        else return Math.max(x.h, y.h);
    }

    public int balance(Node x, Node y) {
        if (x == null && y == null) return 0;
        else if (x == null) return -y.h;
        else if (y == null) return x.h;
        else return x.h - y.h;
    }

    public Node tempAdd(Node node, Integer key, Integer value, Node father) {
        if (node == null) {
            return new Node(key, value, father);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = tempAdd(node.right, key, value, node);
            node.h = height(node.left, node.right) + 1;
        } else {
            if (compareResult < 0) {
                node.left = tempAdd(node.left, key, value, node);
                node.h = height(node.left, node.right) + 1;
            } else {
                node.value = value;
            }
        }
        return node;
    }
}
