package algrithm;

import java.util.HashMap;
import java.util.Map;


//评测题目二：
// 小强从一副扑克牌里拿出来一叠，其中包括 A、2、3，...，10，其中A代表1，他从这一叠中抽出一些给小明，并告诉小明每次可以按下面方式出牌：
// 1、单牌，如一张2；
// 2、对子，如两张7；
// 3、顺子，如A12或34567，限制必须是3连或5连；
// 4、连子，数字连续的3个对子，如223344；
// 现在小强想知道最少出多少次牌，可以出完手中的牌；
// 输入描述：空格分隔的整数，A1、A2、A3，...，A10（0<取值<4），代表牌为 A，2，3，...，10 的个数；
// 输出描述：输出一个整数表示，最少出多少次牌；
// 提示：可在自己电脑执行后，给出验证通过的输入和输出；

public class CardGameTest {

    private Map<Long, Integer> map = new HashMap<>();

    {
        map.put(0L, 0);
    }


    private boolean checkFiveSeq(long ans, int i) {
        for (int j = 0; j < i - 4; j++) {
            ans /= 10;
        }
        for (int j = 0; j < 4; j++) {
            if (ans % 10 == 0)
            {
                return false;
            }
            ans /= 10;
        }
        return true;
    }

    private boolean checkThreeSeq(long ans, int i) {
        for (int j = 0; j < i - 2; j++) {
            ans /= 10;
        }
        for (int j = 0; j < 2; j++) {
            if (ans % 10 == 0)
            {
                return false;
            }
            ans /= 10;
        }
        return true;
    }

    private boolean checkThreePair(long ans, int i) {
        for (int j = 0; j < i - 2; j++) {
            ans /= 10;
        }
        for (int j = 0; j < 2; j++) {
            if (ans % 10 < 2)
            {
                return false;
            }
            ans /= 10;
        }
        if (ans % 10 < 1) {
            return false;
        }
        return true;
    }

    private int getMin(int a, int b, int c, int d, int e) {
        return Math.min(Math.min(Math.min(Math.min(a, b), c), d), e);
    }


    public int dfs(long key) {
        int[] card = new int[10];
        for (int i = 0; i < 10; i++) {
            card[i] = (int)key % 10;
            key /= 10;
        }
        key = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= card[i]; j++) {
                int single = map.get(key);

                int pair = key >= (int) Math.pow(10, i) ? map.get(key - (int) Math.pow(10, i)) : Integer.MAX_VALUE;

                int threePair = Integer.MAX_VALUE;
                if (i >= 2 && checkThreePair(key, i)) {
                    int tmp = (int) Math.pow(10, i) + 2 * (int) Math.pow(10, i - 1) + 2 * (int) Math.pow(10, i - 2);
                    threePair = dfs(key - tmp);
                }

                int tSeq = Integer.MAX_VALUE;
                if (i >= 2 && checkThreeSeq(key, i)) {
                    int tmp = (int) Math.pow(10, i - 1) + (int) Math.pow(10, i - 2);
                    tSeq = dfs(key - tmp);
                }

                int fSeq = Integer.MAX_VALUE;
                if (i >= 4 && checkFiveSeq(key, i)) {
                    int tmp = (int) Math.pow(10, i - 1) + (int) Math.pow(10, i - 2) + (int) Math.pow(10, i - 3) + (int) Math.pow(10, i - 4);
                    fSeq = dfs(key - tmp);
                }

                key += (int) Math.pow(10, i);
                map.put(key, getMin(single, pair, fSeq, threePair, tSeq) + 1);
            }
        }
        return map.get(key);
    }


    public static void main(String[] args) {
        CardGameTest cardGameTest = new CardGameTest();

        int[] arr1 = {1, 1, 1, 2, 2, 2, 2, 2, 1, 2};

        long key1 = 0;
        for(int i : arr1) {
            key1 *= 10;
            key1 += i;
        }

        System.out.println(cardGameTest.dfs(key1));

        int[] arr2 = {1, 1, 1, 2, 2, 2, 2, 2, 2, 2};

        long key2 = 0;

        for(int i : arr2) {
            key2 *= 10;
            key2 += i;
        }

        System.out.println(cardGameTest.dfs(key2));

    }
}



