package graph;

import java.util.*;

public class Graph {
    private Node root;

    Graph(Node root) {
        this.root = root;
    }

    Node searchNode(int valueToSearchFor) {
        if (root == null)
            return null;

        Node currentNode = root;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            visited.add(node);

            if (node.value == valueToSearchFor)
                return node;
            else
                node.neighbours.forEach(neighbour -> {
                    if (!visited.contains(neighbour))
                        queue.add(neighbour);
                });
        }

        return null;
    }

    Node searchNodeDfs(int valueToSearchFor) {
        if (root == null)
            return null;

        Node currentNode = root;
        Set<Node> visited = new HashSet<>();
        Deque<Node> stack = new LinkedList<>();
        stack.add(currentNode);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            visited.add(node);

            if (node.value == valueToSearchFor)
                return node;
            else
                node.neighbours.forEach(neighbour -> {
                    if (!visited.contains(neighbour))
                        stack.add(neighbour);
                });
        }

        return null;
    }

    public List<Node> findNthNeighbours(int depth) {
        List<Node> depthNNeighbours = new ArrayList<>();

        if (root == null)
            return null;

        Node currentNode = root;
        Set<Node> visited = new HashSet<>();
        Deque<NodeWithDepth<Node, Integer>> stack = new LinkedList<>();
        stack.add(new NodeWithDepth<>(currentNode, 0));

        while (!stack.isEmpty()) {
            NodeWithDepth<Node, Integer> nodeWithDepth = stack.pop();
            Node node = nodeWithDepth.node;
            int currentDepth = nodeWithDepth.depth;

            if (currentDepth > depth)
                continue;

            visited.add(node);

            if (currentDepth == depth) {
                depthNNeighbours.add(node);
            } else
                node.neighbours.forEach(neighbour -> {
                    if (!visited.contains(neighbour))
                        stack.add(new NodeWithDepth<>(neighbour, currentDepth + 1));
                });
        }

        return depthNNeighbours;
    }
}

class Node {
    int value;
    List<Node> neighbours;

    public Node(int i) {
        value = i;
        neighbours = new ArrayList<>();
    }
}

class NodeWithDepth<K, V> {
    K node;
    V depth;

    public NodeWithDepth(K node, V depth) {
        this.node = node;
        this.depth = depth;
    }
}
