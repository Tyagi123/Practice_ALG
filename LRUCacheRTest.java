import java.util.HashMap;
import java.util.LinkedHashMap;

//https://leetcode.com/problems/lru-cache/
public class LRUCacheRTest {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

   private static class LRUCache {

        HashMap<Integer,Integer> elements = null;

        int size = 0;
        int currentSize = 0;

        public LRUCache(int capacity) {
            elements = new LinkedHashMap(capacity);
            size = capacity;
        }

        public int get(int key) {
            if(!elements.containsKey(key)) return -1;
            makeRecently(key);
            return elements.get(key);
        }


        public void put(int key, int value) {
            if(elements.containsKey(key)) {
                makeRecently(key,value);
            }

            else{
                if(currentSize == size){
                    Integer lastKey =  null;
                    for(Integer currentKey :elements.keySet()){
                        lastKey = currentKey;
                        break;
                    }
                    elements.remove(lastKey);
                    currentSize--;
                }
                elements.put(key,value);
                currentSize++;
            }
        }

        private void makeRecently(int key){
            int val =elements.get(key);
            elements.remove(key);
            elements.put(key,val);
        }
        private void makeRecently(int key, int value){
            elements.remove(key);
            elements.put(key,value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}
