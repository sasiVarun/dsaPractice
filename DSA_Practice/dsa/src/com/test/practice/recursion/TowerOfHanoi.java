package com.test.practice.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n,"S","H","D");
    }

    static void towerOfHanoi(int diskCount, String source, String helper, String destination){
        if(diskCount==1){
            System.out.println("Transfer disk " + diskCount + " from " + source + " to " + destination);
            return;
        }
        // First transfer n-1 disks from Source to Destination, initially here Destination is Helper
        // and Helper is Source
        towerOfHanoi(diskCount-1,source,destination,helper);
        // After transferring n-1 disks left with 1 disk transfer it from Source to Destination
        System.out.println("Transfer disk " + diskCount + " from " + source + " to " + destination);
        // At last transfer n-1 disks from Helper to Destination, considering Source as Helper
        // and Helper as Source
        towerOfHanoi(diskCount-1,helper,source,destination);
    }
}
