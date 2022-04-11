import common.SinglyListNode;

import java.util.Stack;

//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public static void main(String[] args) {
        SinglyListNode singlyListNode1 = new SinglyListNode(1,null);
        SinglyListNode singlyListNode2 = new SinglyListNode(0,singlyListNode1);
        SinglyListNode root = new SinglyListNode(1,singlyListNode2);

        System.out.println("List ===========");
        SinglyListNode.printAll(root);

        System.out.println("LiPalindromes Testing===========");
        System.out.println(isPalindrome(root));




        SinglyListNode singlyListNode11 = new SinglyListNode(1,null);
        SinglyListNode singlyListNode21 = new SinglyListNode(0,singlyListNode11);
        SinglyListNode singlyListNode22 = new SinglyListNode(3,singlyListNode21);
        SinglyListNode root1= new SinglyListNode(1,singlyListNode22);

        System.out.println("List ===========");
        SinglyListNode.printAll(root1);

        System.out.println("LiPalindromes Testing===========");
        System.out.println(isPalindrome(root1));
    }


    public static boolean isPalindrome(SinglyListNode head) {
        if(head == null || head.next == null) return true;
        SinglyListNode slow = head;
        SinglyListNode fast = head;

        Stack<Integer> stack = new Stack<Integer>();

        while(fast != null && fast.next != null){
            stack.push(slow.val);
            fast = fast.next.next;
            slow= slow.next;
        }

        if(fast != null){
            slow= slow.next;
        }

        while(slow != null){
            if(stack.pop() != slow.val){
                return false;
            }
            slow= slow.next;
        }

        return true;
    }
}
