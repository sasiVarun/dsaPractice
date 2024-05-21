package com.test.kk.linkedList;

import com.test.kk.linkedList.InterViewQuestions.*;

public class MergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode first = list1;
        ListNode second = list2;
        ListNode ans = new ListNode();
        ListNode dummy = ans;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                dummy.next = first;
                first = first.next;
                dummy = dummy.next;
            } else {
                dummy.next = second;
                second = second.next;
                dummy = dummy.next;
            }
        }

        dummy.next = (first != null) ? first : second;
        return ans.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static void main(String[] args) {
        InterViewQuestions first = new InterViewQuestions();
        first.insertLast(4);
        first.insertLast(2);
        first.insertLast(1);
        first.insertLast(3);
        first.display();
        MergeSort ms = new MergeSort();
        ListNode ans = ms.sortList(first.head);
        first.display(ans);


    }
}
