package playground.problem.algorithm.graph;

import java.util.*;

class Node {
    String name;
    List<Node> links;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }

    void link(Node node) {
        this.links.add(node);
    }

    void visit() {
        this.visited = true;
    }

    boolean isNotVisited() {
        return !this.visited;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
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

        a.link(b);
        a.link(c);
        b.link(a);
        b.link(c);
        c.link(b);
        c.link(d);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        Node target = e;

        // DFS
        System.out.println("Start DFS!");
        Stack<Node> stack = new Stack<>();
        stack.push(a);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.visit();

            System.out.println(node);

            if (node == target) {
                System.out.println("Found Target! " + node);
                break;
            }

            node.links.stream()
                    .filter(n -> n.isNotVisited() && !stack.contains(n))
                    .forEach(stack::push);
            System.out.println(stack);
            System.out.println();
        }

        // BFS
        System.out.println();
        System.out.println("Start BFS!");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.visit();

            System.out.println(node);

            if (node == target) {
                //find!!
                System.out.println("found target: " + node);
                break;
            }

            node.links.stream()
                    .filter(n -> !queue.contains(n) && n.isNotVisited())
                    .forEach(queue::offer);
        }
    }
}
