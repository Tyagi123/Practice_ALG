public class OneAwayChar {

    public static void main(String[] args) {
        System.out.println(oneAweyChar("pale","ple"));
    }

    private static boolean oneAweyChar(String str1, String str2) {


        int count = 0;
        int index1 = 0;
        int index2 = 0;

        while(index1<str1.length() && index2<str2.length()){
            if(str1.charAt(index1) != str1.charAt(index2)){
                count++;
            }
            if(count == 2) return false;
            index1++;
            index2++;
        }

        while(index1<str1.length()){
            count++;
            if(count == 2) return false;
        }

        while(index2<str2.length()){
            count++;
            if(count == 2) return false;
        }

        return count<=1;
    }
}
