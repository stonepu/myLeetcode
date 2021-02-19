package bd;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 复习快速排序与归并排序，要手写，归并排序下次还要记得写，快速排序可以自己debug了，归并有点忘记了
 */
public class NC121 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        list.add(new String(arr));
        while (hasNext(arr)) {
            list.add(new String(arr));
        }

        return list;
    }

    private boolean hasNext(char[] arr) {
        if (arr.length <= 1) return false;
        //从右向左找到第一个左邻小于右邻的位置（左邻的位置）
        int lessIdx = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                lessIdx = i - 1;
                break;
            }
        }

        //如果没有找到，说明字典序已经最小
        if (lessIdx == -1) return false;

        //从右向左找到第一个数大于lessIdx的值
        int biggerIdx;
        for (biggerIdx = arr.length - 1; biggerIdx > lessIdx; biggerIdx--) {
            if (arr[biggerIdx] > arr[lessIdx]) {
                break;
            }
        }

        //交换2个index
        swap(arr, biggerIdx, lessIdx);

        //将lessIdx后面进行排序
        sort(arr, lessIdx + 1);

        return true;
    }

    public void swap(char[] arr, int p, int q) {
        char tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

    private void sort(char[] arr, int start) {
        if (start >= arr.length - 1) return;
        quickSort(arr, start, arr.length - 1);
    }

    private void quickSort(char[] arr, int start, int end) {
        if (start >= end) return;
        int head = start, tail = end;
        while (head < end) {
            while (arr[head] < arr[end] && head < tail) {
                ++head;
            }

            while (arr[tail] >= arr[end] && head < tail) {
                --tail;
            }

            if (head == tail) break;
            swap(arr, head, tail);
        }

        swap(arr, head, end);

        quickSort(arr, start, head - 1);
        quickSort(arr, head + 1, end);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int head = start, tail = end;
        while (head < tail) {
            while (arr[head] < arr[end] && head < tail) {
                ++head;
            }

            while (arr[tail] >= arr[end] && head < tail) {
                --tail;
            }

            if (head == tail) break;
            swap(arr, head, tail);
        }
        swap(arr, head, end);

        quickSort(arr, start, head - 1);
        quickSort(arr, head + 1, end);
    }

    public static void swap(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

    public static void mergeSort(int[] arr) {
        portion(arr, new int[arr.length], 0, arr.length - 1);
    }

    public static void portion(int[] arr, int[] copiedArr, int head, int tail) {
        if (head >= tail) return;
        int mid = head + (tail - head) / 2;
        portion(arr, copiedArr, head, mid);
        portion(arr, copiedArr, mid + 1, tail);
        merge(arr, copiedArr, head, mid, tail);
    }

    public static void merge(int[] arr, int[] copiedArr, int head, int mid, int tail) {
        int secondH = mid + 1;
        int firstH = head;
        int index = head;
        while (firstH <= mid && secondH <= tail) {
            if (arr[firstH] < arr[secondH]) {
                copiedArr[index++] = arr[firstH++];
            } else {
                copiedArr[index++] = arr[secondH++];
            }
        }

        while (firstH <= mid) {
            copiedArr[index++] = arr[firstH++];
        }

        while (secondH < tail) {
            copiedArr[index++] = arr[secondH++];
        }

        for(int i = head; i <= tail; i++) {
            arr[i] = copiedArr[i];
        }
    }

    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1};
////        quickSort(arr, 0, arr.length - 1);
//        mergeSort(arr);
//
//        System.out.println(Arrays.toString(arr));

        NC121 nc121 = new NC121();
    }
}
