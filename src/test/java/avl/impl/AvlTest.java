package avl.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
}
