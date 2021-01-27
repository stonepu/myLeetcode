package Offer;

public class O17 {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10, n) - 1;
        int[] rst = new int[max];
        for(int i = 0; i < max; i++){
            rst[i] = i + 1;
        }
        return rst;

    }
}
