package binarytree;

import com.sun.tools.javac.util.ArrayUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

@RunWith(JUnit4.class)
public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @Before
    public void setUp() {
//        this.binaryTree = new BinaryTree();
    }

    @Test
    public void shouldCreateBinaryTree() {
        final char[] x = Arrays.asList("asd".toCharArray()).stream().findFirst().get();
        System.out.println(x);
        System.out.println(Arrays.asList(new int[]{1, 2, 33, 4}).stream().findFirst().get());
        "str".chars().mapToObj(c -> (char) c).toArray(Character[]::new);
//        System.out.println("asd".chars.stream().findFirst().get());

        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.size();
    }
}