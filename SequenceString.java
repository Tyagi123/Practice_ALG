public class SequenceString {
    public static void main(String[] args) {
        System.out.println(sequenceString("aabbbbcccdaaa"));
    }

    private static String sequenceString(String str) {
        //
        StringBuilder sd = new StringBuilder();
        int first =  0;
        int last = 1;
        int currentCount= 0;

        while(last<str.length()){
            if(str.charAt(first)!=str.charAt(last)){
                sd.append(str.charAt(first));
                sd.append(last-first);
                first = last;
            }
            last++;
        }
        sd.append(str.charAt(last-1));
        sd.append(last-first);
        return sd.toString();
    }
}
