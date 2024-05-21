package com.test.kk.recursion.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(count(3, 3));
//        path(3, 3, "");
//        ArrayList<String> ans = pathRet(3,3,"");
//        ArrayList<String> ans = pathDiagonal(3, 3, "");
//        System.out.println(ans);
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathRestrictions(0,0,board,"");
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int down = count(r - 1, c);
        int right = count(r, c - 1);

        return down + right;
    }

    static void path(int r, int c, String processed) {
        if (r == 1 && c == 1) {
            System.out.print(processed + " ");
            return;
        }

        if (r > 1) {
            path(r - 1, c, processed + "D");
        }

        if (c > 1) {
            path(r, c - 1, processed + "R");
        }
    }

    static ArrayList<String> pathRet(int r, int c, String processed) {
        ArrayList list = new ArrayList<>();
        if (r == 1 && c == 1) {
            list.add(processed);
            return list;
        }

        if (r > 1) {
            list.addAll(pathRet(r - 1, c, processed + "D"));
        }

        if (c > 1) {
            list.addAll(pathRet(r, c - 1, processed + "R"));
        }

        return list;
    }

    static ArrayList<String> pathDiagonal(int r, int c, String processed) {
        ArrayList<String> list = new ArrayList<>();

        if (r == 1 && c == 1) {
            list.add(processed);
            return list;
        }

        if (r > 1) {
            list.addAll(pathDiagonal(r - 1, c, processed + "V"));
        }

        if (c > 1) {
            list.addAll(pathDiagonal(r, c - 1, processed + "H"));
        }

        if (r > 1 && c > 1) {
            list.addAll(pathDiagonal(r - 1, c - 1, processed + "D"));
        }

        return list;
    }

    static void pathRestrictions(int r, int c, boolean[][] maze, String path) {
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.print(path + " ");
            return;
        }

        if(!maze[r][c]){
            return;
        }
        if (r < maze.length - 1) {
            pathRestrictions(r + 1, c, maze, path + "D");
        }
        if (c < maze[0].length - 1) {
            pathRestrictions(r, c + 1, maze, path + "R");
        }
    }
}
