package programmers.gamemap;

import java.util.*;

/*
 ROR 게임.
 상대 팀 진영을 먼저 파괴하면 이긴다. 따라서 상태 팀 진영에 먼저 도착해야 한다.
 내 캐릭터는 1,1에서 시작하고 상대팀은 5,5에 있다.
 0은 갈 수 없는 길이고 1은 갈 수 있는 길이다.
 갈 수 있는 길 중에서 가장 빨리 갈 수 있는 길을 찾는다.

 게임 맵의 상태 maps가 주어질 때, 상대팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수 최소값을 반환하라.
 없다면 -1.

  - maps의 크기는 n*m. 1 이상 100 이하의 자연수. n과 m은 같을 수도 있고 아닐 수도 있다.
  - 0과 1로만 이루어져 있다.
  - 내 캐릭터는 좌측 상단 1,1 상대 진영은 우측 하단 n,m에 위치한다.
*/
class Solution2 {

    public static void main(String[] args) {
        int solution = new Solution2().solution(new int[][]{{1, 0, 1, 1, 1}, {
                1, 0, 1, 0, 1
        }, {
                1, 0, 1, 1, 1
        }, {
                1, 1, 1, 0, 0
        }, {0, 0, 0, 0, 1}});
        System.out.println(solution);
    }

    public int solution(int[][] maps) {

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1));

        while (!queue.isEmpty()) {
            Position p = queue.poll();

            if (p.isVisited()) continue; // 방문했던 거면 버림
            if (p.isOutRange(maps.length, maps[0].length)) continue; //레인지 밖이면 버림
            if (maps[p.x][p.y] == 0) continue; // 벽이면 버림

            if (p.isEnemy(maps.length, maps[0].length))
                return p.depth();

            p.visit();

            queue.offer(p.left());
            queue.offer(p.right());
            queue.offer(p.top());
            queue.offer(p.bottom());
        }

        return 0;
    }

    private static class Position {
        private int x;
        private int y;
        private int depth;
        private boolean isVisited;

        public Position(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isVisited = false;
        }

        public boolean isOutRange(int xLen, int yLen) {
            return this.x >= xLen || this.x < 0 || this.y >= yLen || this.y < 0;
        }

        public boolean isEnemy(int xLen, int yLen) {
            return this.x == xLen - 1 && this.y == yLen - 1;
        }

        public int depth() {
            return this.depth();
        }

        public void visit() {
            this.isVisited = true;
        }

        public boolean isVisited() {
            return this.isVisited;
        }

        public Position left() {
            return new Position(x, y - 1, depth + 1);
        }

        public Position right() {
            return new Position(x, y + 1, depth + 1);
        }

        public Position top() {
            return new Position(x - 1, y, depth + 1);
        }

        public Position bottom() {
            return new Position(x + 1, y, depth + 1);
        }
    }
}