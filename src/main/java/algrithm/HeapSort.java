package algrithm;

import java.util.Arrays;

/**
 * 该类中使用大根堆，如果使用小根堆的话方法类似，只是在比较的时候需要注意将大于与小于交换
 * 堆排序，注意堆的结构，完全二叉树，以及使用数组存储，父节点与子节点之间索引的关系
 * 如果要往堆中插入数据，需要使用上浮法，先将元素插入到数组的尾部，然后递归和其父节点比较，如果比父节点值大，则和父节点交换，直到找到小于父节点或者已经到达根节点为止
 */
public class HeapSort {

    public static void heapSort(int[] tree) {

        for (int i = tree.length - 1; i >= 0; i--) {
            swap(tree, 0, i);
            heapify(tree, i, 0);
        }
    }

    public static void buildTree(int[] tree, int n) {
        int parent = (n - 1) / 2;
        for(int i = parent; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    public static void heapify(int[] tree, int n, int i) {
        if (i >= n) return;

        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;

        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }

        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }

        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        buildTree(arr, 5);
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
