import java.util.*;
//https://leetcode.com/problems/minimum-height-trees/
public class MinimumHeightTrees {

    public static void main(String[] args) {
        int [][] edges = new int [][] {{3,0},{3,1},{3,2},{3,4},{5,4}};
        findMinHeightTrees(6, edges);
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==0){
            return new ArrayList();
        }
        if(n==1){
            List<Integer> res = new ArrayList();
            res.add(0);
            return res;
        }

        Map<Integer,  Set<Integer>> adjList= new HashMap();

        for(int i=0;i<edges.length;i++){
            adjList.putIfAbsent(edges[i][0],new HashSet());
            adjList.putIfAbsent(edges[i][1],new HashSet());
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);

        }

        while(adjList.size()>2){
            List<Integer> currentList = new ArrayList<>();
            for (Integer key : adjList.keySet()){
                if(adjList.get(key).size() == 1){
                    currentList.add(key);
                }
            }
            while(!currentList.isEmpty()){
                for(Integer child : adjList.get(currentList.get(0))){
                    adjList.get(child).remove(currentList.get(0));
                }
                adjList.remove(currentList.get(0));
                currentList.remove(0);
            }

        }
        List<Integer> res  = new ArrayList(adjList.keySet());
        return res ;
    }
}
