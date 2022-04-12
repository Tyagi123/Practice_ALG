package common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
     public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
   }

   public static void printAll(TreeNode treeNode){
       List<TreeNode> currentList = new ArrayList<>();
       currentList.add(treeNode);
        while(!currentList.isEmpty()) {
            System.out.println("==============================");
             final TreeNode local_node = currentList.get(0);
             if(local_node != null) {
                 System.out.println("Value ======  " + local_node.val);
                 if(local_node.left != null) {
                     currentList.add(local_node.left);
                     System.out.println("Left ======  " + local_node.left.val);
                 }
                 if(local_node.right != null) {
                     currentList.add(local_node.right);
                     System.out.println("Right ======  " + local_node.right.val);
                 }
             }
             currentList.remove(0);

            System.out.println("=================================");
        }
   }
}
