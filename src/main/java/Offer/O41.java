package Offer;

import java.util.*;

public class O41 {
    static class MedianFinder {

        private List<Integer> list;
        private PriorityQueue<Integer> queue;

        /** initialize your data structure here. */
        public MedianFinder() {
            list = new LinkedList();
            queue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(list.size() == 0) {
                list.add(num);
                return;
            }
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) >= num) {
                    list.add(i, num);
                    return;
                }
            }
            list.add(list.size(), num);
            queue.add(num);
        }

        public double findMedian() {
            System.out.println(list);
            int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
            int len = arr.length;
            System.out.println(Arrays.toString(arr));
            if(len % 2 != 0) return arr[len / 2];
            else return 1.0 * (arr[len / 2 - 1] + arr[len / 2]) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
