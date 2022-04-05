import common.LocalLInkedList;

import java.util.HashSet;
import java.util.Set;

public class RemovedDuplicateLinkedListElement {
    public static void main(String[] args) {
        LocalLInkedList localList =  new LocalLInkedList(1, null, null);
        LocalLInkedList localList2 = new LocalLInkedList(1, null, null);
        LocalLInkedList localList3 = new LocalLInkedList(2, null, null);
        LocalLInkedList localList4 = new LocalLInkedList(3, null, null);
        localList.setNext(localList2);
        localList2.setPrevious(localList);
        localList2.setNext(localList3);
        localList3.setPrevious(localList2);
        localList3.setNext(localList4);
        localList4.setPrevious(localList3);
        LocalLInkedList.printAll(localList);
        removeDuplicate(localList);
        LocalLInkedList.printAll(localList);
    }

    private static void removeDuplicate(LocalLInkedList localList) {
        if(localList != null){
            Set<Integer> setElements = new HashSet<>();
            while(localList != null){
                if(setElements.contains(localList.getValue())){
                    localList.previous.next = localList.next;
                }
                setElements.add(localList.getValue());
                localList = localList.next;
            }
        }
    }
}
