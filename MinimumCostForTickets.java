import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-cost-for-tickets/
public class MinimumCostForTickets {

    public static void main(String[] args) {

        System.out.println(minCostTickets(new int []{1,4,6,7,8,20}, new int [] {2,7,15}));
    }

    public static int minCostTickets(int[] days, int[] costs) {
        final int length = days.length;
        if(length == 0) return 0;
        int [] result = new int [days[length-1]+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        boolean [] isPresentArray = new boolean[days[length-1]+1];
        for(int day : days){
            isPresentArray[day]=true;
        }
        result[0] = 0 ;
        for(int i=1;i<= days[length-1]; i++){

            if(!isPresentArray[i]){
                result[i] =  result[i-1];
                continue;
            }

            result[i] =  Math.min(result[i-1]+costs[0],result[i]);
            result[i] =   getMinCost(result,7,i,1,costs);
            result[i] =   getMinCost(result,30,i,2,costs);
        }

        return result[days[length-1]];

    }
    private static int getMinCost(int [] result , int n, int i, int time, int[] costs){
        if(i-n >= 0){
            return  Math.min(result[i-n]+costs[time],result[i]);
        }
        else{
            return Math.min(result[i],costs[time]);
        }
    }
}

