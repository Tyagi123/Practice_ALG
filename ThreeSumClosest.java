import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {

    public static void main(String[] args) {
     int [] arr = {1,1,-1,-1,3};
        System.out.println(threeSumClosest(arr,3));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = target + 2002;

        int i = 0;
        int left, right, curTarget, sum;
        while(i < nums.length - 2){
            left = i+1;
            right = nums.length - 1;
            curTarget = target - nums[i];

            while(left < right){
                sum = nums[left] + nums[right];
                if(Math.abs(curTarget - sum) < Math.abs(target - closest)){
                    closest = nums[i] + sum;
                }
                if(sum < curTarget){
                    left++;
                }else if(sum > curTarget){
                    right--;
                }else{
                    return target;
                }
            }
            i++;
        }
        return closest;
    }
}
