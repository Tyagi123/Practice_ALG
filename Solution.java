import java.sql.SQLOutput;

class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("adam"));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;

        String result = "";
        result =  getPalindrome(result, s, n);
        return result.equals("") ? String.valueOf(s.charAt(0)) : result;
}
   
 public static String getPalindrome(String result , String s, int n){
     if(n % 2 != 0 ){
         result =  getPalindrome(s,n/2,true,n);
     }
        for(int i=0;i<n;i++){
            String currentString = getPalindrome(s,i,false,n);
            if(result==null){
                result = currentString;
            }
            else{
                result =  result.length()>currentString.length()? result : currentString;
            }
        }
     return result ;
     }

    public static String getPalindrome(String s , int mid, boolean flag, int n){
        int start = mid;
        int end = mid + 1;
        if(flag){
             start = mid-1;
        }

       while(start>=0 && end<n && s.charAt(start)==s.charAt(end)){
           start -- ;
           end ++;
       }

       String str1 = s.substring(++start,end);

         start = mid-1;
         end = mid ;
        while(start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start -- ;
            end ++;
        }
        String str2 = s.substring(++start,end);

        return str1.length()>str2.length()?str1:str2;
    }
}