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

    public Node leftRotation(Node node) {
        if (node.right.right == null && node.right.left != null) {
            node.right = rightRotation(node.right);
            node = leftRotation(node);
        } else {
            if (node.right.left == null || node.right.left.h <= node.right.right.h) {
                Node newNode = node.right;
                newNode.father = node.father;
                node.right = newNode.left;
                if (node.right != null)
                    node.right.father = node;
                node.h = height(node.left, node.right) + 1;
                node.father = newNode;
                node.balance = balance(node.left, node.right);
                newNode.left = node;
                node = newNode;
                node.balance = balance(node.left, node.right);
                node.h = height(node.left, node.right) + 1;
            } else {
                node.right = rightRotation(node.right);
                node = leftRotation(node);
            }
        }
        return node;
    }

    public Node rightRotation(Node node) {
        if (node.left.right != null && node.left.left == null) {
            node.left = leftRotation(node.left);
            node = rightRotation(node);
        } else {
            if (node.left.right == null || node.left.right.h <= node.left.left.h) {
                Node newNode = node.left;
                newNode.father = node.father;
                node.left = newNode.right;
                if (node.left != null)
                    node.left.father = node;
                node.h = height(node.left, node.right) + 1;
                node.father = newNode;
                node.balance = balance(node.left, node.right);
                newNode.right = node;
                node = newNode;
                node.balance = balance(node.left, node.right);
                node.h = height(node.left, node.right) + 1;
            } else {
                node.left = leftRotation(node.left);
                node = rightRotation(node);
            }
        }
        return node;
    }
}
