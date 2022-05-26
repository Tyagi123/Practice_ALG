//https://leetcode.com/problems/generate-parentheses/submissions/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis(3).forEach(x-> System.out.println(x));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();

        if(n==0) return result;

        generateParenthesis(0,n,n,"",result);

        return result;

    }
    public static void generateParenthesis(int balance , int open, int close, String str, List<String> result){
        if(close < open){
            return ;
        }

        if(open == 0 && close==0){
            if(balance == 0){
                result.add(str);
            }
            return;
        }

        if(balance == 0){
            generateParenthesis(balance+1, open-1, close, str+"(", result);
        }
        else if(open == 0 ){
            generateParenthesis(balance-1, open, close-1, str+")", result);
        }
        else {
            generateParenthesis(balance+1, open-1, close, str+"(", result);
            generateParenthesis(balance-1, open, close-1, str+")", result);
        }
    }
}
