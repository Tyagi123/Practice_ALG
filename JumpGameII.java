//https://leetcode.com/problems/jump-game-ii/submissions/
public class JumpGameII {

    public static void main(String[] args) {
     int [] arr = {2,3,1,1,4};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        if( nums[0] == 0 || nums.length == 1) return 0;

        if( nums.length <= 2) return 1;

        int minIndex =  nums.length-1;
        int minsteps = 0;

        while(minIndex > 0){
            minIndex =  getMinIndex(nums,minIndex);
            // System.out.println(minIndex);
            minsteps ++;
        }

        return minsteps;
    }


    public static int  getMinIndex(int [] nums, int minIndex){
        int currentIndex = minIndex;
        int localMinIndex = minIndex;
        while(currentIndex >= 0){
            if(nums[currentIndex]-(localMinIndex-currentIndex) >= 0){
                minIndex = Integer.min(minIndex,currentIndex);
            }
            currentIndex--;
        }
        return minIndex;
    }
}
