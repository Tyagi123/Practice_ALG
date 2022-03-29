//String Book Chapter
public class URLIfy {

    public static void main(String[] args) {
        System.out.println(urlifyString("Mr John Smith    "));
    }

    private static String urlifyString(String str) {
        StringBuilder string = new StringBuilder(str);

        if(string == null || string.length() == 1) {
            return string.toString();
        }

        int end =  string.length()-1, start = string.length()-1;

        while(start>0){
           if(string.charAt(start) != ' '){
                break;
           }
           start--;
        }


        while(start>0){
        if(string.charAt(start) == ' '){
            string.setCharAt(end--, '0');
            string.setCharAt(end--, '2');
            string.setCharAt(end--, '%');
            start--;
        }
        else{
            string.setCharAt(end--,string.charAt(start--));
        }
        }

        return string.toString();
    }
}
