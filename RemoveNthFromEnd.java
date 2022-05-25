import common.ListNode;

import java.util.*;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode next = head;
        ListNode previous = head;

        int steps= 0;

        while(steps < n){
            if(next.next == null){
                if (steps == n - 1) {
                    head = head.next;
                }
                return head;
            }
            next = next.next;
            steps++;
        }

        while(next != null && next.next != null){
            next= next.next;
            previous=previous.next;
        }

        if(previous != null && previous.next != null){
            previous.next = previous.next.next; }
        return head;

    }
}
