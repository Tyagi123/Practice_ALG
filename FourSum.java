import java.util.*;

//https://leetcode.com/problems/4sum/
public class FourSum {
    public static void main(String[] args) {
        int arr [] = {1,0,-1,0,-2,2};
    printList(fourSum(arr,0 ));
    }

    private static void printList(List<List<Integer>> list) {
        if(list != null){
         list.forEach(ele-> System.out.println());
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        int len = nums.length;

        Arrays.sort(nums);

        int start = 0;
        int currentSum = 0;

        for(int i=0 ; i<len-3; i++) {
            for(int j = i+1 ;j<len-2; j++) {
                start = j + 1;
                    int end = len - 1;
                    while (end > start) {
                        currentSum = nums[i] + nums[start] + nums[j] + nums[end];
                        if (currentSum  == target) {
                            List<Integer> newList = new ArrayList();
                            newList.add(nums[i]);
                            newList.add(nums[j]);
                            newList.add(nums[start]);
                            newList.add(nums[end]);
                            resultSet.add(newList);
                        }
                        if (currentSum < target) {
                            start++;
                        } else {
                            end--;
                        }
                }
            }
        }
        return new ArrayList<List<Integer>>(resultSet);
    }
}
