package algrithm;

import java.util.*;

public class HW {

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String[] split = firstLine.split(",");
        int[] array = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(i, i);
        }

        String secondLine = sc.nextLine();
        HashMap<Integer, HashSet<Integer>> dependency = new HashMap<>();
        String[] split1 = secondLine.split(",");
        for (String s : split1) {
            if(s.length() > 0) {
                String[] split2 = s.split("->");
                Integer i1 = Integer.valueOf(split2[0]);
                Integer i2 = Integer.valueOf(split2[1]);
                HashSet<Integer> set = dependency.getOrDefault(i1, new HashSet<Integer>());
                set.add(i2);
                dependency.put(i1, set);
            }
        }
        //1,3,4,5,8,5,3,6
        //0->2,2->4,2->6
        SolutionH2 solutionH2 = new SolutionH2();
        int[] time = solutionH2.getTime(array, map, dependency);
        for (int i = 0; i < time.length - 1; i++) {
            System.out.printf(time[i] + ",");
        }
        System.out.printf("" + time[time.length - 1]);
//        System.out.println(map);


    }


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int index = 0;
        HashMap<String, Integer> nameMap = new HashMap<>();
        SolutionH1 s1 = new SolutionH1();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            String[] strings = str.split(" ");
            int i1 = nameMap.getOrDefault(strings[0], index++);
            nameMap.put(strings[0], i1);

            int i2 = nameMap.getOrDefault(strings[1], index++);
            nameMap.put(strings[1], i2);
            s1.add(i1, i2);
        }

        System.out.println(s1.getMaxGroup());
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int t = sc.nextInt();

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = sc.nextInt();
            }
        }
        SolutionH3 s3 = new SolutionH3(dp);
        s3.getMaxStep(row - 1, col - 1, t);
        int rst = s3.maxStep == -1 ? -1 : t - s3.maxStep;
        System.out.println(rst);

    }

}

class SolutionH3{
    int maxStep = -1;
    int[][] dp;
    public SolutionH3(int[][] dp) {
        this.dp = dp;
    }
    public void getMaxStep(int row, int col, int target) {
        int curr = target - dp[row][col];
        if(curr < 0) {
            return;
        }
        if(row == 0 && col == 0) {
            maxStep = maxStep == -1 ? curr : Math.min(maxStep, curr);
        }

        if(row > 0) {
            getMaxStep(row - 1, col, curr);
        }

        if(col > 0) {
            getMaxStep(row, col - 1, curr);
        }
    }
}

class SolutionH1{
    HashSet<Integer> studentSet = new HashSet<>();
    HashMap<Integer, Integer> sameGroup = new HashMap<>();
    public int getMaxGroup() {
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : sameGroup.keySet()) {
            set.add(sameGroup.get(integer));
        }
        return set.size();
    }

    public void add(int s1, int s2) {
        if(!studentSet.contains(s1) && !studentSet.contains(s2)) {
            sameGroup.put(s1, s2);
        }else{
            if(sameGroup.containsValue(s1)) {
                update(s1, s2);
            }else if(sameGroup.containsValue(s2)){
                update(s2, s1);
            }else if(sameGroup.containsKey(s1)) {
                update(sameGroup.get(s1), s2);
            }else{
                update(sameGroup.get(s2), s1);
            }
        }

        studentSet.add(s1);
        studentSet.add(s2);
    }

    public void update(int parent, int s) {
        if(!sameGroup.containsKey(s)) {
            sameGroup.put(s, parent);
            return;
        }
        if(sameGroup.get(s) == parent) {
            return;
        }

        int next = sameGroup.get(s);
        sameGroup.put(s, parent);
        update(parent, next);
    }
}

class SolutionH2{
    int index = 0;
    HashSet<Integer> finished = new HashSet<>();
    public int[] getTime(int[] nums, HashMap<Integer, Integer> map, HashMap<Integer, HashSet<Integer>> dependency) {
        int[] rst = new int[map.entrySet().size()];
        int i = 0;
        index = rst.length;
        int curr = 0;
        while(null != map.get(i)) {
            if(!dependency.containsKey(map.get(i)) || check(dependency.get(map.get(i)), finished)) {
                curr += nums[map.get(i)];
                rst[map.get(i)]  = curr;
                finished.add(map.get(i));
            }else{
//                System.out.println("" + index + "==" + i);
                map.put(index++, map.get(i));
            }
            i++;
//            System.out.println(map);
        }
        return rst;
    }

    public boolean check(HashSet<Integer> src, HashSet<Integer> dst) {
//        System.out.println("map" + src);
        if(src.isEmpty()) {
            return true;
        }

        for (Integer integer : src) {
            if(!dst.contains(integer)) {
                return false;
            }
        }

        return true;
    }
}
