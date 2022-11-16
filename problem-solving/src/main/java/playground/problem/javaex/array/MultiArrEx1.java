package playground.problem.javaex.array;

import java.util.Arrays;
import java.util.Scanner;

public class MultiArrEx1 {
    public static void main(String[] args) {
        final int SIZE = 10;
        int x = 0, y = 0;

        char[][] board = new char[SIZE][SIZE];
        // 0은 바다, 1은 배
        byte[][] shipBoard = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0}
        };

        // 1행에 행번호를, 1열에 열번호를 저장한다.
        for (int i = 1; i < SIZE; i++) {
            board[i][0] = (char) (i + '0');
            board[0][i] = board[i][0];
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("좌표를 입력하세요. (종료는 00) > ");
            String input = scanner.nextLine();

            if (input.length() == 2) {
                x = input.charAt(0) - '0'; // 문자를 숫자로 변환
                y = input.charAt(1) - '0';

                if (x == 0 && y == 0)
                    break;
            }

            if (input.length() != 2 || x <= 0 || x >= SIZE || y <= 0 || y >= SIZE) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                continue;
            }

            // shipBoard[x-1][y-1]의 값이 1이면, 'O'를, board[x][y]에 저장한다.
            board[x][y] = shipBoard[x - 1][y - 1] == 1 ? 'O' : 'X';

            for (int i=0;i<SIZE;i++) {
                System.out.println(board[i]);
            }
            System.out.println();
        }

    }
}
