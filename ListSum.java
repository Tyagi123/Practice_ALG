import common.SinglyListNode;
//https://leetcode.com/problems/add-two-numbers/submissions/


public class ListSum {

    public static void main(String[] args) {
        SinglyListNode listNode16 = new SinglyListNode(9,null);
        SinglyListNode listNode15 = new SinglyListNode(9,listNode16);
        SinglyListNode listNode14 = new SinglyListNode(9,listNode15);
        SinglyListNode listNode13 = new SinglyListNode(9,listNode14);
        SinglyListNode listNode12 = new SinglyListNode(9,listNode13);
        SinglyListNode listNode11 = new SinglyListNode(9,listNode12);
        SinglyListNode listNode1 = new SinglyListNode(9,listNode11);

        SinglyListNode listNode23 = new SinglyListNode(9,null);
        SinglyListNode listNode22 = new SinglyListNode(9,listNode23);
        SinglyListNode listNode21 = new SinglyListNode(9,listNode22);
        SinglyListNode listNode2 = new SinglyListNode(9,listNode21);

        System.out.println("First List =====");
        SinglyListNode.printAll(listNode1);
        System.out.println("Second List =====");
        SinglyListNode.printAll(listNode2);
        System.out.println("Sum  List =====");
        SinglyListNode.printAll(listSum(listNode1 , listNode2));


    }

    private static SinglyListNode listSum(SinglyListNode l1, SinglyListNode l2) {
        if(l1== null) return l2;
        if(l2==null) return l1;

        int carry = 0;
        SinglyListNode res = new SinglyListNode();
        SinglyListNode resPointer = res;

        while(l1 != null && l2!= null){
            int total  = carry + l1.val + l2.val;
            SinglyListNode local = new SinglyListNode();
            if(total<10){
                local.val  = total;
            }
            else{
                local.val  = total%10;
                carry = total/10;
            }
            res.next = local;
            res = res.next;
            l1= l1.next;
            l2= l2.next;
        }

        while(l1!= null){
            int total  = carry + l1.val;
            SinglyListNode local  = new SinglyListNode();
            if(total<10){
                local.val  = total;
                carry= 0;
            }
            else{
                local.val  = total%10;
                carry = total/10;
            }
            res.next = local;
            res = res.next;
            l1= l1.next;
        }

        while(l2 != null){
            int total  = carry + l2.val;
            SinglyListNode local  = new SinglyListNode();
            if(total<10){
                local.val  = total;
                carry= 0;
            }
            else{
                local.val  = total%10;
                carry = total/10;
            }
            res.next = local;
            res = res.next;
            l2= l2.next;
        }

        if(carry != 0 ){
            SinglyListNode local  = new SinglyListNode();
            local.val = carry;
            res.next = local;
        }
        return resPointer.next;
    }
}

