package common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SinglyListNode {
    public int val;
    public SinglyListNode next;

    public static void printAll(SinglyListNode root){
        if(root != null){
            while(root != null){
                System.out.println(root.val);
                root = root.next;
            }
        }
    }
     }