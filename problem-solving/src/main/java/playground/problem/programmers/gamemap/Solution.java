package playground.problem.programmers.gamemap;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                }
        ));
    }

    public int solution(int[][] maps) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j] == 0) continue;
                Node node = new Node(i, j, true);
                nodes.add(node);
            }
        }

        Graph graph = new Graph(nodes);

        graph.link(maps);

        return graph.dfs(4, 4);
    }

    private static class Graph {
        private final List<Node> nodes;

        public Graph(List<Node> nodes) {
            this.nodes = nodes;
        }

        public void link(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {

                    final int x = i;
                    final int y = j;

                    Optional<Node> target = nodes.stream().filter(n -> n.x == x && n.y == y).findFirst();
                    if (!target.isPresent()) continue;

                    Optional<Node> bottom = nodes.stream().filter(n -> n.x == x - 1 && n.y == y).findFirst();
                    Optional<Node> top = nodes.stream().filter(n -> n.x == x + 1 && n.y == y).findFirst();
                    Optional<Node> right = nodes.stream().filter(n -> n.x == x && n.y == y + 1).findFirst();
                    Optional<Node> left = nodes.stream().filter(n -> n.x == x && n.y == y - 1).findFirst();

                    if (bottom.isPresent()) target.get().link(bottom.get());
                    if (top.isPresent()) target.get().link(top.get());
                    if (right.isPresent()) target.get().link(right.get());
                    if (left.isPresent()) target.get().link(left.get());
                }
            }
        }

        //Node의 [0][0]부터 [4][4]까지 가는 길을 찾는다.
        public int dfs(int x, int y) {
            Stack<Node> stack = new Stack<>();
            stack.push(nodes.get(0));

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                node.visit();

                if (node.x == x && node.y == y) {
                    return node.depth;
                }

                node.links.stream()
                        .filter(n -> n.isNotVisited())
                        .filter(n -> !stack.contains(n))
                        .forEach(n -> {
                            n.depth = node.depth + 1;
                            stack.push(n);
                        });
            }

            return -1;
        }
    }

    private static class Node {
        final int x;
        final int y;
        final boolean isGoing;
        final List<Node> links;
        int depth = 1;
        boolean isVisited;

        Node(int x, int y, boolean isGoing) {
            this.x = x;
            this.y = y;
            this.isGoing = isGoing;
            this.links = new LinkedList<>();
            this.isVisited = false;
        }

        public void link(Node node) {
            if (node == null) return;
            this.links.add(node);
        }

        public boolean isNotVisited() {
            return !isVisited;
        }

        public void visit() {
            this.isVisited = true;
        }
    }
}