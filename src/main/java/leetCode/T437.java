package leetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class T437 {
    private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        checkPath(root, sum, new LinkedList<>());
        return count;
    }

    public void checkPath(TreeNode root, int sum, List<Integer> list) {
        if(root == null) return;
        if(root.val == sum) count++;
        list = list.stream().map(item->{
            if(item + root.val == sum) ++count;
            return item + root.val;
        }).collect(Collectors.toList());

        list.add(root.val);
        checkPath(root.left, sum, list);
        checkPath(root.right, sum, list);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            if(iterator.)
//        }
        list.add(1);
        list.add(2);

        list = list.stream().map(it->{
            if(it == 1)
                System.out.println("hhh");
            return it + 1;
        }).collect(Collectors.toList());
        System.out.println(list.toString());
    }
}
