package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class T39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rst = new LinkedList<>();
        if(candidates.length <= 0) return rst;
        List<Integer> lsit = null;
        rst.add(new LinkedList<>(lsit));
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
    }


}
