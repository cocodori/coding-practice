package programmers.단어변환;

import java.util.*;

/*
 begin -> target으로 가는 문제
 target이 들어있는 words가 주어지는데, 한 번에 한 문자만 변경할 수 있음.
 words에는 target이 없을 수도 있다.

 begin = "hit", target="cog", words=["hot", "dot", "dog", "lot", "log", "cog"]


    "hit" -> "hot"(1) -> "dot"(2) -> "dog"(3) -> "cog"(4)
                |               \          \
             "lot"(2)         "lot"(3)     "log"(4)
              /    \              \         /      \
          "dot"(3) "log"(3)      "log"(4) "cog"(5) "lot"(5)
          /          \               \               \
       "dog"(4)      "cog"(4)      "cog"(5)           X
       /
    "cog"(5)
*/
class Solution {
    private static class Node {
        private String word;
        private boolean isVisited;
        private int depth;

        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
            this.isVisited = false;
        }

        public String word() {
            return this.word;
        }

        public int depth() {
            return this.depth;
        }

        public boolean isVisited() { return this.isVisited; }

        public boolean isCurrentTarget(String target) {
            return this.word.equals(target);
        }

        public boolean isChangeable(String w) {
            int diffCount = 0;
            for (int i = 0; i < w.length(); i++) {
                if (this.word.charAt(i) != w.charAt(i)) diffCount ++;
                if (diffCount > 1) return false;
            }

            return true;
        }

        public void visit() { this.isVisited = true; }

    }
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.isCurrentTarget(target)) return node.depth();
            if (node.isVisited()) continue;
            node.visit();

            for (String w : words) {
                if (!node.isChangeable(w)) continue;
                Node newNode = new Node(w, node.depth()+1);
                queue.offer(newNode);
            }
        }

        return 0;
    }
}
