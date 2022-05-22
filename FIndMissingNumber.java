public class FIndMissingNumber {

    public static void main(String[] args) {
        int arr [] = new int [] {1,2,3,4,6};
        System.out.println(getMissingNoForSorted(arr));
        //System.out.println("abcdef".substring(0,6));
    }

    static int getMissingNo(int a[])
    {
        int x1 = a[0];
        int x2 = 1;
        int n = a.length;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }


    static int getMissingNoForSorted(int a[])
    {
        int lastNumber = a[0];
        int result = 0;
        for(int i=1;i<a.length;i++){
            if(a[i]-lastNumber > 1){
                result =  lastNumber+1;
                break;
            }
            lastNumber = a[i];
        }
        return result;
    }
}
