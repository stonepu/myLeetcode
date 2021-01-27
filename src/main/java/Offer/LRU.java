package Offer;
import java.util.*;

public class LRU {
    public int[] LRU (int[][] operators, int k) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> list = new LinkedList();
        Deque<Integer> record = new LinkedList();
        HashMap<Integer, Integer> recordMap = new HashMap();
        int currMin = 0;
        int index = 0;
        for(int[] item : operators) {
            if(item[0] == 1) {
                map.put(item[1], item[2]);
                record.addLast(item[1]);
                recordMap.put(item[1], index++);
                if(map.size() > k) {
                    while(recordMap.getOrDefault(record.peekFirst(), Integer.MAX_VALUE) > currMin){
                        ++currMin;
                        record.pollFirst();
                    }
                    map.remove(record.pollFirst());
                }
            }else{
                if(map.containsKey(item[1])) {
                    record.addLast(item[1]);
                    recordMap.put(item[1], index++);
                    list.add(map.get(item[1]));
                }else{
                    list.add(-1);
                }
            }
        }
        int[] rst = list.stream().mapToInt(Integer::valueOf).toArray();
        return rst;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        LRU lru = new LRU();
        System.out.println(Arrays.toString(lru.LRU(arr, 3)));
    }
}
