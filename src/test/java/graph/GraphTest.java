// Capitalised package names do not get detected by the IntelliJ JVM
package graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class GraphTest {

    @Test
    public void shouldBfsGraph() {
        Graph graph = createGraph();

        Node searchNode = graph.searchNode(5);

        assertEquals(5, searchNode.value);
    }

    @Test
    public void shouldDfsGraph() {
        Graph graph = createGraph();

        Node searchNode = graph.searchNodeDfs(5);

        assertEquals(5, searchNode.value);
    }
    @Test
    public void getNthNearestNeighbours() {
        Graph graph = createGraph();

        List<Node> nthNeighbours = graph.findNthNeighbours(3);

        assertEquals(3, nthNeighbours.size());
    }

    private Graph createGraph() {
        Node root = new Node(1);
        Graph graph = new Graph(root);

        Node rootNodeNeighbour11 = new Node(2);
        rootNodeNeighbour11.neighbours.add(root);
        root.neighbours.add(rootNodeNeighbour11);

        Node rootNodeNeighbour12 = new Node(3);
        rootNodeNeighbour12.neighbours.add(root);
        root.neighbours.add(rootNodeNeighbour12);

        Node rootNodeNeighbour13 = new Node(4);
        rootNodeNeighbour13.neighbours.add(root);
        root.neighbours.add(rootNodeNeighbour13);

        Node rootNodeNeighbour21 = new Node(5);
        rootNodeNeighbour21.neighbours.add(rootNodeNeighbour11);
        rootNodeNeighbour11.neighbours.add(rootNodeNeighbour21);

        Node rootNodeNeighbour22 = new Node(6);
        rootNodeNeighbour22.neighbours.add(rootNodeNeighbour12);
        rootNodeNeighbour12.neighbours.add(rootNodeNeighbour22);

        Node rootNodeNeighbour23 = new Node(7);
        rootNodeNeighbour23.neighbours.add(rootNodeNeighbour12);
        rootNodeNeighbour12.neighbours.add(rootNodeNeighbour23);

        Node rootNodeNeighbour31 = new Node(8);
        rootNodeNeighbour31.neighbours.add(rootNodeNeighbour21);
        rootNodeNeighbour21.neighbours.add(rootNodeNeighbour31);

        Node rootNodeNeighbour32 = new Node(9);
        rootNodeNeighbour32.neighbours.add(rootNodeNeighbour22);
        rootNodeNeighbour22.neighbours.add(rootNodeNeighbour32);

        Node rootNodeNeighbour33 = new Node(10);
        rootNodeNeighbour33.neighbours.add(rootNodeNeighbour22);
        rootNodeNeighbour22.neighbours.add(rootNodeNeighbour33);

        return graph;
    }
}
