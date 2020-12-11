package avl.impl;

import avl.Avl;

public class AvlImpl implements Avl {

    public int height(Node x, Node y) {
        if (x == null && y == null) return 0;
        else if (x == null) return y.h;
        else if (y == null) return x.h;
        else return Math.max(x.h, y.h);
    }
}
