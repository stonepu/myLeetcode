package leetCode;

import java.util.HashSet;

public class T128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int it : nums) {
            max = Math.max(max, it);
            min = Math.min(min, it);
            set.add(it);
        }

        int maxCons = 0;
        int currentCons = 0;
        for(int i = min; i <= max; i++) {
            if(set.contains(i)) {
                currentCons++;
            }else{
                maxCons = Math.max(maxCons, currentCons);
                currentCons = 0;
            }
        }
        maxCons = Math.max(maxCons, currentCons);
        return maxCons;
    }

    public static void main(String[] args) {
        T128 t128 = new T128();
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(t128.longestConsecutive(arr));
    }
}
