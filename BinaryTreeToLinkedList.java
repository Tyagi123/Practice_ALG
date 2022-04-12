import common.TreeNode;

public class BinaryTreeToLinkedList {

    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2,treeNode3,treeNode4);
        TreeNode treeNode5 = new TreeNode(5,null,treeNode6);
        TreeNode treeNode = new TreeNode(1,treeNode2,treeNode5);
        flatten(treeNode);
       // TreeNode.printAll(treeNode);
    }


    private static TreeNode prev = null;
    public static  void flatten(TreeNode root) {
        if (root == null)
            return;
        System.out.println("element ---- "+root.val);
        flatten(root.right);
        flatten(root.left);
        if(root != null )System.out.println("root ---- "+ root.val);
        if(prev != null )System.out.println("prev ---- "+ prev.val);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
