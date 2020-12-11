package avl.impl;

public class BaseTest {

    public Node tempAdd(Node node, Integer key, Integer value, Node father) {
        AvlImpl avl = new AvlImpl();
        if (node == null) {
            return new Node(key, value, father);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = tempAdd(node.right, key, value, node);
            node.h = avl.height(node.left, node.right) + 1;
        } else {
            if (compareResult < 0) {
                node.left = tempAdd(node.left, key, value, node);
                node.h = avl.height(node.left, node.right) + 1;
            } else {
                node.value = value;
            }
        }
        return node;
    }

}
