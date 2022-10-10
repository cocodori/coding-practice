package algorithm.graph2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class Connection {
    Node node;
    int weight;

    Connection(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Node {
    String name;
    List<Connection> links;
    boolean visited = false;

    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }

    void visit() {
        this.visited = true;
    }

    boolean isVisited() {
        return this.visited;
    }

    void link(Node node, int weight) {
        this.links.add(new Connection(node, weight));
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass() || o == null) return false;
        Node node = (Node) o;
        return Objects.equals(this.name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

}

public class Main {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(d, 2);
        b.link(a, 5);
        b.link(c, 6);
        b.link(e, 4);
        c.link(b, 6);
        d.link(c, 2);
        e.link(d, 3);

        // A에서 E를 찾아가는 탐색과 그 과정까지의 총 가중치(weight) 계산
        // BFS
        Node target = e;
        Queue<Connection> queue = new LinkedList<>();
        queue.offer(new Connection(a, 0));

        while (!queue.isEmpty()) {
            Connection con = queue.poll();
            Node n = con.node;
            int weight = con.weight;
            n.visit();
            System.out.println(n + " ("+weight+")");

            if (n.equals(target)) {
                System.out.println("FOUND!!");
                break;
            }

            n.links.stream()
                    .filter(i -> !i.node.isVisited())
                    .filter(i -> !queue.contains(i))
                    .map(i -> new Connection(i.node, i.weight + weight))
                    .forEach(queue::offer);
        }

    }

}
