import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/combination-sum/

public class CombinationSum {

    public static void main(String[] args) {
        int arr [] = {2,3,6,7};
        combinationSum(arr,7);
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        if(candidates.length == 0 || target ==0 ) return result;
        List<Integer> currentList = new ArrayList<>();
        getCombinationSum(candidates, target, result, currentList, candidates.length, 0, 0);
        return result;
    }

    public static void getCombinationSum(int[] candidates, int target,List<List<Integer>> result,List<Integer> currentList,int length,
                                  int index, int currentSum) {
        if(index == length ) {
            if (currentSum == target) {
                result.add(new ArrayList<>(currentList));
            }
            return;
        }

        if((currentSum+candidates[index] <=  target ) && (candidates[index] <= target-currentSum)) {
            currentList.add(candidates[index]);
            getCombinationSum(candidates,target,result,currentList,length,index,currentSum+candidates[index]);
            currentList.remove(currentList.size() - 1);
        }
            getCombinationSum(candidates, target, result, currentList, length, index + 1,
                    currentSum);
    }
}
