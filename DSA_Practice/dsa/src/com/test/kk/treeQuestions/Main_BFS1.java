package com.test.kk.treeQuestions;

import java.util.List;
import java.util.Scanner;

public class Main_BFS1 {
    public static void main(String[] args) {
        BFS_1 bfs = new BFS_1();
        bfs.insert(new Scanner(System.in));
        bfs.prettyDisplay();
        bfs.connect(bfs.root);
    }
}
