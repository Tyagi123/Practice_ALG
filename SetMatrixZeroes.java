//https:leetcode.com/problems/set-matrix-zeroes/submissions/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 2, 0},
                {4, 5, 6},
                {4, 9, 9}};
        Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::println);
        System.out.println("After setZeroes");
        setZeroes(arr);
        Arrays.stream(arr).flatMapToInt(Arrays::stream).forEach(System.out::println);
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }



        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row.contains(i) || col.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }

}
