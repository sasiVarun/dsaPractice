package com.test.kk.recursion.backtracking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
//        allPaths(0, 0, board, "");
        int[][] path = new int[board.length][board[0].length];
        allPathsPrint(0, 0, board, path, 1, "");
    }

    static void allPaths(int r, int c, boolean[][] maze, String path) {
        if (r == maze.length - 1 && c == maze.length - 1) {
            System.out.print(path + " ");
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r > 0) {
            allPaths(r - 1, c, maze, path + "U");
        }
        if (c > 0) {
            allPaths(r, c - 1, maze, path + "L");
        }
        if (r < maze.length - 1) {
            allPaths(r + 1, c, maze, path + "D");
        }
        if (c < maze[0].length - 1) {
            allPaths(r, c + 1, maze, path + "R");
        }

        maze[r][c] = true;
    }

    static void allPathsPrint(int r, int c, boolean[][] maze, int[][] path, int step, String p) {
        if (r == maze.length - 1 && c == maze.length - 1) {
            path[r][c] = step;
            for (int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("Path: "+p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length - 1) {
            allPathsPrint(r + 1, c, maze, path, step + 1, p + "D");
        }
        if (c < maze[0].length - 1) {
            allPathsPrint(r, c + 1, maze, path, step + 1, p + "R");
        }
        if (r > 0) {
            allPathsPrint(r - 1, c, maze, path, step + 1, p + "U");
        }
        if (c > 0) {
            allPathsPrint(r, c - 1, maze, path, step + 1, p + "L");
        }

        maze[r][c] = true;
        path[r][c] = 0;
    }
}
