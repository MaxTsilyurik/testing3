package avl.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTest {

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
    public void shouldGetHeightAVL() {
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
    public void shouldBalanceAVL() {
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
        AvlImpl avl = new AvlImpl();

        Node root = avl.tempAdd(null, 2, 2, null);
        assertNotNull(root);

        root = avl.tempAdd(root, 3, 3, null);
        assertEquals(root.right.key, 3);

        root = avl.tempAdd(root, 1, 1, null);
        assertEquals(root.left.key, 1);

        root = avl.tempAdd(root, 1, 1, null);
        assertEquals(root.left.key, 1);

        root = avl.tempAdd(root, 0, 0, null);
        assertEquals(root.left.left.key, 0);
    }


}
