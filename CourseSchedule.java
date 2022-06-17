import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/course-schedule/submissions/

public class CourseSchedule {

    public static void main(String[] args) {
         int [][] arr = new int [][] {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(canFinish(5,arr));
    }

    public static  boolean canFinish(int numCourses, int[][] prerequisites) {
        final int len = prerequisites.length;

        if(numCourses == 1 ||  len == 0 || (len ==1 && numCourses == 2)) return true;

        Map<Integer , Set<Integer>> dependency = new HashMap();
        Set<Integer> courseWithDep = new HashSet();

        for(int i=0 ;i<len ; i++){
            Set<Integer> depSet = dependency.get(prerequisites[i][1]);
            if(depSet == null){
                depSet = new HashSet();
            }
            courseWithDep.add(prerequisites[i][0]);
            depSet.add(prerequisites[i][0]);
            dependency.put(prerequisites[i][1],depSet);

        }

        if(dependency.size() == numCourses) return false;

        for(int i=0;i<numCourses;i++){
            if(//!courseWithDep.contains(i) &&
                    checkCourses(dependency,new HashSet(),i,numCourses)){
                return true;
            }
        }

        return false;
    }

    public static boolean checkCourses( Map<Integer , Set<Integer>> dependency , Set<Integer> visited , Integer current,Integer numCourses){
        if(visited.contains(current)) return false;
        if(dependency.get(current)== null || dependency.get(current).isEmpty()) return true;

        visited.add(current);

        if(dependency.get(current) != null){
            for(Integer it: dependency.get(current)){
               return !checkCourses(dependency,visited,current,numCourses);
            }
        }
        visited.remove(current);
        return true;
    }
}
