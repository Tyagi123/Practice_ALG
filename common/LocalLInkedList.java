package common;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocalLInkedList {
    public Integer value;
    public LocalLInkedList next;
    public LocalLInkedList previous;

    public static void printAll(LocalLInkedList root){
        if(root != null){
           while(root != null){
               System.out.println(root.value);
               root = root.next;
           }
        }
    }
}
