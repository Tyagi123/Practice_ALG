import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/balance-a-binary-search-tree/submissions/
public class BalanceBST {
    public static void main(String[] args) {

    }

    List<Integer> array = new ArrayList();
    public TreeNode balanceBST(TreeNode root) {
        createArray(root);
      /*  for(int i =0;i<array.size();i++){
            System.out.println(array.get(i));
        } */
        return buildBST(array,0,array.size()-1);
    }

    public TreeNode buildBST(List<Integer> inorder , int left , int right){
        if(left > right){
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode newNode = new TreeNode(inorder.get(mid));
        newNode.left = buildBST(inorder,left , mid-1);
        newNode.right = buildBST(inorder , mid+1 , right);
        return newNode;
    }


    List<Integer> createArray(TreeNode root){
        if(root == null){
            return new ArrayList();
        }
        createArray(root.left);
        array.add(root.val);
        createArray(root.right);
        return array;
    }
}

