package avl.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTest extends BaseTest{
    @Test
    public void shouldCreateNode() {
        Node node = new Node(1, 12, null);

        int h = node.h;
        int balance = node.balance;
        int key = node.key;
        int value = node.value;
        Node left = node.left;
        Node right = node.right;
        Node father = node.father;

        assertEquals(h, 1);
        assertEquals(balance, 0);
        assertEquals(key, 1);
        assertEquals(value, 12);
        assertNull(left);
        assertNull(right);
        assertNull(father);
    }

    @Test
    public void shouldGetHeightAvl() {
        AvlImpl avl = new AvlImpl();

        Node node1 = new Node(1, 1, null);
        Node node2 = new Node(2, 21, null);

        assertEquals(avl.height(node1, node2), 1);

        node1.h = 2;
        assertEquals(avl.height(node1, node2), 2);

        assertEquals(avl.height(null, null), 0);

        assertEquals(avl.height(node1, null), 2);

        assertEquals(avl.height(null, node2), 1);
    }

    @Test
    public void shouldBalanceAvl() {
        AvlImpl avl = new AvlImpl();
        Node node1 = new Node(1, 1, null);
        Node node2 = new Node(2, 2, null);

        assertEquals(avl.balance(node1, node2), 0);

        node1.h = 12;

        assertEquals(avl.balance(node1, node2), 11);
        assertEquals(avl.balance(null, null), 0);
        assertEquals(avl.balance(node1, null), 12);
        assertEquals(avl.balance(null, node2), -1);
    }

    @Test
    public void shouldWorkingTempAdd() {
        Node root = tempAdd(null, 2, 2, null);
        assertNotNull(root);

        root = tempAdd(root, 3, 3, null);
        assertEquals(root.right.key, 3);

        root = tempAdd(root, 1, 1, null);
        assertEquals(root.left.key, 1);

        root = tempAdd(root, 1, 1, null);
        assertEquals(root.left.key, 1);

        root = tempAdd(root, 0, 0, null);
        assertEquals(root.left.left.key, 0);
    }

    @Test
    public void shouldRightRotationAvl() {
        AvlImpl avl = new AvlImpl();

        Node root = tempAdd(null, 3, 3, null);
        root = tempAdd(root, 2, 2, null);
        root = tempAdd(root, 1, 1, null);

        root = avl.rightRotation(root);

        assertEquals(root.key, 2);
        assertEquals(root.left.key, 1);
        assertEquals(root.right.key, 3);
    }

    @Test
    public void shouldLeftRotationAvl() {
        AvlImpl avl = new AvlImpl();

        Node root = tempAdd(null, 1, 1, null);
        root = tempAdd(root, 2, 2, null);
        root = tempAdd(root, 3, 3, null);

        root = avl.leftRotation(root);

        assertEquals(root.key, 2);
        assertEquals(root.left.key, 1);
        assertEquals(root.right.key, 3);
    }

    @Test
    public void shouldAddElement() {
        AvlImpl avl = new AvlImpl();
        avl.add(1, 1);
        avl.add(2, 2);
        avl.add(3, 3);
        avl.add(4, 4);
        avl.add(5, 5);
        avl.add(6, 6);
        avl.add(7, 7);

        Node node = avl.root;
        assertEquals(node.key, 4);

        Node leftRoot = node.left;
        assertEquals(leftRoot.key, 2);
        assertEquals(leftRoot.left.key, 1);
        assertEquals(leftRoot.right.key, 3);

        Node rightRoot = node.right;
        assertEquals(rightRoot.key, 6);
        assertEquals(rightRoot.left.key, 5);
        assertEquals(rightRoot.right.key, 7);
    }

}
