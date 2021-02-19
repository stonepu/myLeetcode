package leetCode;

import java.util.Arrays;

public class T435 {

    private int conut = 0;

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 0) return 0;
        bubbleSort(intervals);


        int anchor = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[anchor][1]) {
                ++conut;
                anchor = intervals[i][1] >= intervals[anchor][1] ? anchor : i;
            } else {
                anchor = i;
            }
        }
        return conut;
    }

//    public void bubbleSort1(int[][] arr){
//        for(int i = arr.length - 1; i >= 0; i--) {
//            for(int j = 0; j)
//        }
//    }

    public void bubbleSort(int[][] arr) {
        for (int i = arr.length - 1; i > 0; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1][0] > arr[j][0]) {
                    exchange(arr, j - 1, j);
                } else if (arr[j - 1][0] == arr[j][0] && arr[j - 1][1] > arr[j][1]) {
                    exchange(arr, j - 1, j);
                }
            }
        }
    }

    public void insertSort(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j][0] < arr[j - 1][0]) {
                    exchange(arr, j, j - 1);
                } else if (arr[j][0] == arr[j - 1][0] && arr[j][1] < arr[j - 1][1]) {
                    exchange(arr, j, j - 1);
                }
            }
        }
    }

    public void selectSort(int[][] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j][0] < arr[index][0]) {
                    index = j;
                } else if (arr[j][0] == arr[index][0] && arr[j][1] < arr[index][1]) {
                    index = j;
                }
            }
            exchange(arr, index, i);
        }
    }

    public void shellSort(int[][] arr) {
        int h = arr.length / 2;
        while (h > 0) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < arr.length; j += h) {
                    for (int k = j; k >= h; k -= h) {
                        if (arr[k][0] < arr[k - h][0] || (arr[k][0] == arr[k - h][0] && arr[k][1] < arr[k - h][1])) {
                            exchange(arr, k, k - h);
                        }
                    }
                }
            }
            h /= 2;
        }
    }

    public void quickSort(int[][] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[][] arr, int head, int tail) {
        if (head >= tail) return;
        int mid = tail, first = head, last = tail;
        while (first < last) {
            while (first < last) {
                if (arr[first][0] > arr[mid][0] || (arr[first][0] == arr[mid][0] && arr[first][1] > arr[mid][1])) break;
                ++first;
            }

            while (first < last) {
                if (arr[last][0] < arr[mid][0] || (arr[last][0] == arr[mid][0] && arr[last][1] < arr[mid][1])) break;
                --last;
            }

            if (first == last) break;
            exchange(arr, first++, last--);
        }

        if (first == last) {
            if (arr[first][0] == arr[mid][0] && arr[first][1] == arr[mid][1]) mid = first;
            else if (arr[first][0] > arr[mid][0] || (arr[first][0] == arr[mid][0] && arr[first][1] > arr[mid][1])) {
                exchange(arr, mid, first);
                mid = first;
            } else {
                exchange(arr, mid, first + 1);
                mid = first + 1;
            }
        }

        quickSort(arr, head, mid - 1);
        quickSort(arr, mid + 1, tail);
    }

    public void mergeSort(int[][] arr) {
        int[][] tmpArr = new int[arr.length][arr[0].length];
        portion(arr, tmpArr, 0, arr.length - 1);
    }

    public void portion(int[][] dst, int[][] arr, int head, int tail) {
        if (head >= tail) return;
        int mid = head + (tail - head) / 2;
        portion(dst, arr, head, mid);
        portion(dst, arr, mid + 1, tail);
        merge(dst, arr, head, mid, tail);
    }

    public void merge(int[][] dst, int[][] arr, int head, int mid, int tail) {
        int first = head, last = tail;
        int tmpH = head, tmpT = mid + 1;
        int index = head;
        while (tmpH <= mid && tmpT <= tail) {
            if (less(dst, tmpH, tmpT)) {
                arr[index][0] = dst[tmpH][0];
                arr[index++][1] = dst[tmpH++][1];
            } else {
                arr[index][0] = dst[tmpT][0];
                arr[index++][1] = dst[tmpT++][1];
            }
        }

        while (tmpH <= mid) {
            arr[index][0] = dst[tmpH][0];
            arr[index++][1] = dst[tmpH++][1];
        }

        while (tmpT <= tail) {
            arr[index][0] = dst[tmpT][0];
            arr[index++][1] = dst[tmpT++][1];
        }

        for (int i = head; i <= tail; i++) {
            dst[i][0] = arr[i][0];
            dst[i][1] = arr[i][1];
        }
    }

    public boolean less(int[][] arr, int p, int q) {
        if (arr[p][0] < arr[q][0]) return true;
        else if (arr[p][0] == arr[q][0] && arr[p][1] < arr[q][1]) return true;
        return false;
    }


    public void exchange(int[][] arr, int p, int q) {
        int f = arr[p][0];
        int s = arr[p][1];
        arr[p][0] = arr[q][0];
        arr[p][1] = arr[q][1];
        arr[q][0] = f;
        arr[q][1] = s;
    }


    public void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                }
            }
        }
    }

    public void insertSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    exchange(arr, j, j - 1);
                }
            }
        }
    }

    public void selectSort(int[] arr) {
        int tmp = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[i];
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < tmp) {
                    tmp = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = tmp;
        }
    }

    public void shellSort(int[] arr) {
        int h = arr.length / 2;
        while (h > 0) {
            for (int i = 0; i < h; i++) {
                for (int j = i; j < arr.length; j += h) {
                    for (int k = j; k >= h; k -= h) {
                        if (arr[k] < arr[k - h]) {
                            exchange(arr, k, k - h);
                        }
                    }
                }
            }
            h /= 2;
        }
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int first, int last) {
        if (first >= last) return;
        int head = first, tail = last;
        while (head < tail) {
            while (head < tail) {
                if (arr[head] > arr[last]) {
                    break;
                }
                ++head;
            }

            while (tail > head) {
                if (arr[tail] < arr[last]) break;
                --tail;
            }

            if (tail == head) break;
            exchange(arr, tail, head);
        }

        exchange(arr, tail, last);
        quickSort(arr, first, head - 1);
        quickSort(arr, head + 1, last);
    }

    public void mergeSort(int[] dst) {
        int[] arr = new int[dst.length];
        portion(dst, arr, 0, dst.length - 1);
    }

    public void portion(int[] dst, int[] arr, int head, int tail) {
        if (head >= tail) return;
        int mid = head + (tail - head) / 2;
        portion(dst, arr, head, mid);
        portion(dst, arr, mid + 1, tail);
        merge(dst, arr, head, mid, tail);
    }

    public void merge(int[] dst, int[] arr, int head, int mid, int tail) {
        int tmpH = head;
        int tmpT = mid + 1;
        int index = head;
        while (tmpH <= mid && tmpT <= tail) {
            if (dst[tmpH] < dst[tmpT]) {
                arr[index++] = dst[tmpH++];
            } else {
                arr[index++] = dst[tmpT++];
            }
        }

        while (tmpH <= mid) {
            arr[index++] = dst[tmpH++];
        }

        while (tmpT <= tail) {
            arr[index++] = dst[tmpT++];
        }

        for (int i = head; i <= tail; i++) {
            dst[i] = arr[i];
        }
    }

    public void exchange(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

    public static void main(String[] args) {
        T435 t435 = new T435();
        int[] arr1 = {6, 5, 4, 3, 2, 1};
//        t435.bubbleSort(arr1);
//        t435.insertSort1(arr1);
//        t435.selectSort(arr1);
//        t435.shellSort(arr1);
//        t435.quickSort(arr1);
        t435.mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
