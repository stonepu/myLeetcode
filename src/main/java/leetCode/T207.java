package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap();
        HashSet<Integer> set = new HashSet();
        int len = prerequisites.length;
        for(int i = 0; i < len; i++) {
            set.add(prerequisites[i][0]);
            set.add(prerequisites[i][1]);
            if(set.size() > numCourses) return false;
            if(!map.containsKey(prerequisites[i][0])) {
                HashSet<Integer> itemSet = new HashSet();
                itemSet.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], itemSet);
            }else{
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            if(!check(map, prerequisites[i][0], prerequisites[i][1])) return false;
        }

        return set.size() <= numCourses;
    }

    public boolean check(HashMap<Integer, HashSet<Integer>> map, int f, int s) {
        if(!map.containsKey(s)) return true;

        if(map.get(s).contains(f)) return false;

        for(int it : map.get(s)) {
            if(!check(map, f, it)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        T207 t207 = new T207();
        int[][] arr = {{0,1}, {1, 2}, {0,3}, {3, 0}};
        System.out.println(t207.canFinish(4, arr));
        Integer.bitCount(2);
        String str = "1";
        str.charAt(0);
    }
}
