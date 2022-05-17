//https://leetcode.com/problems/validate-binary-search-tree/submissions/
import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearch {

    static List<Integer> list = new ArrayList();

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2,treeNode3,treeNode4);
        TreeNode treeNode5 = new TreeNode(5,null,treeNode6);
        TreeNode treeNode = new TreeNode(1,treeNode2,treeNode5);
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right==null)) return true;

        createList(root);
        int n =0;
        list.forEach(s -> System.out.println(s));
        while(n<list.size()-1){
            if(list.get(n)>=list.get(n+1)) return false;
            n++;
        }

        return true;
    }

    static List<Integer> createList(TreeNode root){
        if(root== null) return new ArrayList();
        createList(root.left);
        list.add(root.val);
        createList(root.right);
        return list;
    }
}
