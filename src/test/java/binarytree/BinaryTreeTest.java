package binarytree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @Test
    public void shouldCreateBinaryTree() {
        this.binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);

        Node node = binaryTree.search(3);

        assertEquals(3, node.value);
    }

    @Test
    public void inOrderTraversal() {
        this.binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(10);
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);

        binaryTree.inOrderTraversal();
    }

    @Test
    public void preOrderTraversal() {
        this.binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(10);
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);

        binaryTree.preOrderTraversal();
    }


}
