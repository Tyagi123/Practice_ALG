import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
    public static void main(String[] args) {
        System.out.println( coinChange(new int []{1,2,5},11));
    }

    public static  int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int [] result = new int [amount+1];
        Arrays.fill(result,amount);

        result[0] = 0;

        for(int coin: coins){
            for(int i=1;i<=amount;i++){
                if(coin <= i){
                    result[i] = Math.min(result[i],result[i-coin]+1);
                }
            }
        }
        return result[amount]==0?-1:result[amount];

    }
}
