import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/maximum-product-of-word-lengths/submissions/
public class MaximumProductOfWordLengths {

    public static void main(String[] args) {
    String [] arr = {"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(String[] words) {
        List<Set<Character>> list = new ArrayList();

        for(String word: words){
            Set<Character> set = new HashSet();
            for(int i=0 ;i<word.length();i++){
                set.add(word.charAt(i));
            }
            list.add(set);
        }

        int result = 0;

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(!checkCommonValues(list.get(i),list.get(j))){
                    result = Math.max(result,words[i].length()*words[j].length());
                }
            }

        }
        return result;
    }

    public static boolean checkCommonValues(Set<Character> s1, Set<Character> s2){
        for(Character c : s1){
            if(s2.contains(c)) return true;
        }
        return false;
    }
}
