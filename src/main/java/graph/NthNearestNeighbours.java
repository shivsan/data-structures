package graph;

import java.util.*;

public class NthNearestNeighbours {

}

class Graph {
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
}

class Node {
    int value;
    List<Node> neighbours;

    public Node(int i) {
        value = i;
        neighbours = new ArrayList<>();
    }
}
