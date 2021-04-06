package leetCode;

import java.util.*;

public class T90 {
    private List<List<Integer>> rst = new LinkedList<>();

    /**
     * 时间复杂度O(n*2^n)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        addItem(new LinkedList<Integer>(), 0, nums, true);
        return new LinkedList<>(rst);
    }

    private void addItem(List<Integer> list, int index, int[] nums, boolean addPre) {
        if(index == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        //TODO 这里需要注意，如何去重，当前位置和前一个位置元素相同时，且在该分支下前一个元素没有加入，则直接放弃该分支的加入操作，
        // 因为在其他分支中有加入前一个元素，这样可以避免重复
        addItem(list, index + 1, nums, false);
        if(!addPre && index > 0 && nums[index - 1] == nums[index]) {
            return;
        }

        list.add(nums[index]);
        addItem(list, index + 1, nums, true);
        list.remove(list.size() - 1);
    }

    /**
     * 时间复杂度O(n*2^n)
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> cl = new LinkedList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) {
                    //TODO 这里很重要，表达的意思和之前是一样的。
                    if(i > 0 && ((mask >> (i - 1)) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    cl.add(nums[i]);
                }
            }
            if(flag) {
                list.add(new LinkedList<>(cl));
            }
            cl.clear();
        }
        return list;
    }



    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(i);
//        }
//
//        Integer[] arr = list.toArray(new Integer[list.size()]);
        int[] nums = {1, 2 ,2};
        T90 t90 = new T90();
        System.out.println(t90.subsetsWithDup1(nums));
    }
}
