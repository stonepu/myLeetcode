package leetCode;
import java.util.*;

public class T47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> listList = new LinkedList();
        if(nums.length == 0) return listList;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        LinkedList<Integer> list = new LinkedList<>();
        permuteUnique(nums.length, listList, list, hashMap);
        return listList;
    }

    public void permuteUnique(int targetSize, List<List<Integer>> listList, List<Integer> subList,  HashMap<Integer, Integer> map) {
        if(subList.size() == targetSize){
            listList.add(subList);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Set<Integer> keySet = map.keySet();
//        boolean stopFlag = true;
        for(int num : keySet) {
            if(map.get(num) == 0) continue;
//            stopFlag = false;
            if(set.contains(num)) continue;
            map.put(num, map.get(num) - 1);

            LinkedList<Integer> list = new LinkedList<>(subList);
            list.add(num);

            //记录到list中
            permuteUnique(targetSize, listList, list, map);
            map.put(num, map.get(num) + 1);

        }
//        if(stopFlag) return;

    }
}
