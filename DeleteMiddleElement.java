import common.SinglyListNode;

public class DeleteMiddleElement {

    public static void main(String[] args) {
        SinglyListNode head = new SinglyListNode(1, null);
        SinglyListNode singlyListNode = new SinglyListNode(2, null);
        SinglyListNode singlyListNode1 = new SinglyListNode(3, null);
        SinglyListNode singlyListNode2 = new SinglyListNode(4, null);
        SinglyListNode singlyListNode3 = new SinglyListNode(5, null);
        head.setNext(singlyListNode);
        singlyListNode.setNext(singlyListNode1);
        singlyListNode1.setNext(singlyListNode2);
        singlyListNode2.setNext(singlyListNode3);
        SinglyListNode.printAll(head);
        System.out.println("After ==============");
        SinglyListNode.printAll(deleteMiddle(head));
    }

        public static  SinglyListNode deleteMiddle(SinglyListNode head) {
            if(head == null || head.next == null){
                return null;
            }
            SinglyListNode current = head;
            SinglyListNode tail = current.next.next;
            while(tail != null){
                if(tail.next != null){
                    tail =  tail.next.next;
                    current = current.next;
                }
                else{
                    tail = tail.next;
                }

            }
            current.next = current.next.next;
            return head;

    }
}
