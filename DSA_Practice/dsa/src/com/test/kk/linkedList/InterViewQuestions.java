package com.test.kk.linkedList;

public class InterViewQuestions {
    public ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public void insertFirst(int value) {
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    public void insertLast(int value) {
        if (head == null) {
            insertFirst(value);
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNode node = new ListNode(value);
        temp.next = node;
    }

    public void display() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    public void display(ListNode temp) {
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //https://leetcode.com/problems/linked-list-cycle/description/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public int lengthOfCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/description/
    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthOfCycle(slow);
                break;
            }
        }
        if (length == 0) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;
        while (length > 0) {
            second = second.next;
            length--;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    // https://leetcode.com/problems/happy-number/description/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (fast != slow);
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int reminder = n % 10;
            ans = reminder * reminder;
            n = n / 10;
        }
        return ans;
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/description/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //https://leetcode.com/problems/sort-list/description/
//    public ListNode sortList(ListNode head){
//
//    }

    // https://leetcode.com/problems/reverse-linked-list/submissions/
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    //https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode previous = null;
        ListNode present = head;

        for (int i = 0; present != null && i < left - 1; i++) {
            previous = present;
            present = present.next;
        }

        ListNode beforeLeft = previous;
        ListNode subListStart = present;

        ListNode next = present.next;
        for (int i = 0; present != null && i < (right - left + 1); i++) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (beforeLeft != null) {
            beforeLeft.next = previous;
        } else {
            head = previous;
        }

        subListStart.next = present;

        return head;
    }

    //https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        ListNode middle = middleNode(head);
        ListNode reverseMiddle = reverseList(middle);
        ListNode reReverse = reverseMiddle;

        while (head != null && reverseMiddle != null) {
            if (head.val != reverseMiddle.val) {
                break;
            }
            head = head.next;
            reverseMiddle = reverseMiddle.next;
        }

        reverseList(reverseMiddle);
        return head == null || reverseMiddle == null;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = middleNode(head);
        ListNode headSecond = reverseList(middle);
        ListNode headFirst = head;

        while (headFirst != null && headSecond != null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        if (headFirst != null) {
            headFirst.next = null;
        }
    }

    public int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null && k <= 1) {
            return head;
        }
        ListNode previous = null;
        ListNode present = head;

        int length = getLength(head);
        int count = length / k;

        while (count > 0) {
            ListNode last = previous;
            ListNode newEnd = present;
            ListNode next = present.next;
            for (int i = 0; present !=null && i < k; i++) {
                present.next = previous;
                previous = present;
                present = next;
                if (next != null) {
                    next = next.next;
                }
            }

            newEnd.next = present;

            if (last != null) {
                last.next = previous;
            } else {
                head = previous;
            }
            previous = newEnd;

            count--;
        }

        return head;
    }

    public ListNode reverseAlternateKGroups(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode previous = null;
        ListNode present = head;

        while (present != null) {
            ListNode last = previous;
            ListNode newEnd = present;
            ListNode next = present.next;

            for (int i = 0; present !=null &&  i < k; i++) {
                present.next = previous;
                previous = present;
                present = next;
                if (next != null) {
                    next = next.next;
                }
            }

            newEnd.next = present;

            if (last != null) {
                last.next = previous;
            } else {
                head = previous;
            }

            //Skipping next K nodes
            for (int i = 0; present !=null && i < k; i++) {
                previous= present;
                present = present.next;
            }
        }
        return head;
    }

    public ListNode rotateRight(ListNode head, int k){
        if(k<=0 || head == null || head.next == null){
            return head;
        }
        int length = 1;
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            length++;
        }

        node.next = head;

        int rotations = k % length;
        int skip = length - rotations;

        ListNode newLast = head;

        for (int i = 0; i < skip-1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public static void main(String[] args) {
//        InterViewQuestions l1 = new InterViewQuestions();
//        l1.insertLast(1);
//        l1.insertLast(2);
//        l1.insertLast(3);
//        l1.insertLast(4);
//        l1.insertLast(5);
//        l1.display();
//        ListNode ans = l1.reverseBetween(l1.head, 1, 5);
//        l1.display(ans);

//        InterViewQuestions l1 = new InterViewQuestions();
//        l1.insertLast(1);
//        l1.insertLast(2);
//        l1.insertLast(3);
//        l1.insertLast(2);
//        l1.insertLast(1);
//        l1.display();
//        boolean ans = l1.isPalindrome(l1.head);
//        System.out.println(ans);
//        l1.display();

//        InterViewQuestions l1 = new InterViewQuestions();
//        l1.insertLast(1);
//        l1.insertLast(2);
//        l1.insertLast(3);
//        l1.insertLast(4);
//        l1.insertLast(5);
//        l1.insertLast(6);
//        l1.insertLast(7);
//        l1.display();
//        l1.reorderList(l1.head);
//        l1.display();

//        InterViewQuestions l1 = new InterViewQuestions();
//        l1.insertLast(1);
//        l1.insertLast(2);
//        l1.insertLast(3);
//        l1.insertLast(4);
//        l1.insertLast(5);
//        l1.insertLast(6);
//        l1.insertLast(7);
//        l1.insertLast(8);
//        l1.insertLast(9);
//        l1.display();
//        ListNode ans = l1.reverseAlternateKGroups(l1.head, 3);
////        ListNode ans = l1.reverseKGroup(l1.head, 3);
//        l1.display(ans);

        InterViewQuestions l1 = new InterViewQuestions();
        l1.insertLast(1);
        l1.insertLast(2);
        l1.insertLast(3);
        l1.insertLast(4);
        l1.insertLast(5);
        l1.insertLast(6);
        l1.display();
        ListNode ans = l1.rotateRight(l1.head,1);
        l1.display(ans);
    }

}

