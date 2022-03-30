import java.util.Arrays;
//https://leetcode.com/problems/rotate-image/submissions/

public class MatrixRotation {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::println);
        System.out.println("After rotation");
        rotate(arr);
        Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::println);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int loop = 1 + n / 2;

        for (int i = 0; i < loop; i++) {
            for (int j = i; j < n - i; j++) {
                int temp = matrix[i][j];

                matrix[i][j]=matrix[n - j][i];
                matrix[n - j][i]= matrix[n - i][n - j];
                matrix[n - i][n - j]= matrix[j][n - i];
                matrix[j][n - i]=temp;
            }

        }
    }
}