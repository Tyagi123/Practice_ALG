import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/

public class ListOfDepths_Tree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList();
        levelCalculate(root,lists,0);
        return lists;
    }
    private void levelCalculate(TreeNode root,List<List<Integer>> lists,int level){
        if(root==null) return;
        List<Integer> list = null;
        if(lists.size() == level){
            list = new ArrayList();
            lists.add(list);
        }
        else{
            list = lists.get(level);
        }
        list.add(root.val);
        levelCalculate(root.left,lists,level+1);
        levelCalculate(root.right,lists,level+1);
    }

    public static void main(String[] args) {
        new ListOfDepths_Tree().levelOrder(new TreeNode(1, null, null))
                .stream()
                .forEach(System. out::println);
    }
}
