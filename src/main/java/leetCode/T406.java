package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T406 {

    public int[][] reconstructQueue(int[][] people) {
        sort(people);
        List<Node> list = new LinkedList();
        list.add(new Node(people[0][0], people[0][1]));
        for(int i = 1; i < people.length; i++) {
            int more = people[i][1];
            int index = 0;
            while(index < list.size() && (more > 0 || list.get(index).val <= people[i][0])) {
                if(list.get(index).val >= people[i][0])
                    --more;
                ++index;
            }

            list.add(index, new Node(people[i][0], people[i][1]));
        }

        int[][] rst = new int[people.length][2];

        for(int i = 0; i < list.size(); i++) {
            rst[i][0] = list.get(i).val;
            rst[i][1] = list.get(i).pre;
        }

        return rst;
    }

    public void sort(int[][] people) {
        quickSort(people, 0, people.length - 1);
    }

    public void quickSort(int[][] people, int head, int tail){
        if(head >= tail) return;
        int tmpHead = head, tmpTail = tail;
        while(tmpHead < tmpTail) {
            while(tmpHead < tmpTail && less(people, tmpHead, tail)) {
                tmpHead++;
            }
            while(tmpHead < tmpTail && !less(people, tmpTail, tail)) {
                tmpTail--;
            }

            if(tmpHead == tmpTail) break;
            swap(people, tmpHead, tmpTail);
        }
        swap(people, tmpHead, tail);
        quickSort(people, head, tmpHead - 1);
        quickSort(people, tmpHead + 1, tail);
    }

    public void swap(int[][] people, int p, int q) {
        int tmp0 = people[p][0];
        int tmp1 = people[p][1];
        people[p][0] = people[q][0];
        people[p][1] = people[q][1];
        people[q][0] = tmp0;
        people[q][1] = tmp1;
    }

    public boolean less(int[][] people, int p, int q) {
        if(people[p][1] < people[q][1]) return true;
        else if(people[p][1] > people[q][1]) return false;
        else {
            if(people[p][0] < people[q][0]) return true;
            return false;
        }
    }

    private class Node{
        int val;
        int pre;
        public Node(int val, int pre) {
            this.val = val;
            this.pre = pre;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 1);

        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        T406 t406 = new T406();
        int[][] rst = t406.reconstructQueue(people);
        t406.sort(people);
        for(int[] arr: rst){
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     *
     * @param echo 回声
     * @param mixer 混音
     */
    void process(int echo, int mixer){}
}
