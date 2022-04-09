import java.util.*;
//https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/
public class FindGraphPath {

    public static void main(String[] args) {
        int edges [][] = new int [][] {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        //int edges [][] = new int [][] {{0,1},{1,2},{2,0}};

        System.out.println(validPath(10,edges,7,5));

    }

    public static  boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n<=1) return true;

        Map<Integer , List<Integer>>  maps = new HashMap();
        for(int i=0 ; i<edges.length ; i++){
            final int parent = edges[i][0];
            List<Integer> list = maps.get(parent);
            if(list == null){
                list = new ArrayList();
            }
            list.add(edges[i][1]);
            maps.put(edges[i][0],list);


            final int child = edges[i][1];
            List<Integer> list1 = maps.get(child);
            if(list1 == null){
                list1 = new ArrayList();
            }
            list1.add(edges[i][0]);
            maps.put(edges[i][1],list1);
        }


        List<Integer> currentList = maps.get(source);
        maps.remove(source);
        while(currentList != null && !currentList.isEmpty()){
            final int val = currentList.get(0);
            currentList.remove(0);
            if(val == destination) return true;
            final List<Integer> newEle = maps.get(val);
            if(newEle != null){
                currentList.addAll(maps.get(val));
            }            maps.remove(val);
        }
        return false;
    }
}
