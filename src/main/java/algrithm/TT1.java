package algrithm;

import java.util.*;

public class TT1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int kLen = Integer.valueOf(k).toString().length();
        Solution3 solution3 = new Solution3(k, kLen);
        System.out.println(solution3.getNum(arr));
    }

    void test1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Solution1 solution1 = new Solution1();
        solution1.getNum1(str, 0, new StringBuffer());
        System.out.println(solution1.rst);
    }

    void test2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.getNum(arr));
    }
}

class Solution3 {
    int k;
    int kLen;

    public Solution3(int k, int kLen) {
        this.k = k;
        this.kLen = kLen;
    }

    public int getNum(int[] arr) {
        int rst = 0;
        for (int i : arr) {
            rst += check(i);
        }

        return rst;
    }

    public int check(int it) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= Math.sqrt(it); i++) {
            if (it % i == 0) {
                list.add(i);
            }
        }
        if (it * it != it) {
            list.add(it);
        }

        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(array);
        StringBuffer sb = new StringBuffer();
        for (int i : array) {
            sb.append(i);
        }

        return check(sb.toString());
    }

    public int check(String str) {
        int rst = 0;
        if (str.length() < kLen) {
            return 0;
        }

        for (int i = 0; i <= str.length() - kLen; i++) {
            if (Integer.parseInt(str.substring(i, i + kLen)) == k) {
                ++rst;
            }
        }

        return rst;
    }
}

class Solution2 {
    public HashSet<Integer> colSet = new HashSet<>();


    public int getNum(int[][] arr) {
        if (arr.length == 0) {
            return 1;
        }

        int row = 1, col = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                row++;
            } else {
                int colNum = arr[i][1];
                if(!colSet.contains(colNum + 180)){
                    col++;
                }
                colSet.add(colNum);
            }
        }

        return row * col;
    }
}

class Solution1 {
    HashSet<Character> set = new HashSet<>();

    public int rst = 0;

    public void getNum1(String str, int index, StringBuffer sb) {
        if (str.length() == 0) {
            rst = 1;
            return;
        }
        if (index == str.length()) {
            if (check(sb.toString())) {
                rst = (rst + 1) % 20210101;
            }
            return;
        }


        sb.append(str.charAt(index));
        getNum1(str, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        getNum1(str, index + 1, sb);

    }

    public boolean check(String str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                flag = false;
                break;
            } else {
                set.add(str.charAt(i));
            }
        }
        set.clear();
        return flag;
    }

//    public int getNum(String str) {
//        int len = str.length();
//        if(len == 0) {
//            return 1;
//        }
//        int rst = 0;
//
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < len; i++) {
//            if(!set.contains(sb.toString())) {
//                rst = (rst + 1) % 20210101;
//            }
////            sb.append()
//        }
//        return 0;
//    }

}
