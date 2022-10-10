package algorithm.graph3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Graph<String> graph = new Graph<>();
        graph.addNode(new Node<>("A"));
        graph.addNode(new Node<>("B"));
        graph.addNode(new Node<>("C"));
        graph.addNode(new Node<>("D"));
        graph.addNode(new Node<>("E"));

        int[][] matrix = {
                {0, 0, 0, 2, 0},
                {5, 0, 6, 0, 4},
                {0, 6, 0, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 0, 3, 0}
        };

        graph.generate(matrix);

        Node<String> a = graph.getNode(0);
        Node<String> target = graph.getNode(4);

        Connection<String> answer1 = graph.bfs(a, target);
        System.out.println(String.format("BFS: %s (%d)", answer1.getNode(), answer1.getWeight()));
        Connection<String> answer2 = graph.dfs(a, target);
        System.out.println(String.format("DFS: %s (%d)", answer2.getNode(), answer2.getWeight()));

    }
}

class Connection<T> {
    private Node<T> node;
    private int weight;

    public Connection(Node<T> node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public Node<T> getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }
}

class Node<T> {
    private T data;
    private List<Connection<T>> links;
    private boolean visited;

    public Node(T name) {
        this.data = name;
        this.links = new LinkedList<>();
    }

    public List<Connection<T>> getConnections() {
        return links;
    }

    public void link(Node<T> node, int weight) {
        links.add(new Connection<>(node, weight));
    }

    public void resetVisit() {
        this.visited = false;
    }

    public void visit() {
        this.visited = true;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (getClass() != obj.getClass() || obj == null) return false;
        Node node = (Node) obj;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}

class Graph<T> {
    private List<Node<T>> nodes = new ArrayList<>();

    public void addNode(Node<T> node) {
        nodes.add(node);
    }

    public Node<T> getNode(int index) {
        return nodes.get(index);
    }

    public void generate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) continue;
                nodes.get(i).link(nodes.get(j), row[j]);
            }
        }
    }

    public void reset() {
        nodes.forEach(Node::resetVisit);
    }

    public Connection<T> bfs(Node<T> start, Node<T> target) {
        reset();

        Queue<Connection<T>> queue = new LinkedList<>();
        queue.offer(new Connection<>(start, 0));

        while (!queue.isEmpty()) {
            Connection<T> con = queue.poll();
            Node<T> n = con.getNode();
            int weight = con.getWeight();
            n.visit();;

            if (n.equals(target))
                return new Connection<>(target, weight);

            n.getConnections().stream()
                    .filter(i -> !i.getNode().isVisited())
                    .filter(i -> !queue.contains(i))
                    .map(i -> new Connection(i.getNode(), i.getWeight() + weight))
                    .forEach(queue::offer);
        }

        return null;
    }

    public Connection<T> dfs(Node<T> start, Node<T> target) {
        reset();

        Stack<Connection<T>> stack = new Stack<>();
        stack.push(new Connection<>(start, 0));

        while (!stack.isEmpty()) {
            Connection<T> con = stack.pop();
            Node<T> n = con.getNode();
            int weight = con.getWeight();
            n.visit();;

            if (n.equals(target))
                return new Connection<>(target, weight);

            n.getConnections().stream()
                    .filter(i -> !i.getNode().isVisited())
                    .filter(i -> !stack.contains(i))
                    .map(i -> new Connection(i.getNode(), i.getWeight() + weight))
                    .forEach(stack::push);
        }

        return null;
    }
}

