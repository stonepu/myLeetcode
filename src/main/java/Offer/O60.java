package Offer;

import java.util.Arrays;

public class O60 {
    public double[] dicesProbability(int n) {
        double[][] rst = new double[n][6 * n];
        for(int i = 0; i < 6; i++) {
            rst[0][i] = 1.0 / 6;
        }

        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j <= (i + 1) * 6; j++) {
                int k = j > i + 6 ? j - 6 : i;
                for(; k < j; k++) {
                    rst[i][j - 1] += rst[i - 1][k - 1] * 1.0 / 6;
                }
            }
        }

        double[] arr = new double[n * 6 - n + 1];
        for (int i = 0; i < n * 5 + 1; i++) {
            arr[i] = rst[n - 1][i + n - 1];
        }

        return arr;

    }

    public static void main(String[] args) {
        O60 o60 = new O60();
        System.out.println(Arrays.toString(o60.dicesProbability(3)));
    }
}
