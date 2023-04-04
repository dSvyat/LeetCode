package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
/*
Battleships is a game played on a rectangular board.
You are given a representation of such a board of size N (height) × M (width) with information about the locations of the ships.
The board is given as an array B, whose every element is a string that corresponds to one row of the game board.
Each character of each string represents a cell of the board and is either:
1. a '#' character, marking a part of a ship; or
2. a '.' character, representing an empty cell.
Two cells that share a side and have a value of # are parts of the same ship. Cell (X, Y) shares a side with cells (X, Y -1). (X, Y+1). (X-1, Y) and (X+1, Y).
In the Battleships game there are three types of ships:
Patrol Boats of size 1.
Submarines of size 2, which come in two shapes.
Destroyers of size 3, which come in six shapes.
Your task is to find the number of ships of each type occurring on the board.
Write a function:
class Solution { public int[] solution (String[) B);}
that, given an array B consisting of N strings of length M each, returns an array R of three integers, such that:
R[0]represents the number of Patrol Boats,
R[1] represents the number of Submarines,
R[2] represents the number of Destroyers.
 */
public class CountBattleships {
    public static int[] solution(String[] B) {
        int[] shipsCount = new int[3];
        int n = B.length;
        int m = B[0].length();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i].charAt(j) == '#' && !visited[i][j]) {
                    int size = traverseShip(B, visited, i, j);
                    if (size == 1) {
                        shipsCount[0]++; // patrol boat
                    } else if (size == 2) {
                        shipsCount[1]++; // submarine
                    } else if (size == 3 || size == 6) {
                        shipsCount[2]++; // destroyer
                    }
                }
            }
        }

        return shipsCount;
    }

    public static int traverseShip(String[] B, boolean[][] visited, int i, int j) {
        int size = 0;
        int n = B.length;
        int m = B[0].length();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            size++;

            // check neighboring cells
            if (x > 0 && B[x - 1].charAt(y) == '#') {
                queue.offer(new int[]{x - 1, y});
            }
            if (x < n - 1 && B[x + 1].charAt(y) == '#') {
                queue.offer(new int[]{x + 1, y});
            }
            if (y > 0 && B[x].charAt(y - 1) == '#') {
                queue.offer(new int[]{x, y - 1});
            }
            if (y < m - 1 && B[x].charAt(y + 1) == '#') {
                queue.offer(new int[]{x, y + 1});
            }
        }

        return size;
    }
}
