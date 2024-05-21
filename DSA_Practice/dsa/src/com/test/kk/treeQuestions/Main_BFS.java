package com.test.kk.treeQuestions;

import java.util.List;
import java.util.Scanner;

public class Main_BFS {
    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.insert(new Scanner(System.in));
        bfs.prettyDisplay();
        List<List<Integer>> ans = bfs.levelOrder(bfs.root);
//        BFS.TreeNode ans1 = bfs.findSuccessor(bfs.root,14);
        List<List<Integer>> ans2 = bfs.zigzagLevelOrder(bfs.root);
        System.out.println(ans);
//        System.out.println("Successor Value: " + ans1.value);
        System.out.println(ans2);
    }
}
